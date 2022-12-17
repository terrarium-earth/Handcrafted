package earth.terrarium.handcrafted.common.registry;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.item.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = ModRegistryHelpers.createTab(new ResourceLocation(Handcrafted.MOD_ID, "main"), () -> new ItemStack(ModItems.MANGROVE_FANCY_BED.get()));

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

    public static final Supplier<Item> ACACIA_BOARD = register("acacia_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_BOARD = register("birch_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_BOARD = register("dark_oak_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_BOARD = register("jungle_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_BOARD = register("mangrove_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_BOARD = register("oak_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_BOARD = register("spruce_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_BOARD = register("crimson_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_BOARD = register("warped_board", () -> new BoardItem(new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> HAMMER = register("hammer", () -> new HammerItem(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final Supplier<Item> STACKABLE_BOOK = register("stackable_book", () -> new BlockItem(ModBlocks.STACKABLE_BOOK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> FANCY_PAINTING = register("fancy_painting", () -> new FancyPaintingItem(ModEntityTypes.FANCY_PAINTING.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_CHAIR = register("acacia_chair", () -> new RenderedBlockItem(ModBlocks.ACACIA_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_CHAIR = register("birch_chair", () -> new RenderedBlockItem(ModBlocks.BIRCH_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_CHAIR = register("dark_oak_chair", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_CHAIR = register("jungle_chair", () -> new RenderedBlockItem(ModBlocks.JUNGLE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_CHAIR = register("mangrove_chair", () -> new RenderedBlockItem(ModBlocks.MANGROVE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_CHAIR = register("oak_chair", () -> new RenderedBlockItem(ModBlocks.OAK_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_CHAIR = register("spruce_chair", () -> new RenderedBlockItem(ModBlocks.SPRUCE_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_CHAIR = register("crimson_chair", () -> new RenderedBlockItem(ModBlocks.CRIMSON_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_CHAIR = register("warped_chair", () -> new RenderedBlockItem(ModBlocks.WARPED_CHAIR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_TABLE = register("acacia_table", () -> new RenderedBlockItem(ModBlocks.ACACIA_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_TABLE = register("birch_table", () -> new RenderedBlockItem(ModBlocks.BIRCH_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_TABLE = register("dark_oak_table", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_TABLE = register("jungle_table", () -> new RenderedBlockItem(ModBlocks.JUNGLE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_TABLE = register("mangrove_table", () -> new RenderedBlockItem(ModBlocks.MANGROVE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_TABLE = register("oak_table", () -> new RenderedBlockItem(ModBlocks.OAK_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_TABLE = register("spruce_table", () -> new RenderedBlockItem(ModBlocks.SPRUCE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_TABLE = register("crimson_table", () -> new RenderedBlockItem(ModBlocks.CRIMSON_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_TABLE = register("warped_table", () -> new RenderedBlockItem(ModBlocks.WARPED_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_BENCH = register("acacia_bench", () -> new RenderedBlockItem(ModBlocks.ACACIA_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_BENCH = register("birch_bench", () -> new RenderedBlockItem(ModBlocks.BIRCH_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_BENCH = register("dark_oak_bench", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_BENCH = register("jungle_bench", () -> new RenderedBlockItem(ModBlocks.JUNGLE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_BENCH = register("mangrove_bench", () -> new RenderedBlockItem(ModBlocks.MANGROVE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_BENCH = register("oak_bench", () -> new RenderedBlockItem(ModBlocks.OAK_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_BENCH = register("spruce_bench", () -> new RenderedBlockItem(ModBlocks.SPRUCE_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_BENCH = register("crimson_bench", () -> new RenderedBlockItem(ModBlocks.CRIMSON_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_BENCH = register("warped_bench", () -> new RenderedBlockItem(ModBlocks.WARPED_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BENCH = register("bench", () -> new RenderedBlockItem(ModBlocks.BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> FROZEN_BENCH = register("frozen_bench", () -> new RenderedBlockItem(ModBlocks.FROZEN_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_COUCH = register("acacia_couch", () -> new RenderedBlockItem(ModBlocks.ACACIA_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_COUCH = register("birch_couch", () -> new RenderedBlockItem(ModBlocks.BIRCH_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_COUCH = register("dark_oak_couch", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_COUCH = register("jungle_couch", () -> new RenderedBlockItem(ModBlocks.JUNGLE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_COUCH = register("mangrove_couch", () -> new RenderedBlockItem(ModBlocks.MANGROVE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_COUCH = register("oak_couch", () -> new RenderedBlockItem(ModBlocks.OAK_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_COUCH = register("spruce_couch", () -> new RenderedBlockItem(ModBlocks.SPRUCE_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_COUCH = register("crimson_couch", () -> new RenderedBlockItem(ModBlocks.CRIMSON_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_COUCH = register("warped_couch", () -> new RenderedBlockItem(ModBlocks.WARPED_COUCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_FANCY_BED = register("acacia_fancy_bed", () -> new RenderedBlockItem(ModBlocks.ACACIA_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_FANCY_BED = register("birch_fancy_bed", () -> new RenderedBlockItem(ModBlocks.BIRCH_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_FANCY_BED = register("dark_oak_fancy_bed", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_FANCY_BED = register("jungle_fancy_bed", () -> new RenderedBlockItem(ModBlocks.JUNGLE_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_FANCY_BED = register("mangrove_fancy_bed", () -> new RenderedBlockItem(ModBlocks.MANGROVE_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_FANCY_BED = register("oak_fancy_bed", () -> new RenderedBlockItem(ModBlocks.OAK_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_FANCY_BED = register("spruce_fancy_bed", () -> new RenderedBlockItem(ModBlocks.SPRUCE_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_FANCY_BED = register("crimson_fancy_bed", () -> new RenderedBlockItem(ModBlocks.CRIMSON_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_FANCY_BED = register("warped_fancy_bed", () -> new RenderedBlockItem(ModBlocks.WARPED_FANCY_BED.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_DINING_BENCH = register("acacia_dining_bench", () -> new RenderedBlockItem(ModBlocks.ACACIA_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_DINING_BENCH = register("birch_dining_bench", () -> new RenderedBlockItem(ModBlocks.BIRCH_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_DINING_BENCH = register("dark_oak_dining_bench", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_DINING_BENCH = register("jungle_dining_bench", () -> new RenderedBlockItem(ModBlocks.JUNGLE_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_DINING_BENCH = register("mangrove_dining_bench", () -> new RenderedBlockItem(ModBlocks.MANGROVE_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_DINING_BENCH = register("oak_dining_bench", () -> new RenderedBlockItem(ModBlocks.OAK_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_DINING_BENCH = register("spruce_dining_bench", () -> new RenderedBlockItem(ModBlocks.SPRUCE_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_DINING_BENCH = register("crimson_dining_bench", () -> new RenderedBlockItem(ModBlocks.CRIMSON_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_DINING_BENCH = register("warped_dining_bench", () -> new RenderedBlockItem(ModBlocks.WARPED_DINING_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_NIGHTSTAND = register("acacia_nightstand", () -> new RenderedBlockItem(ModBlocks.ACACIA_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_NIGHTSTAND = register("birch_nightstand", () -> new RenderedBlockItem(ModBlocks.BIRCH_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_NIGHTSTAND = register("dark_oak_nightstand", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_NIGHTSTAND = register("jungle_nightstand", () -> new RenderedBlockItem(ModBlocks.JUNGLE_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_NIGHTSTAND = register("mangrove_nightstand", () -> new RenderedBlockItem(ModBlocks.MANGROVE_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_NIGHTSTAND = register("oak_nightstand", () -> new RenderedBlockItem(ModBlocks.OAK_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_NIGHTSTAND = register("spruce_nightstand", () -> new RenderedBlockItem(ModBlocks.SPRUCE_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_NIGHTSTAND = register("crimson_nightstand", () -> new RenderedBlockItem(ModBlocks.CRIMSON_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_NIGHTSTAND = register("warped_nightstand", () -> new RenderedBlockItem(ModBlocks.WARPED_NIGHTSTAND.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_DESK = register("acacia_desk", () -> new RenderedBlockItem(ModBlocks.ACACIA_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_DESK = register("birch_desk", () -> new RenderedBlockItem(ModBlocks.BIRCH_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_DESK = register("dark_oak_desk", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_DESK = register("jungle_desk", () -> new RenderedBlockItem(ModBlocks.JUNGLE_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_DESK = register("mangrove_desk", () -> new RenderedBlockItem(ModBlocks.MANGROVE_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_DESK = register("oak_desk", () -> new RenderedBlockItem(ModBlocks.OAK_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_DESK = register("spruce_desk", () -> new RenderedBlockItem(ModBlocks.SPRUCE_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_DESK = register("crimson_desk", () -> new RenderedBlockItem(ModBlocks.CRIMSON_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_DESK = register("warped_desk", () -> new RenderedBlockItem(ModBlocks.WARPED_DESK.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_SIDE_TABLE = register("acacia_side_table", () -> new RenderedBlockItem(ModBlocks.ACACIA_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_SIDE_TABLE = register("birch_side_table", () -> new RenderedBlockItem(ModBlocks.BIRCH_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_SIDE_TABLE = register("dark_oak_side_table", () -> new RenderedBlockItem(ModBlocks.DARK_OAK_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_SIDE_TABLE = register("jungle_side_table", () -> new RenderedBlockItem(ModBlocks.JUNGLE_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_SIDE_TABLE = register("mangrove_side_table", () -> new RenderedBlockItem(ModBlocks.MANGROVE_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_SIDE_TABLE = register("oak_side_table", () -> new RenderedBlockItem(ModBlocks.OAK_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_SIDE_TABLE = register("spruce_side_table", () -> new RenderedBlockItem(ModBlocks.SPRUCE_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_SIDE_TABLE = register("crimson_side_table", () -> new RenderedBlockItem(ModBlocks.CRIMSON_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_SIDE_TABLE = register("warped_side_table", () -> new RenderedBlockItem(ModBlocks.WARPED_SIDE_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_COUNTER = register("acacia_counter", () -> new CounterBlockItem(ModBlocks.ACACIA_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_COUNTER = register("birch_counter", () -> new CounterBlockItem(ModBlocks.BIRCH_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_COUNTER = register("dark_oak_counter", () -> new CounterBlockItem(ModBlocks.DARK_OAK_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_COUNTER = register("jungle_counter", () -> new CounterBlockItem(ModBlocks.JUNGLE_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_COUNTER = register("mangrove_counter", () -> new CounterBlockItem(ModBlocks.MANGROVE_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_COUNTER = register("oak_counter", () -> new CounterBlockItem(ModBlocks.OAK_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_COUNTER = register("spruce_counter", () -> new CounterBlockItem(ModBlocks.SPRUCE_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_COUNTER = register("crimson_counter", () -> new CounterBlockItem(ModBlocks.CRIMSON_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_COUNTER = register("warped_counter", () -> new CounterBlockItem(ModBlocks.WARPED_COUNTER_1.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_DRAWER = register("acacia_drawer", () -> new HammerableBlockItem(ModBlocks.ACACIA_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_DRAWER = register("birch_drawer", () -> new HammerableBlockItem(ModBlocks.BIRCH_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_DRAWER = register("dark_oak_drawer", () -> new HammerableBlockItem(ModBlocks.DARK_OAK_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_DRAWER = register("jungle_drawer", () -> new HammerableBlockItem(ModBlocks.JUNGLE_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_DRAWER = register("mangrove_drawer", () -> new HammerableBlockItem(ModBlocks.MANGROVE_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_DRAWER = register("oak_drawer", () -> new HammerableBlockItem(ModBlocks.OAK_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_DRAWER = register("spruce_drawer", () -> new HammerableBlockItem(ModBlocks.SPRUCE_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_DRAWER = register("crimson_drawer", () -> new HammerableBlockItem(ModBlocks.CRIMSON_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_DRAWER = register("warped_drawer", () -> new HammerableBlockItem(ModBlocks.WARPED_DRAWER_1.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_CUPBOARD = register("acacia_cupboard", () -> new HammerableBlockItem(ModBlocks.ACACIA_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_CUPBOARD = register("birch_cupboard", () -> new HammerableBlockItem(ModBlocks.BIRCH_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_CUPBOARD = register("dark_oak_cupboard", () -> new HammerableBlockItem(ModBlocks.DARK_OAK_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_CUPBOARD = register("jungle_cupboard", () -> new HammerableBlockItem(ModBlocks.JUNGLE_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_CUPBOARD = register("mangrove_cupboard", () -> new HammerableBlockItem(ModBlocks.MANGROVE_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_CUPBOARD = register("oak_cupboard", () -> new HammerableBlockItem(ModBlocks.OAK_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_CUPBOARD = register("spruce_cupboard", () -> new HammerableBlockItem(ModBlocks.SPRUCE_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_CUPBOARD = register("crimson_cupboard", () -> new HammerableBlockItem(ModBlocks.CRIMSON_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_CUPBOARD = register("warped_cupboard", () -> new HammerableBlockItem(ModBlocks.WARPED_CUPBOARD_1.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_SHELF = register("acacia_shelf", () -> new ShelfBlockItem(ModBlocks.ACACIA_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_SHELF = register("birch_shelf", () -> new ShelfBlockItem(ModBlocks.BIRCH_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_SHELF = register("dark_oak_shelf", () -> new ShelfBlockItem(ModBlocks.DARK_OAK_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_SHELF = register("jungle_shelf", () -> new ShelfBlockItem(ModBlocks.JUNGLE_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_SHELF = register("mangrove_shelf", () -> new ShelfBlockItem(ModBlocks.MANGROVE_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_SHELF = register("oak_shelf", () -> new ShelfBlockItem(ModBlocks.OAK_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_SHELF = register("spruce_shelf", () -> new ShelfBlockItem(ModBlocks.SPRUCE_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_SHELF = register("crimson_shelf", () -> new ShelfBlockItem(ModBlocks.CRIMSON_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_SHELF = register("warped_shelf", () -> new ShelfBlockItem(ModBlocks.WARPED_SHELF_1.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> OVEN = register("oven", () -> new BlockItem(ModBlocks.OVEN.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> KITCHEN_HOOD = register("kitchen_hood", () -> new BlockItem(ModBlocks.KITCHEN_HOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> KITCHEN_HOOD_PIPE = register("kitchen_hood_pipe", () -> new KitchenHoodPipeItem(ModBlocks.KITCHEN_HOOD_PIPE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> ACACIA_PILLAR_TRIM = register("acacia_pillar_trim", () -> new HammerableBlockItem(ModBlocks.ACACIA_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ACACIA_CORNER_TRIM = register("acacia_corner_trim", () -> new HammerableBlockItem(ModBlocks.ACACIA_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_PILLAR_TRIM = register("birch_pillar_trim", () -> new HammerableBlockItem(ModBlocks.BIRCH_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_CORNER_TRIM = register("birch_corner_trim", () -> new HammerableBlockItem(ModBlocks.BIRCH_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_PILLAR_TRIM = register("dark_oak_pillar_trim", () -> new HammerableBlockItem(ModBlocks.DARK_OAK_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_CORNER_TRIM = register("dark_oak_corner_trim", () -> new HammerableBlockItem(ModBlocks.DARK_OAK_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_PILLAR_TRIM = register("jungle_pillar_trim", () -> new HammerableBlockItem(ModBlocks.JUNGLE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_CORNER_TRIM = register("jungle_corner_trim", () -> new HammerableBlockItem(ModBlocks.JUNGLE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_PILLAR_TRIM = register("mangrove_pillar_trim", () -> new HammerableBlockItem(ModBlocks.MANGROVE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_CORNER_TRIM = register("mangrove_corner_trim", () -> new HammerableBlockItem(ModBlocks.MANGROVE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_PILLAR_TRIM = register("oak_pillar_trim", () -> new HammerableBlockItem(ModBlocks.OAK_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_CORNER_TRIM = register("oak_corner_trim", () -> new HammerableBlockItem(ModBlocks.OAK_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_PILLAR_TRIM = register("spruce_pillar_trim", () -> new HammerableBlockItem(ModBlocks.SPRUCE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_CORNER_TRIM = register("spruce_corner_trim", () -> new HammerableBlockItem(ModBlocks.SPRUCE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_PILLAR_TRIM = register("crimson_pillar_trim", () -> new HammerableBlockItem(ModBlocks.CRIMSON_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_CORNER_TRIM = register("crimson_corner_trim", () -> new HammerableBlockItem(ModBlocks.CRIMSON_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_PILLAR_TRIM = register("warped_pillar_trim", () -> new HammerableBlockItem(ModBlocks.WARPED_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_CORNER_TRIM = register("warped_corner_trim", () -> new HammerableBlockItem(ModBlocks.WARPED_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ANDESITE_PILLAR_TRIM = register("andesite_pillar_trim", () -> new HammerableBlockItem(ModBlocks.ANDESITE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ANDESITE_CORNER_TRIM = register("andesite_corner_trim", () -> new HammerableBlockItem(ModBlocks.ANDESITE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLACKSTONE_PILLAR_TRIM = register("blackstone_pillar_trim", () -> new HammerableBlockItem(ModBlocks.BLACKSTONE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLACKSTONE_CORNER_TRIM = register("blackstone_corner_trim", () -> new HammerableBlockItem(ModBlocks.BLACKSTONE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BRICKS_PILLAR_TRIM = register("bricks_pillar_trim", () -> new HammerableBlockItem(ModBlocks.BRICKS_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BRICKS_CORNER_TRIM = register("bricks_corner_trim", () -> new HammerableBlockItem(ModBlocks.BRICKS_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CALCITE_PILLAR_TRIM = register("calcite_pillar_trim", () -> new HammerableBlockItem(ModBlocks.CALCITE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CALCITE_CORNER_TRIM = register("calcite_corner_trim", () -> new HammerableBlockItem(ModBlocks.CALCITE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DEEPSLATE_PILLAR_TRIM = register("deepslate_pillar_trim", () -> new HammerableBlockItem(ModBlocks.DEEPSLATE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DEEPSLATE_CORNER_TRIM = register("deepslate_corner_trim", () -> new HammerableBlockItem(ModBlocks.DEEPSLATE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DIORITE_PILLAR_TRIM = register("diorite_pillar_trim", () -> new HammerableBlockItem(ModBlocks.DIORITE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DIORITE_CORNER_TRIM = register("diorite_corner_trim", () -> new HammerableBlockItem(ModBlocks.DIORITE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DRIPSTONE_PILLAR_TRIM = register("dripstone_pillar_trim", () -> new HammerableBlockItem(ModBlocks.DRIPSTONE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DRIPSTONE_CORNER_TRIM = register("dripstone_corner_trim", () -> new HammerableBlockItem(ModBlocks.DRIPSTONE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRANITE_PILLAR_TRIM = register("granite_pillar_trim", () -> new HammerableBlockItem(ModBlocks.GRANITE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRANITE_CORNER_TRIM = register("granite_corner_trim", () -> new HammerableBlockItem(ModBlocks.GRANITE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> QUARTZ_PILLAR_TRIM = register("quartz_pillar_trim", () -> new HammerableBlockItem(ModBlocks.QUARTZ_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> QUARTZ_CORNER_TRIM = register("quartz_corner_trim", () -> new HammerableBlockItem(ModBlocks.QUARTZ_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> STONE_PILLAR_TRIM = register("stone_pillar_trim", () -> new HammerableBlockItem(ModBlocks.STONE_PILLAR_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> STONE_CORNER_TRIM = register("stone_corner_trim", () -> new HammerableBlockItem(ModBlocks.STONE_CORNER_TRIM.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BERRY_JAM_JAR = register("berry_jam_jar", () -> new RenderedBlockItem(ModBlocks.BERRY_JAM_JAR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WHITE_CUP = register("white_cup", () -> new BlockItem(ModBlocks.WHITE_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_PLATE = register("white_plate", () -> new BlockItem(ModBlocks.WHITE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_BOWL = register("white_bowl", () -> new BlockItem(ModBlocks.WHITE_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_CROCKERY_COMBO = register("white_crockery_combo", () -> new BlockItem(ModBlocks.WHITE_CROCKERY_COMBO.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> YELLOW_CUP = register("yellow_cup", () -> new BlockItem(ModBlocks.YELLOW_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_PLATE = register("yellow_plate", () -> new BlockItem(ModBlocks.YELLOW_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_BOWL = register("yellow_bowl", () -> new BlockItem(ModBlocks.YELLOW_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_CROCKERY_COMBO = register("yellow_crockery_combo", () -> new BlockItem(ModBlocks.YELLOW_CROCKERY_COMBO.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BLUE_CUP = register("blue_cup", () -> new BlockItem(ModBlocks.BLUE_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_PLATE = register("blue_plate", () -> new BlockItem(ModBlocks.BLUE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_BOWL = register("blue_bowl", () -> new BlockItem(ModBlocks.BLUE_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_CROCKERY_COMBO = register("blue_crockery_combo", () -> new BlockItem(ModBlocks.BLUE_CROCKERY_COMBO.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WOOD_CUP = register("wood_cup", () -> new BlockItem(ModBlocks.WOOD_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOOD_PLATE = register("wood_plate", () -> new BlockItem(ModBlocks.WOOD_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOOD_BOWL = register("wood_bowl", () -> new BlockItem(ModBlocks.WOOD_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOOD_CROCKERY_COMBO = register("wood_crockery_combo", () -> new BlockItem(ModBlocks.WOOD_CROCKERY_COMBO.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> TERRACOTTA_CUP = register("terracotta_cup", () -> new BlockItem(ModBlocks.TERRACOTTA_CUP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_PLATE = register("terracotta_plate", () -> new BlockItem(ModBlocks.TERRACOTTA_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_BOWL = register("terracotta_bowl", () -> new BlockItem(ModBlocks.TERRACOTTA_BOWL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_CROCKERY_COMBO = register("terracotta_crockery_combo", () -> new BlockItem(ModBlocks.TERRACOTTA_CROCKERY_COMBO.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> TERRACOTTA_THIN_POT = register("terracotta_thin_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_MEDIUM_POT = register("terracotta_medium_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_WIDE_POT = register("terracotta_wide_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TERRACOTTA_THICK_POT = register("terracotta_thick_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WHITE_GLAZED_THIN_POT = register("white_glazed_thin_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_MEDIUM_POT = register("white_glazed_medium_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_WIDE_POT = register("white_glazed_wide_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_GLAZED_THICK_POT = register("white_glazed_thick_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BLUE_GLAZED_THIN_POT = register("blue_glazed_thin_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_MEDIUM_POT = register("blue_glazed_medium_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_WIDE_POT = register("blue_glazed_wide_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_GLAZED_THICK_POT = register("blue_glazed_thick_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> GOLDEN_THIN_POT = register("golden_thin_pot", () -> new BlockItem(ModBlocks.GOLDEN_THIN_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_MEDIUM_POT = register("golden_medium_pot", () -> new BlockItem(ModBlocks.GOLDEN_MEDIUM_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_WIDE_POT = register("golden_wide_pot", () -> new BlockItem(ModBlocks.GOLDEN_WIDE_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOLDEN_THICK_POT = register("golden_thick_pot", () -> new BlockItem(ModBlocks.GOLDEN_THICK_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> BEAR_TROPHY = register("bear_trophy", () -> new BlockItem(ModBlocks.BEAR_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLAZE_TROPHY = register("blaze_trophy", () -> new BlockItem(ModBlocks.BLAZE_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> FOX_TROPHY = register("fox_trophy", () -> new BlockItem(ModBlocks.FOX_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GOAT_TROPHY = register("goat_trophy", () -> new BlockItem(ModBlocks.GOAT_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PUFFERFISH_TROPHY = register("pufferfish_trophy", () -> new BlockItem(ModBlocks.PUFFERFISH_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SALMON_TROPHY = register("salmon_trophy", () -> new BlockItem(ModBlocks.SALMON_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SILVERFISH_TROPHY = register("silverfish_trophy", () -> new BlockItem(ModBlocks.SILVERFISH_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SKELETON_HORSE_TROPHY = register("skeleton_horse_trophy", () -> new BlockItem(ModBlocks.SKELETON_HORSE_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPIDER_TROPHY = register("spider_trophy", () -> new BlockItem(ModBlocks.SPIDER_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> TROPICAL_FISH_TROPHY = register("tropical_fish_trophy", () -> new BlockItem(ModBlocks.TROPICAL_FISH_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WITHER_SKELETON_TROPHY = register("wither_skeleton_trophy", () -> new BlockItem(ModBlocks.WITHER_SKELETON_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WOLF_TROPHY = register("wolf_trophy", () -> new BlockItem(ModBlocks.WOLF_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> PHANTOM_TROPHY = register("phantom_trophy", () -> new BlockItem(ModBlocks.PHANTOM_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CREEPER_TROPHY = register("creeper_trophy", () -> new BlockItem(ModBlocks.CREEPER_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SKELETON_TROPHY = register("skeleton_trophy", () -> new BlockItem(ModBlocks.SKELETON_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> EVOKER_TROPHY = register("evoker_trophy", () -> new BlockItem(ModBlocks.EVOKER_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PILLAGER_TROPHY = register("pillager_trophy", () -> new BlockItem(ModBlocks.PILLAGER_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> VINDICATOR_TROPHY = register("vindicator_trophy", () -> new BlockItem(ModBlocks.VINDICATOR_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> WITCH_TROPHY = register("witch_trophy", () -> new RenderedBlockItem(ModBlocks.WITCH_TROPHY.get(), new Item.Properties().tab(ITEM_GROUP)));

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return ModRegistryHelpers.register(Registry.ITEM, id, item);
    }

    public static void init() {
    }
}