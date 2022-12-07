package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.block.CushionBlock;
import earth.terrarium.handcrafted.block.chair.couch.CouchBlock;
import earth.terrarium.handcrafted.block.chair.gardenbench.GardenBenchBlock;
import earth.terrarium.handcrafted.block.chair.tablebench.TableBenchBlock;
import earth.terrarium.handcrafted.block.chair.tablechair.TableChairBlock;
import earth.terrarium.handcrafted.block.chair.woodengardenbench.WoodenGardenBenchBlock;
import earth.terrarium.handcrafted.block.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.block.pot.PotBlock;
import earth.terrarium.handcrafted.block.specialbed.SpecialBedBlock;
import earth.terrarium.handcrafted.block.stackablebook.StackableBookBlock;
import earth.terrarium.handcrafted.block.stackablejar.StackableJarBlock;
import earth.terrarium.handcrafted.block.trophy.HangingTrophyBlock;
import earth.terrarium.handcrafted.block.trophy.WallTrophyBlock;
import net.minecraft.core.Registry;
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

    public static final Supplier<Block> ACACIA_SPECIAL_BED = register("acacia_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> BIRCH_SPECIAL_BED = register("birch_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> DARK_OAK_SPECIAL_BED = register("dark_oak_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> JUNGLE_SPECIAL_BED = register("jungle_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> MANGROVE_SPECIAL_BED = register("mangrove_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> OAK_SPECIAL_BED = register("oak_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> SPRUCE_SPECIAL_BED = register("spruce_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> CRIMSON_SPECIAL_BED = register("crimson_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final Supplier<Block> WARPED_SPECIAL_BED = register("warped_special_bed", () -> new SpecialBedBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));

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
    public static final Supplier<Block> STACKABLE_BOOK = register("stackable_book", () -> new StackableBookBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final Supplier<Block> GLASS_CUP = register("glass_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> GLASS_PLATE = register("glass_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> GLASS_BOWL = register("glass_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> YELLOW_CUP = register("yellow_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> YELLOW_PLATE = register("yellow_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> YELLOW_BOWL = register("yellow_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> BLUE_CUP = register("blue_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> BLUE_PLATE = register("blue_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final Supplier<Block> BLUE_BOWL = register("blue_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final Supplier<Block> WOOD_CUP = register("wood_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOOD_PLATE = register("wood_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> WOOD_BOWL = register("wood_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final Supplier<Block> CLAY_CUP = register("clay_cup", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> CLAY_PLATE = register("clay_plate", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> CLAY_BOWL = register("clay_bowl", () -> new CrockeryBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));

    public static final Supplier<Block> ROUGH_THIN_POT = register("rough_thin_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> ROUGH_MEDIUM_POT = register("rough_medium_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> ROUGH_WIDE_POT = register("rough_wide_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> ROUGH_THICK_POT = register("rough_thick_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()));

    public static final Supplier<Block> WHITE_GLAZED_THIN_POT = register("white_glazed_thin_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_MEDIUM_POT = register("white_glazed_medium_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_WIDE_POT = register("white_glazed_wide_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> WHITE_GLAZED_THICK_POT = register("white_glazed_thick_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).noOcclusion()));

    public static final Supplier<Block> BLUE_GLAZED_THIN_POT = register("blue_glazed_thin_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_MEDIUM_POT = register("blue_glazed_medium_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_WIDE_POT = register("blue_glazed_wide_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA).noOcclusion()));
    public static final Supplier<Block> BLUE_GLAZED_THICK_POT = register("blue_glazed_thick_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA).noOcclusion()));

    public static final Supplier<Block> GOLDEN_THIN_POT = register("golden_thin_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_MEDIUM_POT = register("golden_medium_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_WIDE_POT = register("golden_wide_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_THICK_POT = register("golden_thick_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));

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

    private static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return ModRegistryHelpers.register(Registry.BLOCK, id, block);
    }

    public static void init() {
    }
}