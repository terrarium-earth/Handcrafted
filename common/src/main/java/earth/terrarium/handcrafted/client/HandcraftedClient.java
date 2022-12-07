package earth.terrarium.handcrafted.client;

import earth.terrarium.handcrafted.client.block.chair.couch.CouchModel;
import earth.terrarium.handcrafted.client.block.chair.couch.CouchRenderer;
import earth.terrarium.handcrafted.client.block.chair.gardenbench.GardenBenchModel;
import earth.terrarium.handcrafted.client.block.chair.gardenbench.GardenBenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.tablebench.TableBenchModel;
import earth.terrarium.handcrafted.client.block.chair.tablebench.TableBenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.tablechair.TableChairModel;
import earth.terrarium.handcrafted.client.block.chair.tablechair.TableChairRenderer;
import earth.terrarium.handcrafted.client.block.chair.woodengardenbench.WoodenGardenBenchModel;
import earth.terrarium.handcrafted.client.block.chair.woodengardenbench.WoodenGardenBenchRenderer;
import earth.terrarium.handcrafted.client.block.specialbed.SpecialBedModel;
import earth.terrarium.handcrafted.client.block.specialbed.SpecialBedRenderer;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookModel;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookRenderer;
import earth.terrarium.handcrafted.client.entity.fancypainting.FancyPaintingModel;
import earth.terrarium.handcrafted.client.entity.fancypainting.FancyPaintingRenderer;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import earth.terrarium.handcrafted.registry.ModBlocks;
import earth.terrarium.handcrafted.registry.ModEntityTypes;
import earth.terrarium.handcrafted.registry.ModItems;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class HandcraftedClient {
    public static void initializeClient() {
    }

    public static void onRegisterItemRenderers(BiConsumer<ItemLike, BlockEntityWithoutLevelRenderer> register) {
        register.accept(ModItems.GARDEN_BENCH.get(), new GardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.FROZEN_GARDEN_BENCH.get(), new GardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.ACACIA_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.OAK_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_GARDEN_BENCH.get(), new WoodenGardenBenchRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.OAK_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_COUCH.get(), new CouchRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_COUCH.get(), new CouchRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.OAK_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_TABLE_BENCH.get(), new TableBenchRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.OAK_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_TABLE_CHAIR.get(), new TableChairRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.OAK_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_SPECIAL_BED.get(), new SpecialBedRenderer.ItemRenderer());
    }

    public static void registerBlockRenderers(BlockRendererRegistry registry) {
        registry.register(ModBlockEntities.GARDEN_BENCH, GardenBenchRenderer::new);
        registry.register(ModBlockEntities.COUCH, CouchRenderer::new);
        registry.register(ModBlockEntities.WOODEN_GARDEN_BENCH, WoodenGardenBenchRenderer::new);
        registry.register(ModBlockEntities.TABLE_BENCH, TableBenchRenderer::new);
        registry.register(ModBlockEntities.TABLE_CHAIR, TableChairRenderer::new);
        registry.register(ModBlockEntities.SPECIAL_BED, SpecialBedRenderer::new);
        registry.register(ModBlockEntities.STACKABLE_BOOK, StackableBookRenderer::new);
    }

    public static void registerEntityLayers(LayerDefinitionRegistry registry) {
        GardenBenchModel.register(registry);
        WoodenGardenBenchModel.register(registry);
        CouchModel.register(registry);
        TableBenchModel.register(registry);
        TableChairModel.register(registry);
        SpecialBedModel.register(registry);
        StackableBookModel.register(registry);

        FancyPaintingModel.register(registry);
    }

    public static void registerEntityRenderers(EntityRendererRegistry registry) {
        registry.register(ModEntityTypes.FANCY_PAINTING, FancyPaintingRenderer::new);
    }

    public static void onRegisterModels(Consumer<ResourceLocation> register) {
    }

    public static void onRegisterBlockRenderTypes(BiConsumer<RenderType, List<Block>> register) {
        register.accept(RenderType.cutout(), List.of(ModBlocks.BERRY_JAM_JAR.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.GLASS_CUP.get(), ModBlocks.YELLOW_CUP.get(), ModBlocks.BLUE_CUP.get(), ModBlocks.WOOD_CUP.get(), ModBlocks.CLAY_CUP.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.GLASS_BOWL.get(), ModBlocks.YELLOW_BOWL.get(), ModBlocks.BLUE_BOWL.get(), ModBlocks.WOOD_BOWL.get(), ModBlocks.CLAY_BOWL.get()));
    }

    public static abstract class BlockRendererRegistry {
        public abstract <T extends BlockEntity> void register(Supplier<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory);
    }

    public static abstract class EntityRendererRegistry {
        protected abstract <T extends Entity> void register(Supplier<? extends EntityType<? extends T>> type, EntityRendererProvider<T> factory);
    }

    public static abstract class LayerDefinitionRegistry {
        public abstract void register(ModelLayerLocation location, Supplier<LayerDefinition> definition);
    }
}
