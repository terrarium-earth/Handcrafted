package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.item.CushionBlockItem;
import earth.terrarium.handcrafted.item.FancyPaintingItem;
import earth.terrarium.handcrafted.item.ModRenderedBlockItem;
import earth.terrarium.handcrafted.item.SheetItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = ModRegistryHelpers.createTab(new ResourceLocation(Handcrafted.MOD_ID, "main"), () -> new ItemStack(ModItems.GARDEN_BENCH.get()));

    public static final Supplier<Item> BLACK_CUSHION = register("black_cushion", () -> new CushionBlockItem(ModBlocks.BLACK_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_CUSHION = register("blue_cushion", () -> new CushionBlockItem(ModBlocks.BLUE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BROWN_CUSHION = register("brown_cushion", () -> new CushionBlockItem(ModBlocks.BROWN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CYAN_CUSHION = register("cyan_cushion", () -> new CushionBlockItem(ModBlocks.CYAN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRAY_CUSHION = register("gray_cushion", () -> new CushionBlockItem(ModBlocks.GRAY_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_CUSHION = register("green_cushion", () -> new CushionBlockItem(ModBlocks.GREEN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_BLUE_CUSHION = register("light_blue_cushion", () -> new CushionBlockItem(ModBlocks.LIGHT_BLUE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_GRAY_CUSHION = register("light_gray_cushion", () -> new CushionBlockItem(ModBlocks.LIGHT_GRAY_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIME_CUSHION = register("lime_cushion", () -> new CushionBlockItem(ModBlocks.LIME_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MAGENTA_CUSHION = register("magenta_cushion", () -> new CushionBlockItem(ModBlocks.MAGENTA_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ORANGE_CUSHION = register("orange_cushion", () -> new CushionBlockItem(ModBlocks.ORANGE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PINK_CUSHION = register("pink_cushion", () -> new CushionBlockItem(ModBlocks.PINK_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PURPLE_CUSHION = register("purple_cushion", () -> new CushionBlockItem(ModBlocks.PURPLE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_CUSHION = register("red_cushion", () -> new CushionBlockItem(ModBlocks.RED_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_CUSHION = register("white_cushion", () -> new CushionBlockItem(ModBlocks.WHITE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_CUSHION = register("yellow_cushion", () -> new CushionBlockItem(ModBlocks.YELLOW_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BLACK_SHEET = register("black_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_SHEET = register("blue_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BROWN_SHEET = register("brown_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CYAN_SHEET = register("cyan_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRAY_SHEET = register("gray_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_SHEET = register("green_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_BLUE_SHEET = register("light_blue_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_GRAY_SHEET = register("light_gray_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIME_SHEET = register("lime_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MAGENTA_SHEET = register("magenta_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ORANGE_SHEET = register("orange_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PINK_SHEET = register("pink_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PURPLE_SHEET = register("purple_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_SHEET = register("red_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_SHEET = register("white_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_SHEET = register("yellow_sheet", () -> new SheetItem(new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_TABLE_BENCH = register("acacia_table_bench", () -> new ModRenderedBlockItem(ModBlocks.ACACIA_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_TABLE_BENCH = register("birch_table_bench", () -> new ModRenderedBlockItem(ModBlocks.BIRCH_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_TABLE_BENCH = register("dark_oak_table_bench", () -> new ModRenderedBlockItem(ModBlocks.DARK_OAK_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_TABLE_BENCH = register("jungle_table_bench", () -> new ModRenderedBlockItem(ModBlocks.JUNGLE_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_TABLE_BENCH = register("mangrove_table_bench", () -> new ModRenderedBlockItem(ModBlocks.MANGROVE_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_TABLE_BENCH = register("oak_table_bench", () -> new ModRenderedBlockItem(ModBlocks.OAK_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_TABLE_BENCH = register("spruce_table_bench", () -> new ModRenderedBlockItem(ModBlocks.SPRUCE_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_TABLE_BENCH = register("crimson_table_bench", () -> new ModRenderedBlockItem(ModBlocks.CRIMSON_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_TABLE_BENCH = register("warped_table_bench", () -> new ModRenderedBlockItem(ModBlocks.WARPED_TABLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_TABLE_CHAIR = register("acacia_table_chair", () -> new ModRenderedBlockItem(ModBlocks.ACACIA_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_TABLE_CHAIR = register("birch_table_chair", () -> new ModRenderedBlockItem(ModBlocks.BIRCH_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_TABLE_CHAIR = register("dark_oak_table_chair", () -> new ModRenderedBlockItem(ModBlocks.DARK_OAK_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_TABLE_CHAIR = register("jungle_table_chair", () -> new ModRenderedBlockItem(ModBlocks.JUNGLE_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_TABLE_CHAIR = register("mangrove_table_chair", () -> new ModRenderedBlockItem(ModBlocks.MANGROVE_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_TABLE_CHAIR = register("oak_table_chair", () -> new ModRenderedBlockItem(ModBlocks.OAK_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_TABLE_CHAIR = register("spruce_table_chair", () -> new ModRenderedBlockItem(ModBlocks.SPRUCE_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_TABLE_CHAIR = register("crimson_table_chair", () -> new ModRenderedBlockItem(ModBlocks.CRIMSON_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_TABLE_CHAIR = register("warped_table_chair", () -> new ModRenderedBlockItem(ModBlocks.WARPED_TABLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_COUCH = register("acacia_couch", () -> new ModRenderedBlockItem(ModBlocks.ACACIA_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_COUCH = register("birch_couch", () -> new ModRenderedBlockItem(ModBlocks.BIRCH_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_COUCH = register("dark_oak_couch", () -> new ModRenderedBlockItem(ModBlocks.DARK_OAK_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_COUCH = register("jungle_couch", () -> new ModRenderedBlockItem(ModBlocks.JUNGLE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_COUCH = register("mangrove_couch", () -> new ModRenderedBlockItem(ModBlocks.MANGROVE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_COUCH = register("oak_couch", () -> new ModRenderedBlockItem(ModBlocks.OAK_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_COUCH = register("spruce_couch", () -> new ModRenderedBlockItem(ModBlocks.SPRUCE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_COUCH = register("crimson_couch", () -> new ModRenderedBlockItem(ModBlocks.CRIMSON_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_COUCH = register("warped_couch", () -> new ModRenderedBlockItem(ModBlocks.WARPED_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> GARDEN_BENCH = register("garden_bench", () -> new ModRenderedBlockItem(ModBlocks.GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> FROZEN_GARDEN_BENCH = register("frozen_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.FROZEN_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ACACIA_GARDEN_BENCH = register("acacia_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.ACACIA_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_GARDEN_BENCH = register("birch_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.BIRCH_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_GARDEN_BENCH = register("dark_oak_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.DARK_OAK_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_GARDEN_BENCH = register("jungle_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.JUNGLE_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_GARDEN_BENCH = register("mangrove_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.MANGROVE_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_GARDEN_BENCH = register("oak_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.OAK_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_GARDEN_BENCH = register("spruce_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.SPRUCE_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_GARDEN_BENCH = register("crimson_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.CRIMSON_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_GARDEN_BENCH = register("warped_garden_bench", () -> new ModRenderedBlockItem(ModBlocks.WARPED_GARDEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_SPECIAL_BED = register("acacia_special_bed", () -> new ModRenderedBlockItem(ModBlocks.ACACIA_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_SPECIAL_BED = register("birch_special_bed", () -> new ModRenderedBlockItem(ModBlocks.BIRCH_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_SPECIAL_BED = register("dark_oak_special_bed", () -> new ModRenderedBlockItem(ModBlocks.DARK_OAK_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_SPECIAL_BED = register("jungle_special_bed", () -> new ModRenderedBlockItem(ModBlocks.JUNGLE_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_SPECIAL_BED = register("mangrove_special_bed", () -> new ModRenderedBlockItem(ModBlocks.MANGROVE_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_SPECIAL_BED = register("oak_special_bed", () -> new ModRenderedBlockItem(ModBlocks.OAK_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_SPECIAL_BED = register("spruce_special_bed", () -> new ModRenderedBlockItem(ModBlocks.SPRUCE_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_SPECIAL_BED = register("crimson_special_bed", () -> new ModRenderedBlockItem(ModBlocks.CRIMSON_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_SPECIAL_BED = register("warped_special_bed", () -> new ModRenderedBlockItem(ModBlocks.WARPED_SPECIAL_BED.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BERRY_JAM_JAR = register("berry_jam_jar", () -> new ModRenderedBlockItem(ModBlocks.BERRY_JAM_JAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> STACKABLE_BOOK = register("stackable_book", () -> new BlockItem(ModBlocks.STACKABLE_BOOK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> FANCY_PAINTING = register("fancy_painting", () -> new FancyPaintingItem(ModEntityTypes.FANCY_PAINTING.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> GLASS_CUP = register("glass_cup", () -> new BlockItem(ModBlocks.GLASS_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GLASS_PLATE = register("glass_plate", () -> new BlockItem(ModBlocks.GLASS_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GLASS_BOWL = register("glass_bowl", () -> new BlockItem(ModBlocks.GLASS_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> YELLOW_CUP = register("yellow_cup", () -> new BlockItem(ModBlocks.YELLOW_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_PLATE = register("yellow_plate", () -> new BlockItem(ModBlocks.YELLOW_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_BOWL = register("yellow_bowl", () -> new BlockItem(ModBlocks.YELLOW_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BLUE_CUP = register("blue_cup", () -> new BlockItem(ModBlocks.BLUE_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_PLATE = register("blue_plate", () -> new BlockItem(ModBlocks.BLUE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_BOWL = register("blue_bowl", () -> new BlockItem(ModBlocks.BLUE_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WOOD_CUP = register("wood_cup", () -> new BlockItem(ModBlocks.WOOD_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOOD_PLATE = register("wood_plate", () -> new BlockItem(ModBlocks.WOOD_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOOD_BOWL = register("wood_bowl", () -> new BlockItem(ModBlocks.WOOD_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> CLAY_CUP = register("clay_cup", () -> new BlockItem(ModBlocks.CLAY_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CLAY_PLATE = register("clay_plate", () -> new BlockItem(ModBlocks.CLAY_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CLAY_BOWL = register("clay_bowl", () -> new BlockItem(ModBlocks.CLAY_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ROUGH_THIN_POT = register("rough_thin_pot", () -> new BlockItem(ModBlocks.ROUGH_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ROUGH_MEDIUM_POT = register("rough_medium_pot", () -> new BlockItem(ModBlocks.ROUGH_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ROUGH_WIDE_POT = register("rough_wide_pot", () -> new BlockItem(ModBlocks.ROUGH_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ROUGH_THICK_POT = register("rough_thick_pot", () -> new BlockItem(ModBlocks.ROUGH_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WHITE_GLAZED_THIN_POT = register("white_glazed_thin_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_MEDIUM_POT = register("white_glazed_medium_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_WIDE_POT = register("white_glazed_wide_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_THICK_POT = register("white_glazed_thick_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> GOLD_THIN_POT = register("blue_glazed_thin_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_MEDIUM_POT = register("blue_glazed_medium_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_WIDE_POT = register("blue_glazed_wide_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_THICK_POT = register("blue_glazed_thick_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> GOLDEN_THIN_POT = register("golden_thin_pot", () -> new BlockItem(ModBlocks.GOLDEN_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_MEDIUM_POT = register("golden_medium_pot", () -> new BlockItem(ModBlocks.GOLDEN_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_WIDE_POT = register("golden_wide_pot", () -> new BlockItem(ModBlocks.GOLDEN_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_THICK_POT = register("golden_thick_pot", () -> new BlockItem(ModBlocks.GOLDEN_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return ModRegistryHelpers.register(Registry.ITEM, id, item);
    }

    public static void init() {
    }
}
