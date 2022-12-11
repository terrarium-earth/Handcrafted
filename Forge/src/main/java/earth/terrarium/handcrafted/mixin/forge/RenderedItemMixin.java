package earth.terrarium.handcrafted.mixin.forge;

import earth.terrarium.handcrafted.forge.HandcraftedClientForge;
import earth.terrarium.handcrafted.common.item.RenderedBlockItem;
import earth.terrarium.handcrafted.common.item.RenderedItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin({RenderedItem.class, RenderedBlockItem.class})
public abstract class RenderedItemMixin extends Item {

    public RenderedItemMixin(Properties settings) {
        super(settings);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        Item item = this;

        consumer.accept(new IClientItemExtensions() {
            private BlockEntityWithoutLevelRenderer renderer = null;
            private boolean hasCheckedSinceInit = false;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (HandcraftedClientForge.hasInitializedRenderers() && !hasCheckedSinceInit) {
                    renderer = HandcraftedClientForge.getItemRenderer(item);
                    hasCheckedSinceInit = true;
                }
                return renderer == null ? IClientItemExtensions.super.getCustomRenderer() : renderer;
            }
        });
    }
}
