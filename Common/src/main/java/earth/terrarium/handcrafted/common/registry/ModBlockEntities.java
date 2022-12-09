package earth.terrarium.handcrafted.common.registry;

import earth.terrarium.handcrafted.common.block.chair.bench.BenchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.chair.ChairBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.couch.CouchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.tablebench.TableBenchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.woodenbench.WoodenBenchBlockEntity;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlockEntity;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlockEntity;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlockEntity;
import earth.terrarium.handcrafted.common.block.table.desk.DeskBlockEntity;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlockEntity;
import earth.terrarium.handcrafted.common.block.table.side_table.SideTableBlockEntity;
import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final Supplier<BlockEntityType<StackableBookBlockEntity>> STACKABLE_BOOK = register("stackable_book", () -> ModRegistryHelpers.createBlockEntityType(StackableBookBlockEntity::new, ModBlocks.STACKABLE_BOOK.get()));
    public static final Supplier<BlockEntityType<ChairBlockEntity>> CHAIR = register("chair", () -> ModRegistryHelpers.createBlockEntityType(ChairBlockEntity::new, ModBlocks.ACACIA_CHAIR.get(), ModBlocks.BIRCH_CHAIR.get(), ModBlocks.DARK_OAK_CHAIR.get(), ModBlocks.JUNGLE_CHAIR.get(), ModBlocks.MANGROVE_CHAIR.get(), ModBlocks.OAK_CHAIR.get(), ModBlocks.SPRUCE_CHAIR.get(), ModBlocks.CRIMSON_CHAIR.get(), ModBlocks.WARPED_CHAIR.get()));
    public static final Supplier<BlockEntityType<TableBlockEntity>> TABLE = register("table", () -> ModRegistryHelpers.createBlockEntityType(TableBlockEntity::new, ModBlocks.ACACIA_TABLE.get(), ModBlocks.BIRCH_TABLE.get(), ModBlocks.DARK_OAK_TABLE.get(), ModBlocks.JUNGLE_TABLE.get(), ModBlocks.MANGROVE_TABLE.get(), ModBlocks.OAK_TABLE.get(), ModBlocks.SPRUCE_TABLE.get(), ModBlocks.CRIMSON_TABLE.get(), ModBlocks.WARPED_TABLE.get()));
    public static final Supplier<BlockEntityType<WoodenBenchBlockEntity>> WOODEN_BENCH = register("wooden_bench", () -> ModRegistryHelpers.createBlockEntityType(WoodenBenchBlockEntity::new, ModBlocks.ACACIA_BENCH.get(), ModBlocks.BIRCH_BENCH.get(), ModBlocks.DARK_OAK_BENCH.get(), ModBlocks.JUNGLE_BENCH.get(), ModBlocks.MANGROVE_BENCH.get(), ModBlocks.OAK_BENCH.get(), ModBlocks.SPRUCE_BENCH.get(), ModBlocks.CRIMSON_BENCH.get(), ModBlocks.WARPED_BENCH.get()));
    public static final Supplier<BlockEntityType<BenchBlockEntity>> BENCH = register("bench", () -> ModRegistryHelpers.createBlockEntityType(BenchBlockEntity::new, ModBlocks.BENCH.get(), ModBlocks.FROZEN_BENCH.get()));
    public static final Supplier<BlockEntityType<CouchBlockEntity>> COUCH = register("couch", () -> ModRegistryHelpers.createBlockEntityType(CouchBlockEntity::new, ModBlocks.ACACIA_COUCH.get(), ModBlocks.BIRCH_COUCH.get(), ModBlocks.DARK_OAK_COUCH.get(), ModBlocks.JUNGLE_COUCH.get(), ModBlocks.MANGROVE_COUCH.get(), ModBlocks.OAK_COUCH.get(), ModBlocks.SPRUCE_COUCH.get(), ModBlocks.CRIMSON_COUCH.get(), ModBlocks.WARPED_COUCH.get()));
    public static final Supplier<BlockEntityType<FancyBedBlockEntity>> FANCY_BED = register("fancy_bed", () -> ModRegistryHelpers.createBlockEntityType(FancyBedBlockEntity::new, ModBlocks.ACACIA_FANCY_BED.get(), ModBlocks.BIRCH_FANCY_BED.get(), ModBlocks.DARK_OAK_FANCY_BED.get(), ModBlocks.JUNGLE_FANCY_BED.get(), ModBlocks.MANGROVE_FANCY_BED.get(), ModBlocks.OAK_FANCY_BED.get(), ModBlocks.SPRUCE_FANCY_BED.get(), ModBlocks.CRIMSON_FANCY_BED.get(), ModBlocks.WARPED_FANCY_BED.get()));
    public static final Supplier<BlockEntityType<TableBenchBlockEntity>> TABLE_BENCH = register("table_bench", () -> ModRegistryHelpers.createBlockEntityType(TableBenchBlockEntity::new, ModBlocks.ACACIA_TABLE_BENCH.get(), ModBlocks.BIRCH_TABLE_BENCH.get(), ModBlocks.DARK_OAK_TABLE_BENCH.get(), ModBlocks.JUNGLE_TABLE_BENCH.get(), ModBlocks.MANGROVE_TABLE_BENCH.get(), ModBlocks.OAK_TABLE_BENCH.get(), ModBlocks.SPRUCE_TABLE_BENCH.get(), ModBlocks.CRIMSON_TABLE_BENCH.get(), ModBlocks.WARPED_TABLE_BENCH.get()));
    public static final Supplier<BlockEntityType<NightstandBlockEntity>> NIGHTSTAND = register("nightstand", () -> ModRegistryHelpers.createBlockEntityType(NightstandBlockEntity::new, ModBlocks.ACACIA_NIGHTSTAND.get(), ModBlocks.BIRCH_NIGHTSTAND.get(), ModBlocks.DARK_OAK_NIGHTSTAND.get(), ModBlocks.JUNGLE_NIGHTSTAND.get(), ModBlocks.MANGROVE_NIGHTSTAND.get(), ModBlocks.OAK_NIGHTSTAND.get(), ModBlocks.SPRUCE_NIGHTSTAND.get(), ModBlocks.CRIMSON_NIGHTSTAND.get(), ModBlocks.WARPED_NIGHTSTAND.get()));
    public static final Supplier<BlockEntityType<DeskBlockEntity>> DESK = register("desk", () -> ModRegistryHelpers.createBlockEntityType(DeskBlockEntity::new, ModBlocks.ACACIA_DESK.get(), ModBlocks.BIRCH_DESK.get(), ModBlocks.DARK_OAK_DESK.get(), ModBlocks.JUNGLE_DESK.get(), ModBlocks.MANGROVE_DESK.get(), ModBlocks.OAK_DESK.get(), ModBlocks.SPRUCE_DESK.get(), ModBlocks.CRIMSON_DESK.get(), ModBlocks.WARPED_DESK.get()));
    public static final Supplier<BlockEntityType<SideTableBlockEntity>> SIDE_TABLE = register("side_table", () -> ModRegistryHelpers.createBlockEntityType(SideTableBlockEntity::new, ModBlocks.ACACIA_SIDE_TABLE.get(), ModBlocks.BIRCH_SIDE_TABLE.get(), ModBlocks.DARK_OAK_SIDE_TABLE.get(), ModBlocks.JUNGLE_SIDE_TABLE.get(), ModBlocks.MANGROVE_SIDE_TABLE.get(), ModBlocks.OAK_SIDE_TABLE.get(), ModBlocks.SPRUCE_SIDE_TABLE.get(), ModBlocks.CRIMSON_SIDE_TABLE.get(), ModBlocks.WARPED_SIDE_TABLE.get()));
    public static final Supplier<BlockEntityType<CrockeryBlockEntity>> CROCKERY = register("crockery", () -> ModRegistryHelpers.createBlockEntityType(CrockeryBlockEntity::new, ModBlocks.GLASS_CROCKERY_COMBO.get(), ModBlocks.YELLOW_CROCKERY_COMBO.get(), ModBlocks.BLUE_CROCKERY_COMBO.get(), ModBlocks.WOOD_CROCKERY_COMBO.get(), ModBlocks.CLAY_CROCKERY_COMBO.get()));
    public static final Supplier<BlockEntityType<StatueTrophyBlockEntity>> STATUE = register("statue", () -> ModRegistryHelpers.createBlockEntityType(StatueTrophyBlockEntity::new, ModBlocks.WITCH_TROPHY.get()));

    private static <T extends BlockEntityType<B>, B extends BlockEntity> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.BLOCK_ENTITY_TYPE, id, object);
    }

    public static void init() {
    }
}
