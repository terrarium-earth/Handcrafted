package earth.terrarium.handcrafted.forge;

import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class HandcraftedClientForge {
    private static final Map<Item, BlockEntityWithoutLevelRenderer> ITEM_RENDERERS = new HashMap<>();
    private static boolean hasInitializedRenderers = false;

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(HandcraftedClientForge::modelLoading);
        bus.addListener(HandcraftedClientForge::onRegisterRenderers);
    }

    public static void postInit() {
        HandcraftedClient.onRegisterItemRenderers(HandcraftedClientForge::registerItemRenderer);
        HandcraftedClient.onRegisterBlockRenderTypes(HandcraftedClientForge::onRegisterBlockRenderTypes);
        hasInitializedRenderers = true;
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        HandcraftedClient.registerBlockRenderers(new HandcraftedClient.BlockRendererRegistry() {
            @Override
            public <T extends BlockEntity> void register(Supplier<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory) {
                event.registerBlockEntityRenderer(type.get(), factory);
            }
        });
    }

    public static void modelLoading(ModelEvent.RegisterAdditional event) {
        HandcraftedClient.onRegisterModels(event::register);
    }

    public static BlockEntityWithoutLevelRenderer getItemRenderer(ItemLike item) {
        return ITEM_RENDERERS.get(item.asItem());
    }

    private static void registerItemRenderer(ItemLike item, BlockEntityWithoutLevelRenderer renderer) {
        ITEM_RENDERERS.put(item.asItem(), renderer);
    }

    private static void onRegisterBlockRenderTypes(RenderType type, List<Block> blocks) {
        blocks.forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, type));
    }

    public static boolean hasInitializedRenderers() {
        return hasInitializedRenderers;
    }
}
