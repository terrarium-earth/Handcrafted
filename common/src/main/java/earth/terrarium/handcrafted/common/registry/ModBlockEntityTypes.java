package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.block.chair.bench.BenchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.chair.ChairBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.couch.CouchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.diningbench.DiningBenchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.woodenbench.WoodenBenchBlockEntity;
import earth.terrarium.handcrafted.common.block.counter.CounterBlockEntity;
import earth.terrarium.handcrafted.common.block.counter.ShelfBlockEntity;
import earth.terrarium.handcrafted.common.block.counter.StorageBlockEntity;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlockEntity;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlockEntity;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlockEntity;
import earth.terrarium.handcrafted.common.block.table.desk.DeskBlockEntity;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlockEntity;
import earth.terrarium.handcrafted.common.block.table.sidetable.SideTableBlockEntity;
import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlockEntity;
import earth.terrarium.handcrafted.mixin.BlockEntityTypeAccessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashSet;
import java.util.Set;

public class ModBlockEntityTypes {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Handcrafted.MOD_ID);

    public static final RegistryEntry<BlockEntityType<StackableBookBlockEntity>> STACKABLE_BOOK = BLOCK_ENTITY_TYPES.register("stackable_book", () -> ModRegistryHelpers.createBlockEntityType(StackableBookBlockEntity::new, ModBlocks.STACKABLE_BOOKS));
    public static final RegistryEntry<BlockEntityType<ChairBlockEntity>> CHAIR = BLOCK_ENTITY_TYPES.register("chair", () -> ModRegistryHelpers.createBlockEntityType(ChairBlockEntity::new, ModBlocks.CHAIRS));
    public static final RegistryEntry<BlockEntityType<TableBlockEntity>> TABLE = BLOCK_ENTITY_TYPES.register("table", () -> ModRegistryHelpers.createBlockEntityType(TableBlockEntity::new, ModBlocks.TABLES));
    public static final RegistryEntry<BlockEntityType<WoodenBenchBlockEntity>> BENCH = BLOCK_ENTITY_TYPES.register("wooden_bench", () -> ModRegistryHelpers.createBlockEntityType(WoodenBenchBlockEntity::new, ModBlocks.WOODEN_BENCHES));
    public static final RegistryEntry<BlockEntityType<BenchBlockEntity>> METAL_BENCH = BLOCK_ENTITY_TYPES.register("bench", () -> ModRegistryHelpers.createBlockEntityType(BenchBlockEntity::new, ModBlocks.METAL_BENCHES));
    public static final RegistryEntry<BlockEntityType<CouchBlockEntity>> COUCH = BLOCK_ENTITY_TYPES.register("couch", () -> ModRegistryHelpers.createBlockEntityType(CouchBlockEntity::new, ModBlocks.COUCHES));
    public static final RegistryEntry<BlockEntityType<FancyBedBlockEntity>> FANCY_BED = BLOCK_ENTITY_TYPES.register("fancy_bed", () -> ModRegistryHelpers.createBlockEntityType(FancyBedBlockEntity::new, ModBlocks.FANCY_BEDS));
    public static final RegistryEntry<BlockEntityType<DiningBenchBlockEntity>> DINING_BENCH = BLOCK_ENTITY_TYPES.register("dining_bench", () -> ModRegistryHelpers.createBlockEntityType(DiningBenchBlockEntity::new, ModBlocks.DINING_BENCHES));
    public static final RegistryEntry<BlockEntityType<NightstandBlockEntity>> NIGHTSTAND = BLOCK_ENTITY_TYPES.register("nightstand", () -> ModRegistryHelpers.createBlockEntityType(NightstandBlockEntity::new, ModBlocks.NIGHTSTANDS));
    public static final RegistryEntry<BlockEntityType<DeskBlockEntity>> DESK = BLOCK_ENTITY_TYPES.register("desk", () -> ModRegistryHelpers.createBlockEntityType(DeskBlockEntity::new, ModBlocks.DESKS));
    public static final RegistryEntry<BlockEntityType<SideTableBlockEntity>> SIDE_TABLE = BLOCK_ENTITY_TYPES.register("side_table", () -> ModRegistryHelpers.createBlockEntityType(SideTableBlockEntity::new, ModBlocks.SIDE_TABLES));
    public static final RegistryEntry<BlockEntityType<CounterBlockEntity>> COUNTER = BLOCK_ENTITY_TYPES.register("counter", () -> ModRegistryHelpers.createBlockEntityType(CounterBlockEntity::new, ModBlocks.COUNTERS));
    public static final RegistryEntry<BlockEntityType<StorageBlockEntity>> STORAGE = BLOCK_ENTITY_TYPES.register("storage", () -> ModRegistryHelpers.createBlockEntityType(StorageBlockEntity::new, ModBlocks.CUPBOARDS));
    public static final RegistryEntry<BlockEntityType<ShelfBlockEntity>> SHELF = BLOCK_ENTITY_TYPES.register("shelf", () -> ModRegistryHelpers.createBlockEntityType(ShelfBlockEntity::new, ModBlocks.SHELVES));
    public static final RegistryEntry<BlockEntityType<CrockeryBlockEntity>> CROCKERY = BLOCK_ENTITY_TYPES.register("crockery", () -> ModRegistryHelpers.createBlockEntityType(CrockeryBlockEntity::new, ModBlocks.CROCKERY_COMBOS));
    public static final RegistryEntry<BlockEntityType<StatueBlockEntity>> STATUE_ENTITY = BLOCK_ENTITY_TYPES.register("statue_entity", () -> ModRegistryHelpers.createBlockEntityType(StatueBlockEntity::ofEntity, ModBlocks.STATUE_TROPHY_ENTITIES));
    public static final RegistryEntry<BlockEntityType<StatueBlockEntity>> STATUE_BLOCK = BLOCK_ENTITY_TYPES.register("statue_block", () -> ModRegistryHelpers.createBlockEntityType(StatueBlockEntity::ofBlock, ModBlocks.STATUE_TROPHY_BLOCKS));

    public static void postInit() {
        BlockEntityTypeAccessor smokerRegistry = ((BlockEntityTypeAccessor) BlockEntityType.SMOKER);
        Set<Block> smokerBlocks = new HashSet<>(smokerRegistry.getValidBlocks());
        smokerBlocks.add(ModBlocks.OVEN.get());
        smokerRegistry.setValidBlocks(smokerBlocks);
    }
}
