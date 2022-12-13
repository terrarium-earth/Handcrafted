package earth.terrarium.handcrafted.client;

import earth.terrarium.handcrafted.client.block.chair.bench.BenchModel;
import earth.terrarium.handcrafted.client.block.chair.bench.BenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.chair.ChairModel;
import earth.terrarium.handcrafted.client.block.chair.chair.ChairRenderer;
import earth.terrarium.handcrafted.client.block.chair.couch.CouchModel;
import earth.terrarium.handcrafted.client.block.chair.couch.CouchRenderer;
import earth.terrarium.handcrafted.client.block.chair.tablebench.TableBenchModel;
import earth.terrarium.handcrafted.client.block.chair.tablebench.TableBenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.woodenbench.WoodenBenchModel;
import earth.terrarium.handcrafted.client.block.chair.woodenbench.WoodenBenchRenderer;
import earth.terrarium.handcrafted.client.block.counter.CounterModel;
import earth.terrarium.handcrafted.client.block.counter.CounterRenderer;
import earth.terrarium.handcrafted.client.block.counter.ShelfRenderer;
import earth.terrarium.handcrafted.client.block.crockery.CrockeryRenderer;
import earth.terrarium.handcrafted.client.block.fancybed.FancyBedModel;
import earth.terrarium.handcrafted.client.block.fancybed.FancyBedRenderer;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookModel;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookRenderer;
import earth.terrarium.handcrafted.client.block.statue.StatueModel;
import earth.terrarium.handcrafted.client.block.statue.StatueRenderer;
import earth.terrarium.handcrafted.client.block.table.desk.DeskModel;
import earth.terrarium.handcrafted.client.block.table.desk.DeskRenderer;
import earth.terrarium.handcrafted.client.block.table.nightstand.NightstandModel;
import earth.terrarium.handcrafted.client.block.table.nightstand.NightstandRenderer;
import earth.terrarium.handcrafted.client.block.table.side_table.SideTableModel;
import earth.terrarium.handcrafted.client.block.table.side_table.SideTableRenderer;
import earth.terrarium.handcrafted.client.block.table.table.TableModel;
import earth.terrarium.handcrafted.client.block.table.table.TableRenderer;
import earth.terrarium.handcrafted.client.entity.fancypainting.FancyPaintingModel;
import earth.terrarium.handcrafted.client.entity.fancypainting.FancyPaintingRenderer;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class HandcraftedClient {
    public static void initializeClient() {
    }

    public static void onRegisterItemRenderers(BiConsumer<ItemLike, BlockEntityWithoutLevelRenderer> register) {
        register.accept(ModItems.BENCH.get(), new BenchRenderer.ItemRenderer());
        register.accept(ModItems.FROZEN_BENCH.get(), new BenchRenderer.ItemRenderer());
        register.accept(ModItems.ACACIA_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.OAK_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_BENCH.get(), new WoodenBenchRenderer.ItemRenderer());

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

        register.accept(ModItems.ACACIA_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.OAK_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_CHAIR.get(), new ChairRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_CHAIR.get(), new ChairRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.OAK_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_FANCY_BED.get(), new FancyBedRenderer.ItemRenderer());

        register.accept(ModItems.WITCH_TROPHY.get(), new StatueRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.OAK_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_TABLE.get(), new TableRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_TABLE.get(), new TableRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.OAK_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_NIGHTSTAND.get(), new NightstandRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.OAK_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_DESK.get(), new DeskRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_DESK.get(), new DeskRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.OAK_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_SIDE_TABLE.get(), new SideTableRenderer.ItemRenderer());

        register.accept(ModItems.ACACIA_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.BIRCH_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.DARK_OAK_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.JUNGLE_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.MANGROVE_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.OAK_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.SPRUCE_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.CRIMSON_COUNTER.get(), new CounterRenderer.ItemRenderer());
        register.accept(ModItems.WARPED_COUNTER.get(), new CounterRenderer.ItemRenderer());
    }

    public static void registerBlockRenderers(BlockRendererRegistry registry) {
        registry.register(ModBlockEntities.BENCH, BenchRenderer::new);
        registry.register(ModBlockEntities.COUCH, CouchRenderer::new);
        registry.register(ModBlockEntities.WOODEN_BENCH, WoodenBenchRenderer::new);
        registry.register(ModBlockEntities.TABLE_BENCH, TableBenchRenderer::new);
        registry.register(ModBlockEntities.CHAIR, ChairRenderer::new);
        registry.register(ModBlockEntities.FANCY_BED, FancyBedRenderer::new);
        registry.register(ModBlockEntities.STACKABLE_BOOK, StackableBookRenderer::new);
        registry.register(ModBlockEntities.STATUE, StatueRenderer::new);
        registry.register(ModBlockEntities.TABLE, TableRenderer::new);
        registry.register(ModBlockEntities.NIGHTSTAND, NightstandRenderer::new);
        registry.register(ModBlockEntities.DESK, DeskRenderer::new);
        registry.register(ModBlockEntities.SIDE_TABLE, SideTableRenderer::new);
        registry.register(ModBlockEntities.CROCKERY, CrockeryRenderer::new);
        registry.register(ModBlockEntities.SHELF, ShelfRenderer::new);
        registry.register(ModBlockEntities.COUNTER, CounterRenderer::new);
    }

    public static void registerEntityLayers(LayerDefinitionRegistry registry) {
        BenchModel.register(registry);
        WoodenBenchModel.register(registry);
        CouchModel.register(registry);
        TableBenchModel.register(registry);
        ChairModel.register(registry);
        FancyBedModel.register(registry);
        StackableBookModel.register(registry);
        StatueModel.register(registry);
        TableModel.register(registry);
        NightstandModel.register(registry);
        DeskModel.register(registry);
        SideTableModel.register(registry);
        CounterModel.register(registry);

        FancyPaintingModel.register(registry);
    }

    public static void registerEntityRenderers(EntityRendererRegistry registry) {
        registry.register(ModEntityTypes.FANCY_PAINTING, FancyPaintingRenderer::new);
        registry.register(ModEntityTypes.SEAT, NoopRenderer::new);
    }

    public static void onRegisterBlockRenderTypes(BiConsumer<RenderType, List<Block>> register) {
        register.accept(RenderType.cutout(), List.of(ModBlocks.BERRY_JAM_JAR.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.WHITE_CUP.get(), ModBlocks.YELLOW_CUP.get(), ModBlocks.BLUE_CUP.get(), ModBlocks.WOOD_CUP.get(), ModBlocks.CLAY_CUP.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.WHITE_BOWL.get(), ModBlocks.YELLOW_BOWL.get(), ModBlocks.BLUE_BOWL.get(), ModBlocks.WOOD_BOWL.get(), ModBlocks.CLAY_BOWL.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.WHITE_CROCKERY_COMBO.get(), ModBlocks.YELLOW_CROCKERY_COMBO.get(), ModBlocks.BLUE_CROCKERY_COMBO.get(), ModBlocks.WOOD_CROCKERY_COMBO.get(), ModBlocks.CLAY_CROCKERY_COMBO.get()));
        register.accept(RenderType.cutout(), List.of(ModBlocks.BEAR_TROPHY.get(), ModBlocks.BLAZE_TROPHY.get(), ModBlocks.FOX_TROPHY.get(), ModBlocks.GOAT_TROPHY.get(), ModBlocks.PUFFERFISH_TROPHY.get(), ModBlocks.SALMON_TROPHY.get(), ModBlocks.SILVERFISH_TROPHY.get(), ModBlocks.SKELETON_HORSE_TROPHY.get(), ModBlocks.SPIDER_TROPHY.get(), ModBlocks.TROPICAL_FISH_TROPHY.get(), ModBlocks.WITHER_SKELETON_TROPHY.get(), ModBlocks.WOLF_TROPHY.get(), ModBlocks.PHANTOM_TROPHY.get(), ModBlocks.CREEPER_TROPHY.get(), ModBlocks.SKELETON_TROPHY.get(), ModBlocks.EVOKER_TROPHY.get(), ModBlocks.PILLAGER_TROPHY.get(), ModBlocks.VINDICATOR_TROPHY.get()));
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
