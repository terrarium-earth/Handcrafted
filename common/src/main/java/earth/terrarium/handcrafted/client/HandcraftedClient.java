package earth.terrarium.handcrafted.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.client.block.chair.bench.BenchModel;
import earth.terrarium.handcrafted.client.block.chair.bench.MetalBenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.chair.ChairModel;
import earth.terrarium.handcrafted.client.block.chair.chair.ChairRenderer;
import earth.terrarium.handcrafted.client.block.chair.couch.CouchModel;
import earth.terrarium.handcrafted.client.block.chair.couch.CouchRenderer;
import earth.terrarium.handcrafted.client.block.chair.diningbench.DiningBenchModel;
import earth.terrarium.handcrafted.client.block.chair.diningbench.DiningBenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.woodenbench.BenchRenderer;
import earth.terrarium.handcrafted.client.block.chair.woodenbench.WoodenBenchModel;
import earth.terrarium.handcrafted.client.block.counter.CounterModel;
import earth.terrarium.handcrafted.client.block.counter.CounterRenderer;
import earth.terrarium.handcrafted.client.block.counter.ShelfRenderer;
import earth.terrarium.handcrafted.client.block.crockery.CrockeryRenderer;
import earth.terrarium.handcrafted.client.block.fancybed.FancyBedModel;
import earth.terrarium.handcrafted.client.block.fancybed.FancyBedRenderer;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookModel;
import earth.terrarium.handcrafted.client.block.stackablebook.StackableBookRenderer;
import earth.terrarium.handcrafted.client.block.statue.StatueBlockRenderer;
import earth.terrarium.handcrafted.client.block.statue.StatueEntityRenderer;
import earth.terrarium.handcrafted.client.block.statue.StatueModel;
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
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
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
        ModItems.WOODEN_BENCHES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new BenchRenderer.ItemRenderer()));
        ModItems.METAL_BENCHES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new MetalBenchRenderer.ItemRenderer()));
        ModItems.COUCHES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new CouchRenderer.ItemRenderer()));
        ModItems.DINING_BENCHES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new DiningBenchRenderer.ItemRenderer()));
        ModItems.CHAIRS.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new ChairRenderer.ItemRenderer()));
        ModItems.FANCY_BEDS.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new FancyBedRenderer.ItemRenderer()));
        ModItems.TABLES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new TableRenderer.ItemRenderer()));
        ModItems.NIGHTSTANDS.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new NightstandRenderer.ItemRenderer()));
        ModItems.DESKS.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new DeskRenderer.ItemRenderer()));
        ModItems.SIDE_TABLES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new SideTableRenderer.ItemRenderer()));
        ModItems.COUNTERS.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new CounterRenderer.ItemRenderer()));
        ModItems.STATUE_TROPHY_ENTITIES.stream().map(RegistryEntry::get).forEach(i -> register.accept(i, new StatueEntityRenderer.ItemRenderer()));
    }

    public static void registerBlockRenderers(BlockRendererRegistry registry) {
        registry.register(ModBlockEntityTypes.METAL_BENCH, MetalBenchRenderer::new);
        registry.register(ModBlockEntityTypes.COUCH, CouchRenderer::new);
        registry.register(ModBlockEntityTypes.BENCH, BenchRenderer::new);
        registry.register(ModBlockEntityTypes.DINING_BENCH, DiningBenchRenderer::new);
        registry.register(ModBlockEntityTypes.CHAIR, ChairRenderer::new);
        registry.register(ModBlockEntityTypes.FANCY_BED, FancyBedRenderer::new);
        registry.register(ModBlockEntityTypes.STACKABLE_BOOK, StackableBookRenderer::new);
        registry.register(ModBlockEntityTypes.STATUE_ENTITY, StatueEntityRenderer::new);
        registry.register(ModBlockEntityTypes.STATUE_BLOCK, StatueBlockRenderer::new);
        registry.register(ModBlockEntityTypes.TABLE, TableRenderer::new);
        registry.register(ModBlockEntityTypes.NIGHTSTAND, NightstandRenderer::new);
        registry.register(ModBlockEntityTypes.DESK, DeskRenderer::new);
        registry.register(ModBlockEntityTypes.SIDE_TABLE, SideTableRenderer::new);
        registry.register(ModBlockEntityTypes.CROCKERY, CrockeryRenderer::new);
        registry.register(ModBlockEntityTypes.SHELF, ShelfRenderer::new);
        registry.register(ModBlockEntityTypes.COUNTER, CounterRenderer::new);
    }

    public static void registerEntityLayers(LayerDefinitionRegistry registry) {
        BenchModel.register(registry);
        WoodenBenchModel.register(registry);
        CouchModel.register(registry);
        DiningBenchModel.register(registry);
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
        register.accept(RenderType.cutout(), ModBlocks.CROCKERY.stream().map(RegistryEntry::get).toList());
        register.accept(RenderType.cutout(), ModBlocks.TROPHIES.stream().map(RegistryEntry::get).toList());
    }

    public static abstract class BlockRendererRegistry {
        public abstract <T extends BlockEntity> void register(RegistryEntry<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory);
    }

    public static abstract class EntityRendererRegistry {
        protected abstract <T extends Entity> void register(RegistryEntry<? extends EntityType<? extends T>> type, EntityRendererProvider<T> factory);
    }

    public static abstract class LayerDefinitionRegistry {
        public abstract void register(ModelLayerLocation location, Supplier<LayerDefinition> definition);
    }
}
