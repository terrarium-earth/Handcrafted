package earth.terrarium.handcrafted.client.fabric;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.Supplier;

public class HandcraftedClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandcraftedClient.initializeClient();
        HandcraftedClient.onRegisterItemRenderers(HandcraftedClientFabric::registerItemRenderer);
        HandcraftedClient.onRegisterBlockRenderTypes(HandcraftedClientFabric::registerBlockRenderTypes);
        HandcraftedClient.registerEntityLayers(new HandcraftedClient.LayerDefinitionRegistry() {
            @Override
            public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
                EntityModelLayerRegistry.registerModelLayer(location, definition::get);
            }
        });
        HandcraftedClient.registerEntityRenderers(new HandcraftedClient.EntityRendererRegistry() {
            @Override
            protected <T extends Entity> void register(RegistryEntry<? extends EntityType<? extends T>> type, EntityRendererProvider<T> factory) {
                EntityRendererRegistry.register(type.get(), factory);
            }
        });
        HandcraftedClient.registerBlockRenderers(new HandcraftedClient.BlockRendererRegistry() {
            @Override
            public <T extends BlockEntity> void register(RegistryEntry<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory) {
                BlockEntityRendererRegistry.register(type.get(), factory);
            }
        });
    }

    private static void registerBlockRenderTypes(RenderType type, List<Block> blocks) {
        BlockRenderLayerMap.INSTANCE.putBlocks(type, blocks.toArray(new Block[0]));
    }

    private static void registerItemRenderer(ItemLike item, BlockEntityWithoutLevelRenderer renderer) {
        BuiltinItemRendererRegistry.INSTANCE.register(item.asItem(), renderer::renderByItem);
    }
}
