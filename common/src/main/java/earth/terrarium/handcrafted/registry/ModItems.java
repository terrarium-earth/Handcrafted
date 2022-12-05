package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.item.ModRenderedBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = ModRegistryHelpers.createTab(new ResourceLocation(Handcrafted.MOD_ID, "main"), () -> new ItemStack(ModItems.GARDEN_BENCH.get()));

    public static final Supplier<Item> BLACK_CUSHION = register("black_cushion", () -> new BlockItem(ModBlocks.BLACK_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_CUSHION = register("blue_cushion", () -> new BlockItem(ModBlocks.BLUE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BROWN_CUSHION = register("brown_cushion", () -> new BlockItem(ModBlocks.BROWN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CYAN_CUSHION = register("cyan_cushion", () -> new BlockItem(ModBlocks.CYAN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRAY_CUSHION = register("gray_cushion", () -> new BlockItem(ModBlocks.GRAY_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_CUSHION = register("green_cushion", () -> new BlockItem(ModBlocks.GREEN_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_BLUE_CUSHION = register("light_blue_cushion", () -> new BlockItem(ModBlocks.LIGHT_BLUE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_GRAY_CUSHION = register("light_gray_cushion", () -> new BlockItem(ModBlocks.LIGHT_GRAY_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIME_CUSHION = register("lime_cushion", () -> new BlockItem(ModBlocks.LIME_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MAGENTA_CUSHION = register("magenta_cushion", () -> new BlockItem(ModBlocks.MAGENTA_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ORANGE_CUSHION = register("orange_cushion", () -> new BlockItem(ModBlocks.ORANGE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PINK_CUSHION = register("pink_cushion", () -> new BlockItem(ModBlocks.PINK_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PURPLE_CUSHION = register("purple_cushion", () -> new BlockItem(ModBlocks.PURPLE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_CUSHION = register("red_cushion", () -> new BlockItem(ModBlocks.RED_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_CUSHION = register("white_cushion", () -> new BlockItem(ModBlocks.WHITE_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_CUSHION = register("yellow_cushion", () -> new BlockItem(ModBlocks.YELLOW_CUSHION.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BLACK_SHEET = register("black_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_SHEET = register("blue_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BROWN_SHEET = register("brown_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CYAN_SHEET = register("cyan_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRAY_SHEET = register("gray_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_SHEET = register("green_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_BLUE_SHEET = register("light_blue_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_GRAY_SHEET = register("light_gray_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIME_SHEET = register("lime_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MAGENTA_SHEET = register("magenta_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ORANGE_SHEET = register("orange_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PINK_SHEET = register("pink_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PURPLE_SHEET = register("purple_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_SHEET = register("red_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_SHEET = register("white_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_SHEET = register("yellow_sheet", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

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

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return ModRegistryHelpers.register(Registry.ITEM, id, item);
    }

    public static void init() {
    }
}
