package earth.terrarium.handcrafted.mixin.forge;

import earth.terrarium.handcrafted.forge.HandcraftedClientForge;
import earth.terrarium.handcrafted.item.ModRenderedBlockItem;
import earth.terrarium.handcrafted.item.ModRenderedItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin({ModRenderedItem.class, ModRenderedBlockItem.class})
public abstract class ModRenderedItemMixin extends Item {

    public ModRenderedItemMixin(Properties settings) {
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
