package earth.terrarium.handcrafted.client.fabric;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import earth.terrarium.handcrafted.client.utils.ClientPlatformUtils;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class HandcraftedClientFabric {

    public static void init() {
        HandcraftedClient.init();
        HandcraftedClient.onRegisterBlockRenderers(new ClientPlatformUtils.BlockRendererRegistry() {
            @Override
            public <T extends BlockEntity> void register(RegistryEntry<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory) {
                BlockEntityRenderers.register(type.get(), factory);
            }
        });
        HandcraftedClient.onRegisterEntityLayers((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get));
        registerBlockRenderLayers();
    }

    private static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BERRY_JAM_JAR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STACKABLE_BOOK.get(), RenderType.cutout());

        registerBlockRenderLayer(ModBlocks.BENCHES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.COUCHES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.CHAIRS, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.DINING_BENCHES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.SIDE_TABLES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.DESKS, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.NIGHTSTANDS, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.TABLES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.SHELVES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.POTS, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.TROPHIES, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.CROCKERY, RenderType.cutout());
        registerBlockRenderLayer(ModBlocks.FANCY_BEDS, RenderType.cutout());
    }

    private static void registerBlockRenderLayer(ResourcefulRegistry<Block> registry, RenderType type) {
        registry.stream().forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), type));
    }
}
