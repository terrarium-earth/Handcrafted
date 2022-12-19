package earth.terrarium.handcrafted.common.registry;

import earth.terrarium.handcrafted.common.block.CushionBlock;
import earth.terrarium.handcrafted.common.block.chair.bench.BenchBlock;
import earth.terrarium.handcrafted.common.block.chair.chair.ChairBlock;
import earth.terrarium.handcrafted.common.block.chair.couch.CouchBlock;
import earth.terrarium.handcrafted.common.block.chair.diningbench.DiningBenchBlock;
import earth.terrarium.handcrafted.common.block.chair.woodenbench.WoodenBenchBlock;
import earth.terrarium.handcrafted.common.block.counter.CounterBlock;
import earth.terrarium.handcrafted.common.block.counter.CupboardBlock;
import earth.terrarium.handcrafted.common.block.counter.DrawerBlock;
import earth.terrarium.handcrafted.common.block.counter.ShelfBlock;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryComboBlock;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlock;
import earth.terrarium.handcrafted.common.block.kitchenhood.KitchenHoodBlock;
import earth.terrarium.handcrafted.common.block.kitchenhood.KitchenHoodPipeBlock;
import earth.terrarium.handcrafted.common.block.pot.PotBlock;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlock;
import earth.terrarium.handcrafted.common.block.stackablejar.StackableJarBlock;
import earth.terrarium.handcrafted.common.block.table.desk.DeskBlock;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlock;
import earth.terrarium.handcrafted.common.block.table.sidetable.SideTableBlock;
import earth.terrarium.handcrafted.common.block.table.table.TableBlock;
import earth.terrarium.handcrafted.common.block.trim.CornerTrimBlock;
import earth.terrarium.handcrafted.common.block.trim.TrimBlock;
import earth.terrarium.handcrafted.common.block.trophy.HangingTrophyBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.block.trophy.WallTrophyBlock;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    public static final Supplier<Block> BLACK_CUSHION = register("black_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> BLUE_CUSHION = register("blue_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> BROWN_CUSHION = register("brown_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> CYAN_CUSHION = register("cyan_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> GRAY_CUSHION = register("gray_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> GREEN_CUSHION = register("green_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_BLUE_CUSHION = register("light_blue_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_GRAY_CUSHION = register("light_gray_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIME_CUSHION = register("lime_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> MAGENTA_CUSHION = register("magenta_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> ORANGE_CUSHION = register("orange_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> PINK_CUSHION = register("pink_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> PURPLE_CUSHION = register("purple_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> RED_CUSHION = register("red_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> WHITE_CUSHION = register("white_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> YELLOW_CUSHION = register("yellow_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final Supplier<Block> STACKABLE_BOOK = register("stackable_book", () -> new StackableBookBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final Supplier<Block> ACACIA_CHAIR = register("acacia_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_CHAIR = register("birch_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_CHAIR = register("dark_oak_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_CHAIR = register("jungle_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_CHAIR = register("mangrove_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_CHAIR = register("oak_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_CHAIR = register("spruce_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_CHAIR = register("crimson_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_CHAIR = register("warped_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_TABLE = register("acacia_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_TABLE = register("birch_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_TABLE = register("dark_oak_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_TABLE = register("jungle_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_TABLE = register("mangrove_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_TABLE = register("oak_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_TABLE = register("spruce_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_TABLE = register("crimson_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_TABLE = register("warped_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_BENCH = register("acacia_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_BENCH = register("birch_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_BENCH = register("dark_oak_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_BENCH = register("jungle_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_BENCH = register("mangrove_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_BENCH = register("oak_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_BENCH = register("spruce_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_BENCH = register("crimson_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_BENCH = register("warped_bench", () -> new WoodenBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> BENCH = register("bench", () -> new BenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final Supplier<Block> FROZEN_BENCH = register("frozen_bench", () -> new BenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final Supplier<Block> ACACIA_COUCH = register("acacia_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_COUCH = register("birch_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_COUCH = register("dark_oak_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_COUCH = register("jungle_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_COUCH = register("mangrove_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_COUCH = register("oak_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_COUCH = register("spruce_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_COUCH = register("crimson_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_COUCH = register("warped_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_FANCY_BED = register("acacia_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> BIRCH_FANCY_BED = register("birch_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> DARK_OAK_FANCY_BED = register("dark_oak_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> JUNGLE_FANCY_BED = register("jungle_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> MANGROVE_FANCY_BED = register("mangrove_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> OAK_FANCY_BED = register("oak_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> SPRUCE_FANCY_BED = register("spruce_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> CRIMSON_FANCY_BED = register("crimson_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> WARPED_FANCY_BED = register("warped_fancy_bed", () -> new FancyBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));

    public static final Supplier<Block> ACACIA_DINING_BENCH = register("acacia_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_DINING_BENCH = register("birch_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_DINING_BENCH = register("dark_oak_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_DINING_BENCH = register("jungle_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_DINING_BENCH = register("mangrove_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_DINING_BENCH = register("oak_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_DINING_BENCH = register("spruce_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_DINING_BENCH = register("crimson_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_DINING_BENCH = register("warped_dining_bench", () -> new DiningBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_NIGHTSTAND = register("acacia_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_NIGHTSTAND = register("birch_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_NIGHTSTAND = register("dark_oak_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_NIGHTSTAND = register("jungle_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_NIGHTSTAND = register("mangrove_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_NIGHTSTAND = register("oak_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_NIGHTSTAND = register("spruce_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_NIGHTSTAND = register("crimson_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_NIGHTSTAND = register("warped_nightstand", () -> new NightstandBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_DESK = register("acacia_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_DESK = register("birch_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_DESK = register("dark_oak_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_DESK = register("jungle_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_DESK = register("mangrove_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_DESK = register("oak_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_DESK = register("spruce_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_DESK = register("crimson_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_DESK = register("warped_desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_SIDE_TABLE = register("acacia_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_SIDE_TABLE = register("birch_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_SIDE_TABLE = register("dark_oak_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_SIDE_TABLE = register("jungle_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_SIDE_TABLE = register("mangrove_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_SIDE_TABLE = register("oak_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_SIDE_TABLE = register("spruce_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_SIDE_TABLE = register("crimson_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_SIDE_TABLE = register("warped_side_table", () -> new SideTableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_COUNTER_1 = register("acacia_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_COUNTER_2 = register("acacia_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_COUNTER_3 = register("acacia_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_COUNTER_1 = register("birch_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_COUNTER_2 = register("birch_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_COUNTER_3 = register("birch_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_COUNTER_1 = register("dark_oak_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_COUNTER_2 = register("dark_oak_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_COUNTER_3 = register("dark_oak_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_COUNTER_1 = register("jungle_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_COUNTER_2 = register("jungle_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_COUNTER_3 = register("jungle_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_COUNTER_1 = register("mangrove_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_COUNTER_2 = register("mangrove_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_COUNTER_3 = register("mangrove_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_COUNTER_1 = register("oak_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_COUNTER_2 = register("oak_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_COUNTER_3 = register("oak_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_COUNTER_1 = register("spruce_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_COUNTER_2 = register("spruce_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_COUNTER_3 = register("spruce_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_COUNTER_1 = register("crimson_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_COUNTER_2 = register("crimson_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_COUNTER_3 = register("crimson_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_COUNTER_1 = register("warped_counter_1", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_COUNTER_2 = register("warped_counter_2", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_COUNTER_3 = register("warped_counter_3", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_DRAWER_1 = register("acacia_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> ACACIA_DRAWER_2 = register("acacia_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> ACACIA_DRAWER_3 = register("acacia_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> ACACIA_DRAWER_4 = register("acacia_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> BIRCH_DRAWER_1 = register("birch_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> BIRCH_DRAWER_2 = register("birch_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> BIRCH_DRAWER_3 = register("birch_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> BIRCH_DRAWER_4 = register("birch_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> DARK_OAK_DRAWER_1 = register("dark_oak_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> DARK_OAK_DRAWER_2 = register("dark_oak_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> DARK_OAK_DRAWER_3 = register("dark_oak_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> DARK_OAK_DRAWER_4 = register("dark_oak_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> JUNGLE_DRAWER_1 = register("jungle_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> JUNGLE_DRAWER_2 = register("jungle_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> JUNGLE_DRAWER_3 = register("jungle_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> JUNGLE_DRAWER_4 = register("jungle_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> MANGROVE_DRAWER_1 = register("mangrove_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> MANGROVE_DRAWER_2 = register("mangrove_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> MANGROVE_DRAWER_3 = register("mangrove_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> MANGROVE_DRAWER_4 = register("mangrove_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> OAK_DRAWER_1 = register("oak_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OAK_DRAWER_2 = register("oak_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OAK_DRAWER_3 = register("oak_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OAK_DRAWER_4 = register("oak_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_DRAWER_1 = register("spruce_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SPRUCE_DRAWER_2 = register("spruce_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SPRUCE_DRAWER_3 = register("spruce_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SPRUCE_DRAWER_4 = register("spruce_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> CRIMSON_DRAWER_1 = register("crimson_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> CRIMSON_DRAWER_2 = register("crimson_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> CRIMSON_DRAWER_3 = register("crimson_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> CRIMSON_DRAWER_4 = register("crimson_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_DRAWER_1 = register("warped_drawer_1", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WARPED_DRAWER_2 = register("warped_drawer_2", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WARPED_DRAWER_3 = register("warped_drawer_3", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WARPED_DRAWER_4 = register("warped_drawer_4", () -> new DrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final Supplier<Block> ACACIA_CUPBOARD_1 = register("acacia_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> ACACIA_CUPBOARD_2 = register("acacia_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> BIRCH_CUPBOARD_1 = register("birch_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> BIRCH_CUPBOARD_2 = register("birch_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> DARK_OAK_CUPBOARD_1 = register("dark_oak_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> DARK_OAK_CUPBOARD_2 = register("dark_oak_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> JUNGLE_CUPBOARD_1 = register("jungle_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> JUNGLE_CUPBOARD_2 = register("jungle_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> MANGROVE_CUPBOARD_1 = register("mangrove_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> MANGROVE_CUPBOARD_2 = register("mangrove_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> OAK_CUPBOARD_1 = register("oak_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OAK_CUPBOARD_2 = register("oak_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_CUPBOARD_1 = register("spruce_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SPRUCE_CUPBOARD_2 = register("spruce_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> CRIMSON_CUPBOARD_1 = register("crimson_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> CRIMSON_CUPBOARD_2 = register("crimson_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_CUPBOARD_1 = register("warped_cupboard_1", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WARPED_CUPBOARD_2 = register("warped_cupboard_2", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final Supplier<Block> ACACIA_SHELF_1 = register("acacia_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> BIRCH_SHELF_1 = register("birch_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> DARK_OAK_SHELF_1 = register("dark_oak_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> JUNGLE_SHELF_1 = register("jungle_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> MANGROVE_SHELF_1 = register("mangrove_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> OAK_SHELF_1 = register("oak_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_SHELF_1 = register("spruce_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> CRIMSON_SHELF_1 = register("crimson_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_SHELF_1 = register("warped_shelf_1", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final Supplier<Block> OVEN = register("oven", () -> new SmokerBlock(BlockBehaviour.Properties.copy(Blocks.SMOKER)) {
    });

    public static final Supplier<Block> KITCHEN_HOOD = register("kitchen_hood", () -> new KitchenHoodBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final Supplier<Block> KITCHEN_HOOD_PIPE = register("kitchen_hood_pipe", () -> new KitchenHoodPipeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final Supplier<Block> ACACIA_PILLAR_TRIM = register("acacia_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_CORNER_TRIM = register("acacia_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PILLAR_TRIM = register("birch_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_CORNER_TRIM = register("birch_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PILLAR_TRIM = register("dark_oak_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_CORNER_TRIM = register("dark_oak_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PILLAR_TRIM = register("jungle_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_CORNER_TRIM = register("jungle_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PILLAR_TRIM = register("mangrove_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_CORNER_TRIM = register("mangrove_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_PILLAR_TRIM = register("oak_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_CORNER_TRIM = register("oak_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PILLAR_TRIM = register("spruce_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_CORNER_TRIM = register("spruce_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PILLAR_TRIM = register("crimson_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_CORNER_TRIM = register("crimson_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PILLAR_TRIM = register("warped_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_CORNER_TRIM = register("warped_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> ANDESITE_PILLAR_TRIM = register("andesite_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).noOcclusion()));
    public static final Supplier<Block> ANDESITE_CORNER_TRIM = register("andesite_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).noOcclusion()));
    public static final Supplier<Block> BLACKSTONE_PILLAR_TRIM = register("blackstone_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Supplier<Block> BLACKSTONE_CORNER_TRIM = register("blackstone_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Supplier<Block> BRICKS_PILLAR_TRIM = register("bricks_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final Supplier<Block> BRICKS_CORNER_TRIM = register("bricks_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final Supplier<Block> CALCITE_PILLAR_TRIM = register("calcite_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE).noOcclusion()));
    public static final Supplier<Block> CALCITE_CORNER_TRIM = register("calcite_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE).noOcclusion()));
    public static final Supplier<Block> DEEPSLATE_PILLAR_TRIM = register("deepslate_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noOcclusion()));
    public static final Supplier<Block> DEEPSLATE_CORNER_TRIM = register("deepslate_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noOcclusion()));
    public static final Supplier<Block> DIORITE_PILLAR_TRIM = register("diorite_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE).noOcclusion()));
    public static final Supplier<Block> DIORITE_CORNER_TRIM = register("diorite_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE).noOcclusion()));
    public static final Supplier<Block> DRIPSTONE_PILLAR_TRIM = register("dripstone_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> DRIPSTONE_CORNER_TRIM = register("dripstone_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> GRANITE_PILLAR_TRIM = register("granite_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE).noOcclusion()));
    public static final Supplier<Block> GRANITE_CORNER_TRIM = register("granite_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE).noOcclusion()));
    public static final Supplier<Block> QUARTZ_PILLAR_TRIM = register("quartz_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    public static final Supplier<Block> QUARTZ_CORNER_TRIM = register("quartz_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    public static final Supplier<Block> STONE_PILLAR_TRIM = register("stone_pillar_trim", () -> new TrimBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final Supplier<Block> STONE_CORNER_TRIM = register("stone_corner_trim", () -> new CornerTrimBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));

    public static final Supplier<Block> BERRY_JAM_JAR = register("berry_jam_jar", () -> new StackableJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> WHITE_CUP = register("white_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> WHITE_PLATE = register("white_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> WHITE_BOWL = register("white_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> WHITE_CROCKERY_COMBO = register("white_crockery_combo", () -> new CrockeryComboBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> YELLOW_CUP = register("yellow_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> YELLOW_PLATE = register("yellow_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> YELLOW_BOWL = register("yellow_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> YELLOW_CROCKERY_COMBO = register("yellow_crockery_combo", () -> new CrockeryComboBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> BLUE_CUP = register("blue_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> BLUE_PLATE = register("blue_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> BLUE_BOWL = register("blue_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> BLUE_CROCKERY_COMBO = register("blue_crockery_combo", () -> new CrockeryComboBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> WOOD_CUP = register("wood_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOOD_PLATE = register("wood_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOOD_BOWL = register("wood_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOOD_CROCKERY_COMBO = register("wood_crockery_combo", () -> new CrockeryComboBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final Supplier<Block> TERRACOTTA_CUP = register("terracotta_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_PLATE = register("terracotta_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_BOWL = register("terracotta_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_CROCKERY_COMBO = register("terracotta_crockery_combo", () -> new CrockeryComboBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));

    public static final Supplier<Block> TERRACOTTA_THIN_POT = register("terracotta_thin_pot", () -> new PotBlock(PotBlock.PotSize.THIN, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_MEDIUM_POT = register("terracotta_medium_pot", () -> new PotBlock(PotBlock.PotSize.MEDIUM, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_WIDE_POT = register("terracotta_wide_pot", () -> new PotBlock(PotBlock.PotSize.WIDE, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> TERRACOTTA_THICK_POT = register("terracotta_thick_pot", () -> new PotBlock(PotBlock.PotSize.THICK, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));

    public static final Supplier<Block> WHITE_GLAZED_THIN_POT = register("white_glazed_thin_pot", () -> new PotBlock(PotBlock.PotSize.THIN, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_MEDIUM_POT = register("white_glazed_medium_pot", () -> new PotBlock(PotBlock.PotSize.MEDIUM, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_WIDE_POT = register("white_glazed_wide_pot", () -> new PotBlock(PotBlock.PotSize.WIDE, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_THICK_POT = register("white_glazed_thick_pot", () -> new PotBlock(PotBlock.PotSize.THICK, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));

    public static final Supplier<Block> BLUE_GLAZED_THIN_POT = register("blue_glazed_thin_pot", () -> new PotBlock(PotBlock.PotSize.THIN, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_MEDIUM_POT = register("blue_glazed_medium_pot", () -> new PotBlock(PotBlock.PotSize.MEDIUM, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_WIDE_POT = register("blue_glazed_wide_pot", () -> new PotBlock(PotBlock.PotSize.WIDE, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_THICK_POT = register("blue_glazed_thick_pot", () -> new PotBlock(PotBlock.PotSize.THICK, BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));

    public static final Supplier<Block> GOLDEN_THIN_POT = register("golden_thin_pot", () -> new PotBlock(PotBlock.PotSize.THIN, BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_MEDIUM_POT = register("golden_medium_pot", () -> new PotBlock(PotBlock.PotSize.MEDIUM, BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_WIDE_POT = register("golden_wide_pot", () -> new PotBlock(PotBlock.PotSize.WIDE, BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_THICK_POT = register("golden_thick_pot", () -> new PotBlock(PotBlock.PotSize.THICK, BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

    public static final Supplier<Block> BEAR_TROPHY = register("bear_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> BLAZE_TROPHY = register("blaze_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> FOX_TROPHY = register("fox_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> GOAT_TROPHY = register("goat_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> PUFFERFISH_TROPHY = register("pufferfish_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SALMON_TROPHY = register("salmon_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SILVERFISH_TROPHY = register("silverfish_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SKELETON_HORSE_TROPHY = register("skeleton_horse_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPIDER_TROPHY = register("spider_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> TROPICAL_FISH_TROPHY = register("tropical_fish_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WITHER_SKELETON_TROPHY = register("wither_skeleton_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOLF_TROPHY = register("wolf_trophy", () -> new WallTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final Supplier<Block> PHANTOM_TROPHY = register("phantom_trophy", () -> new HangingTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> CREEPER_TROPHY = register("creeper_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SKELETON_TROPHY = register("skeleton_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> EVOKER_TROPHY = register("evoker_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final Supplier<Block> PILLAGER_TROPHY = register("pillager_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final Supplier<Block> VINDICATOR_TROPHY = register("vindicator_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final Supplier<Block> WITCH_TROPHY = register("witch_trophy", () -> new StatueTrophyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));

    private static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return ModRegistryHelpers.register(Registry.BLOCK, id, block);
    }

    public static void init() {
    }
}