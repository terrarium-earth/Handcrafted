package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.block.CushionBlock;
import earth.terrarium.handcrafted.block.StackableJarBlock;
import earth.terrarium.handcrafted.block.chair.bed.SingleBedBlock;
import earth.terrarium.handcrafted.block.chair.couch.CouchBlock;
import earth.terrarium.handcrafted.block.chair.gardenbench.GardenBenchBlock;
import earth.terrarium.handcrafted.block.chair.tablebench.TableBenchBlock;
import earth.terrarium.handcrafted.block.chair.tablechair.TableChairBlock;
import earth.terrarium.handcrafted.block.chair.woodengardenbench.WoodenGardenBenchBlock;
import net.minecraft.core.Registry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    public static final Supplier<Block> GARDEN_BENCH = register("garden_bench", () -> new GardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final Supplier<Block> FROZEN_GARDEN_BENCH = register("frozen_garden_bench", () -> new GardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final Supplier<Block> ACACIA_GARDEN_BENCH = register("acacia_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_GARDEN_BENCH = register("birch_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_GARDEN_BENCH = register("dark_oak_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_GARDEN_BENCH = register("jungle_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_GARDEN_BENCH = register("mangrove_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_GARDEN_BENCH = register("oak_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_GARDEN_BENCH = register("spruce_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_GARDEN_BENCH = register("crimson_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_GARDEN_BENCH = register("warped_garden_bench", () -> new WoodenGardenBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_COUCH = register("acacia_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_COUCH = register("birch_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_COUCH = register("dark_oak_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_COUCH = register("jungle_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_COUCH = register("mangrove_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_COUCH = register("oak_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_COUCH = register("spruce_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_COUCH = register("crimson_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_COUCH = register("warped_couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_TABLE_BENCH = register("acacia_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_TABLE_BENCH = register("birch_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_TABLE_BENCH = register("dark_oak_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_TABLE_BENCH = register("jungle_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_TABLE_BENCH = register("mangrove_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_TABLE_BENCH = register("oak_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_TABLE_BENCH = register("spruce_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_TABLE_BENCH = register("crimson_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_TABLE_BENCH = register("warped_table_bench", () -> new TableBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_TABLE_CHAIR = register("acacia_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_TABLE_CHAIR = register("birch_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_TABLE_CHAIR = register("dark_oak_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_TABLE_CHAIR = register("jungle_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_TABLE_CHAIR = register("mangrove_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_TABLE_CHAIR = register("oak_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_TABLE_CHAIR = register("spruce_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_TABLE_CHAIR = register("crimson_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_TABLE_CHAIR = register("warped_table_chair", () -> new TableChairBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));

    public static final Supplier<Block> ACACIA_SINGLE_BED = register("acacia_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> BIRCH_SINGLE_BED = register("birch_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> DARK_OAK_SINGLE_BED = register("dark_oak_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> JUNGLE_SINGLE_BED = register("jungle_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> MANGROVE_SINGLE_BED = register("mangrove_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> OAK_SINGLE_BED = register("oak_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> SPRUCE_SINGLE_BED = register("spruce_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> CRIMSON_SINGLE_BED = register("crimson_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> WARPED_SINGLE_BED = register("warped_single_bed", () -> new SingleBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));

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

    public static final Supplier<Block> BERRY_JAM_JAR = register("berry_jam_jar", () -> new StackableJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    private static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return ModRegistryHelpers.register(Registry.BLOCK, id, block);
    }

    public static void init() {
    }
}