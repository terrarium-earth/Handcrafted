package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.items.CustomPaintingItem;
import earth.terrarium.handcrafted.common.items.HammerItem;
import earth.terrarium.handcrafted.common.items.TooltipBlockItem;
import earth.terrarium.handcrafted.common.items.TooltipItem;
import earth.terrarium.handcrafted.common.tags.ModPaintingVariantTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, Handcrafted.MOD_ID);
    public static final Supplier<CreativeModeTab> TAB = new ResourcefulCreativeTab(new ResourceLocation(Handcrafted.MOD_ID, "main"))
        .setItemIcon(() -> ModItems.OAK_BENCH.get())
        .addRegistry(ITEMS)
        .build();

    public static final ResourcefulRegistry<Item> CUSHIONS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> SHEETS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BENCHES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> WOODEN_BENCHES = ResourcefulRegistries.create(BENCHES);
    public static final ResourcefulRegistry<Item> METAL_BENCHES = ResourcefulRegistries.create(BENCHES);
    public static final ResourcefulRegistry<Item> COUCHES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> CHAIRS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> DINING_BENCHES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> SIDE_TABLES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> DESKS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> NIGHTSTANDS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> TABLES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> FANCY_BEDS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> COUNTERS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> CUPBOARDS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> DRAWERS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> SHELVES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> TRIMS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> PILLAR_TRIMS = ResourcefulRegistries.create(TRIMS);
    public static final ResourcefulRegistry<Item> CORNER_TRIMS = ResourcefulRegistries.create(TRIMS);
    public static final ResourcefulRegistry<Item> POTS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> TROPHIES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> CROCKERY = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> CUPS = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Item> PLATES = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Item> BOWLS = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Item> CROCKERY_COMBOS = ResourcefulRegistries.create(CROCKERY);

    public static final RegistryEntry<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().stacksTo(1)));
    public static final RegistryEntry<Item> FANCY_PAINTING = ITEMS.register("fancy_painting", () -> new CustomPaintingItem(new Item.Properties(), ModPaintingVariants.APPLE, ModPaintingVariantTags.PAINTINGS));

    public static final RegistryEntry<Item> OVEN = ITEMS.register("oven", () -> new BlockItem(ModBlocks.OVEN.get(), new Item.Properties()));
    public static final RegistryEntry<Item> KITCHEN_HOOD = ITEMS.register("kitchen_hood", () -> new BlockItem(ModBlocks.KITCHEN_HOOD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> KITCHEN_HOOD_PIPE = ITEMS.register("kitchen_hood_pipe", () -> new TooltipBlockItem(ModBlocks.KITCHEN_HOOD_PIPE.get(), ConstantComponents.HAMMER_USE_SHAPE, new Item.Properties()));
    public static final RegistryEntry<Item> BERRY_JAM_JAR = ITEMS.register("berry_jam_jar", () -> new BlockItem(ModBlocks.BERRY_JAM_JAR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> STACKABLE_BOOK = ITEMS.register("stackable_book", () -> new BlockItem(ModBlocks.STACKABLE_BOOK.get(), new Item.Properties()));

    public static final RegistryEntry<Item> BLACK_CUSHION = CUSHIONS.register("black_cushion", () -> new ItemNameBlockItem(ModBlocks.BLACK_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_CUSHION = CUSHIONS.register("blue_cushion", () -> new ItemNameBlockItem(ModBlocks.BLUE_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BROWN_CUSHION = CUSHIONS.register("brown_cushion", () -> new ItemNameBlockItem(ModBlocks.BROWN_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CYAN_CUSHION = CUSHIONS.register("cyan_cushion", () -> new ItemNameBlockItem(ModBlocks.CYAN_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GRAY_CUSHION = CUSHIONS.register("gray_cushion", () -> new ItemNameBlockItem(ModBlocks.GRAY_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GREEN_CUSHION = CUSHIONS.register("green_cushion", () -> new ItemNameBlockItem(ModBlocks.GREEN_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> LIGHT_BLUE_CUSHION = CUSHIONS.register("light_blue_cushion", () -> new ItemNameBlockItem(ModBlocks.LIGHT_BLUE_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> LIGHT_GRAY_CUSHION = CUSHIONS.register("light_gray_cushion", () -> new ItemNameBlockItem(ModBlocks.LIGHT_GRAY_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> LIME_CUSHION = CUSHIONS.register("lime_cushion", () -> new ItemNameBlockItem(ModBlocks.LIME_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MAGENTA_CUSHION = CUSHIONS.register("magenta_cushion", () -> new ItemNameBlockItem(ModBlocks.MAGENTA_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> ORANGE_CUSHION = CUSHIONS.register("orange_cushion", () -> new ItemNameBlockItem(ModBlocks.ORANGE_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINK_CUSHION = CUSHIONS.register("pink_cushion", () -> new ItemNameBlockItem(ModBlocks.PINK_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PURPLE_CUSHION = CUSHIONS.register("purple_cushion", () -> new ItemNameBlockItem(ModBlocks.PURPLE_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> RED_CUSHION = CUSHIONS.register("red_cushion", () -> new ItemNameBlockItem(ModBlocks.RED_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_CUSHION = CUSHIONS.register("white_cushion", () -> new ItemNameBlockItem(ModBlocks.WHITE_CUSHION.get(), new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_CUSHION = CUSHIONS.register("yellow_cushion", () -> new ItemNameBlockItem(ModBlocks.YELLOW_CUSHION.get(), new Item.Properties()));

    public static final RegistryEntry<Item> BLACK_SHEET = SHEETS.register("black_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_SHEET = SHEETS.register("blue_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> BROWN_SHEET = SHEETS.register("brown_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> CYAN_SHEET = SHEETS.register("cyan_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> GRAY_SHEET = SHEETS.register("gray_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> GREEN_SHEET = SHEETS.register("green_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> LIGHT_BLUE_SHEET = SHEETS.register("light_blue_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> LIGHT_GRAY_SHEET = SHEETS.register("light_gray_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> LIME_SHEET = SHEETS.register("lime_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> MAGENTA_SHEET = SHEETS.register("magenta_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> ORANGE_SHEET = SHEETS.register("orange_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> PINK_SHEET = SHEETS.register("pink_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> PURPLE_SHEET = SHEETS.register("purple_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> RED_SHEET = SHEETS.register("red_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_SHEET = SHEETS.register("white_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_SHEET = SHEETS.register("yellow_sheet", () -> new TooltipItem(ConstantComponents.PLACE_ON_FURNITURE, new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_BENCH = WOODEN_BENCHES.register("acacia_bench", () -> new BlockItem(ModBlocks.ACACIA_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_BENCH = WOODEN_BENCHES.register("bamboo_bench", () -> new BlockItem(ModBlocks.BAMBOO_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_BENCH = WOODEN_BENCHES.register("birch_bench", () -> new BlockItem(ModBlocks.BIRCH_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_BENCH = WOODEN_BENCHES.register("cherry_bench", () -> new BlockItem(ModBlocks.CHERRY_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_BENCH = WOODEN_BENCHES.register("crimson_bench", () -> new BlockItem(ModBlocks.CRIMSON_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_BENCH = WOODEN_BENCHES.register("dark_oak_bench", () -> new BlockItem(ModBlocks.DARK_OAK_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_BENCH = WOODEN_BENCHES.register("jungle_bench", () -> new BlockItem(ModBlocks.JUNGLE_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_BENCH = WOODEN_BENCHES.register("mangrove_bench", () -> new BlockItem(ModBlocks.MANGROVE_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_BENCH = WOODEN_BENCHES.register("oak_bench", () -> new BlockItem(ModBlocks.OAK_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_BENCH = WOODEN_BENCHES.register("spruce_bench", () -> new BlockItem(ModBlocks.SPRUCE_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_BENCH = WOODEN_BENCHES.register("warped_bench", () -> new BlockItem(ModBlocks.WARPED_BENCH.get(), new Item.Properties()));

    public static final RegistryEntry<Item> BENCH = METAL_BENCHES.register("bench", () -> new BlockItem(ModBlocks.BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> FROZEN_BENCH = METAL_BENCHES.register("frozen_bench", () -> new BlockItem(ModBlocks.FROZEN_BENCH.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_COUCH = COUCHES.register("acacia_couch", () -> new BlockItem(ModBlocks.ACACIA_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_COUCH = COUCHES.register("bamboo_couch", () -> new BlockItem(ModBlocks.BAMBOO_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_COUCH = COUCHES.register("birch_couch", () -> new BlockItem(ModBlocks.BIRCH_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_COUCH = COUCHES.register("cherry_couch", () -> new BlockItem(ModBlocks.CHERRY_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_COUCH = COUCHES.register("crimson_couch", () -> new BlockItem(ModBlocks.CRIMSON_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_COUCH = COUCHES.register("dark_oak_couch", () -> new BlockItem(ModBlocks.DARK_OAK_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_COUCH = COUCHES.register("jungle_couch", () -> new BlockItem(ModBlocks.JUNGLE_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_COUCH = COUCHES.register("mangrove_couch", () -> new BlockItem(ModBlocks.MANGROVE_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_COUCH = COUCHES.register("oak_couch", () -> new BlockItem(ModBlocks.OAK_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_COUCH = COUCHES.register("spruce_couch", () -> new BlockItem(ModBlocks.SPRUCE_COUCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_COUCH = COUCHES.register("warped_couch", () -> new BlockItem(ModBlocks.WARPED_COUCH.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_CHAIR = CHAIRS.register("acacia_chair", () -> new BlockItem(ModBlocks.ACACIA_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_CHAIR = CHAIRS.register("bamboo_chair", () -> new BlockItem(ModBlocks.BAMBOO_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_CHAIR = CHAIRS.register("birch_chair", () -> new BlockItem(ModBlocks.BIRCH_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_CHAIR = CHAIRS.register("cherry_chair", () -> new BlockItem(ModBlocks.CHERRY_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_CHAIR = CHAIRS.register("crimson_chair", () -> new BlockItem(ModBlocks.CRIMSON_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_CHAIR = CHAIRS.register("dark_oak_chair", () -> new BlockItem(ModBlocks.DARK_OAK_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_CHAIR = CHAIRS.register("jungle_chair", () -> new BlockItem(ModBlocks.JUNGLE_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_CHAIR = CHAIRS.register("mangrove_chair", () -> new BlockItem(ModBlocks.MANGROVE_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_CHAIR = CHAIRS.register("oak_chair", () -> new BlockItem(ModBlocks.OAK_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_CHAIR = CHAIRS.register("spruce_chair", () -> new BlockItem(ModBlocks.SPRUCE_CHAIR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_CHAIR = CHAIRS.register("warped_chair", () -> new BlockItem(ModBlocks.WARPED_CHAIR.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_DINING_BENCH = DINING_BENCHES.register("acacia_dining_bench", () -> new BlockItem(ModBlocks.ACACIA_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_DINING_BENCH = DINING_BENCHES.register("bamboo_dining_bench", () -> new BlockItem(ModBlocks.BAMBOO_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_DINING_BENCH = DINING_BENCHES.register("birch_dining_bench", () -> new BlockItem(ModBlocks.BIRCH_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_DINING_BENCH = DINING_BENCHES.register("cherry_dining_bench", () -> new BlockItem(ModBlocks.CHERRY_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_DINING_BENCH = DINING_BENCHES.register("crimson_dining_bench", () -> new BlockItem(ModBlocks.CRIMSON_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_DINING_BENCH = DINING_BENCHES.register("dark_oak_dining_bench", () -> new BlockItem(ModBlocks.DARK_OAK_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_DINING_BENCH = DINING_BENCHES.register("jungle_dining_bench", () -> new BlockItem(ModBlocks.JUNGLE_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_DINING_BENCH = DINING_BENCHES.register("mangrove_dining_bench", () -> new BlockItem(ModBlocks.MANGROVE_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_DINING_BENCH = DINING_BENCHES.register("oak_dining_bench", () -> new BlockItem(ModBlocks.OAK_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_DINING_BENCH = DINING_BENCHES.register("spruce_dining_bench", () -> new BlockItem(ModBlocks.SPRUCE_DINING_BENCH.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_DINING_BENCH = DINING_BENCHES.register("warped_dining_bench", () -> new BlockItem(ModBlocks.WARPED_DINING_BENCH.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_SIDE_TABLE = SIDE_TABLES.register("acacia_side_table", () -> new BlockItem(ModBlocks.ACACIA_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_SIDE_TABLE = SIDE_TABLES.register("birch_side_table", () -> new BlockItem(ModBlocks.BIRCH_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_SIDE_TABLE = SIDE_TABLES.register("dark_oak_side_table", () -> new BlockItem(ModBlocks.DARK_OAK_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_SIDE_TABLE = SIDE_TABLES.register("jungle_side_table", () -> new BlockItem(ModBlocks.JUNGLE_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_SIDE_TABLE = SIDE_TABLES.register("mangrove_side_table", () -> new BlockItem(ModBlocks.MANGROVE_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_SIDE_TABLE = SIDE_TABLES.register("oak_side_table", () -> new BlockItem(ModBlocks.OAK_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_SIDE_TABLE = SIDE_TABLES.register("spruce_side_table", () -> new BlockItem(ModBlocks.SPRUCE_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_SIDE_TABLE = SIDE_TABLES.register("crimson_side_table", () -> new BlockItem(ModBlocks.CRIMSON_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_SIDE_TABLE = SIDE_TABLES.register("warped_side_table", () -> new BlockItem(ModBlocks.WARPED_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_SIDE_TABLE = SIDE_TABLES.register("cherry_side_table", () -> new BlockItem(ModBlocks.CHERRY_SIDE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_SIDE_TABLE = SIDE_TABLES.register("bamboo_side_table", () -> new BlockItem(ModBlocks.BAMBOO_SIDE_TABLE.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_DESK = DESKS.register("acacia_desk", () -> new BlockItem(ModBlocks.ACACIA_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_DESK = DESKS.register("bamboo_desk", () -> new BlockItem(ModBlocks.BAMBOO_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_DESK = DESKS.register("birch_desk", () -> new BlockItem(ModBlocks.BIRCH_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_DESK = DESKS.register("cherry_desk", () -> new BlockItem(ModBlocks.CHERRY_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_DESK = DESKS.register("crimson_desk", () -> new BlockItem(ModBlocks.CRIMSON_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_DESK = DESKS.register("dark_oak_desk", () -> new BlockItem(ModBlocks.DARK_OAK_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_DESK = DESKS.register("jungle_desk", () -> new BlockItem(ModBlocks.JUNGLE_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_DESK = DESKS.register("mangrove_desk", () -> new BlockItem(ModBlocks.MANGROVE_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_DESK = DESKS.register("oak_desk", () -> new BlockItem(ModBlocks.OAK_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_DESK = DESKS.register("spruce_desk", () -> new BlockItem(ModBlocks.SPRUCE_DESK.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_DESK = DESKS.register("warped_desk", () -> new BlockItem(ModBlocks.WARPED_DESK.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_NIGHTSTAND = NIGHTSTANDS.register("acacia_nightstand", () -> new BlockItem(ModBlocks.ACACIA_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_NIGHTSTAND = NIGHTSTANDS.register("bamboo_nightstand", () -> new BlockItem(ModBlocks.BAMBOO_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_NIGHTSTAND = NIGHTSTANDS.register("birch_nightstand", () -> new BlockItem(ModBlocks.BIRCH_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_NIGHTSTAND = NIGHTSTANDS.register("cherry_nightstand", () -> new BlockItem(ModBlocks.CHERRY_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_NIGHTSTAND = NIGHTSTANDS.register("crimson_nightstand", () -> new BlockItem(ModBlocks.CRIMSON_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_NIGHTSTAND = NIGHTSTANDS.register("dark_oak_nightstand", () -> new BlockItem(ModBlocks.DARK_OAK_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_NIGHTSTAND = NIGHTSTANDS.register("jungle_nightstand", () -> new BlockItem(ModBlocks.JUNGLE_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_NIGHTSTAND = NIGHTSTANDS.register("mangrove_nightstand", () -> new BlockItem(ModBlocks.MANGROVE_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_NIGHTSTAND = NIGHTSTANDS.register("oak_nightstand", () -> new BlockItem(ModBlocks.OAK_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_NIGHTSTAND = NIGHTSTANDS.register("spruce_nightstand", () -> new BlockItem(ModBlocks.SPRUCE_NIGHTSTAND.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_NIGHTSTAND = NIGHTSTANDS.register("warped_nightstand", () -> new BlockItem(ModBlocks.WARPED_NIGHTSTAND.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_TABLE = TABLES.register("acacia_table", () -> new BlockItem(ModBlocks.ACACIA_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_TABLE = TABLES.register("bamboo_table", () -> new BlockItem(ModBlocks.BAMBOO_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_TABLE = TABLES.register("birch_table", () -> new BlockItem(ModBlocks.BIRCH_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_TABLE = TABLES.register("cherry_table", () -> new BlockItem(ModBlocks.CHERRY_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_TABLE = TABLES.register("crimson_table", () -> new BlockItem(ModBlocks.CRIMSON_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_TABLE = TABLES.register("dark_oak_table", () -> new BlockItem(ModBlocks.DARK_OAK_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_TABLE = TABLES.register("jungle_table", () -> new BlockItem(ModBlocks.JUNGLE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_TABLE = TABLES.register("mangrove_table", () -> new BlockItem(ModBlocks.MANGROVE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_TABLE = TABLES.register("oak_table", () -> new BlockItem(ModBlocks.OAK_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_TABLE = TABLES.register("spruce_table", () -> new BlockItem(ModBlocks.SPRUCE_TABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_TABLE = TABLES.register("warped_table", () -> new BlockItem(ModBlocks.WARPED_TABLE.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_FANCY_BED = FANCY_BEDS.register("acacia_fancy_bed", () -> new BlockItem(ModBlocks.ACACIA_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_FANCY_BED = FANCY_BEDS.register("bamboo_fancy_bed", () -> new BlockItem(ModBlocks.BAMBOO_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_FANCY_BED = FANCY_BEDS.register("birch_fancy_bed", () -> new BlockItem(ModBlocks.BIRCH_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_FANCY_BED = FANCY_BEDS.register("cherry_fancy_bed", () -> new BlockItem(ModBlocks.CHERRY_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_FANCY_BED = FANCY_BEDS.register("crimson_fancy_bed", () -> new BlockItem(ModBlocks.CRIMSON_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_FANCY_BED = FANCY_BEDS.register("dark_oak_fancy_bed", () -> new BlockItem(ModBlocks.DARK_OAK_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_FANCY_BED = FANCY_BEDS.register("jungle_fancy_bed", () -> new BlockItem(ModBlocks.JUNGLE_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_FANCY_BED = FANCY_BEDS.register("mangrove_fancy_bed", () -> new BlockItem(ModBlocks.MANGROVE_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_FANCY_BED = FANCY_BEDS.register("oak_fancy_bed", () -> new BlockItem(ModBlocks.OAK_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_FANCY_BED = FANCY_BEDS.register("spruce_fancy_bed", () -> new BlockItem(ModBlocks.SPRUCE_FANCY_BED.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_FANCY_BED = FANCY_BEDS.register("warped_fancy_bed", () -> new BlockItem(ModBlocks.WARPED_FANCY_BED.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_COUNTER = COUNTERS.register("acacia_counter", () -> new BlockItem(ModBlocks.ACACIA_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_COUNTER = COUNTERS.register("bamboo_counter", () -> new BlockItem(ModBlocks.BAMBOO_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_COUNTER = COUNTERS.register("birch_counter", () -> new BlockItem(ModBlocks.BIRCH_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_COUNTER = COUNTERS.register("cherry_counter", () -> new BlockItem(ModBlocks.CHERRY_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_COUNTER = COUNTERS.register("crimson_counter", () -> new BlockItem(ModBlocks.CRIMSON_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_COUNTER = COUNTERS.register("dark_oak_counter", () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_COUNTER = COUNTERS.register("jungle_counter", () -> new BlockItem(ModBlocks.JUNGLE_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_COUNTER = COUNTERS.register("mangrove_counter", () -> new BlockItem(ModBlocks.MANGROVE_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_COUNTER = COUNTERS.register("oak_counter", () -> new BlockItem(ModBlocks.OAK_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_COUNTER = COUNTERS.register("spruce_counter", () -> new BlockItem(ModBlocks.SPRUCE_COUNTER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_COUNTER = COUNTERS.register("warped_counter", () -> new BlockItem(ModBlocks.WARPED_COUNTER.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_CUPBOARD = CUPBOARDS.register("acacia_cupboard", () -> new BlockItem(ModBlocks.ACACIA_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_CUPBOARD = CUPBOARDS.register("bamboo_cupboard", () -> new BlockItem(ModBlocks.BAMBOO_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_CUPBOARD = CUPBOARDS.register("birch_cupboard", () -> new BlockItem(ModBlocks.BIRCH_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_CUPBOARD = CUPBOARDS.register("cherry_cupboard", () -> new BlockItem(ModBlocks.CHERRY_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_CUPBOARD = CUPBOARDS.register("crimson_cupboard", () -> new BlockItem(ModBlocks.CRIMSON_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_CUPBOARD = CUPBOARDS.register("dark_oak_cupboard", () -> new BlockItem(ModBlocks.DARK_OAK_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_CUPBOARD = CUPBOARDS.register("jungle_cupboard", () -> new BlockItem(ModBlocks.JUNGLE_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_CUPBOARD = CUPBOARDS.register("mangrove_cupboard", () -> new BlockItem(ModBlocks.MANGROVE_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_CUPBOARD = CUPBOARDS.register("oak_cupboard", () -> new BlockItem(ModBlocks.OAK_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_CUPBOARD = CUPBOARDS.register("spruce_cupboard", () -> new BlockItem(ModBlocks.SPRUCE_CUPBOARD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_CUPBOARD = CUPBOARDS.register("warped_cupboard", () -> new BlockItem(ModBlocks.WARPED_CUPBOARD.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_DRAWER = DRAWERS.register("acacia_drawer", () -> new BlockItem(ModBlocks.ACACIA_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_DRAWER = DRAWERS.register("bamboo_drawer", () -> new BlockItem(ModBlocks.BAMBOO_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_DRAWER = DRAWERS.register("birch_drawer", () -> new BlockItem(ModBlocks.BIRCH_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_DRAWER = DRAWERS.register("cherry_drawer", () -> new BlockItem(ModBlocks.CHERRY_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_DRAWER = DRAWERS.register("crimson_drawer", () -> new BlockItem(ModBlocks.CRIMSON_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_DRAWER = DRAWERS.register("dark_oak_drawer", () -> new BlockItem(ModBlocks.DARK_OAK_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_DRAWER = DRAWERS.register("jungle_drawer", () -> new BlockItem(ModBlocks.JUNGLE_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_DRAWER = DRAWERS.register("mangrove_drawer", () -> new BlockItem(ModBlocks.MANGROVE_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_DRAWER = DRAWERS.register("oak_drawer", () -> new BlockItem(ModBlocks.OAK_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_DRAWER = DRAWERS.register("spruce_drawer", () -> new BlockItem(ModBlocks.SPRUCE_DRAWER.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_DRAWER = DRAWERS.register("warped_drawer", () -> new BlockItem(ModBlocks.WARPED_DRAWER.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_SHELF = SHELVES.register("acacia_shelf", () -> new BlockItem(ModBlocks.ACACIA_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_SHELF = SHELVES.register("bamboo_shelf", () -> new BlockItem(ModBlocks.BAMBOO_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_SHELF = SHELVES.register("birch_shelf", () -> new BlockItem(ModBlocks.BIRCH_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_SHELF = SHELVES.register("cherry_shelf", () -> new BlockItem(ModBlocks.CHERRY_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_SHELF = SHELVES.register("crimson_shelf", () -> new BlockItem(ModBlocks.CRIMSON_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_SHELF = SHELVES.register("dark_oak_shelf", () -> new BlockItem(ModBlocks.DARK_OAK_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_SHELF = SHELVES.register("jungle_shelf", () -> new BlockItem(ModBlocks.JUNGLE_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_SHELF = SHELVES.register("mangrove_shelf", () -> new BlockItem(ModBlocks.MANGROVE_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_SHELF = SHELVES.register("oak_shelf", () -> new BlockItem(ModBlocks.OAK_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_SHELF = SHELVES.register("spruce_shelf", () -> new BlockItem(ModBlocks.SPRUCE_SHELF.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_SHELF = SHELVES.register("warped_shelf", () -> new BlockItem(ModBlocks.WARPED_SHELF.get(), new Item.Properties()));

    public static final RegistryEntry<Item> ACACIA_PILLAR_TRIM = PILLAR_TRIMS.register("acacia_pillar_trim", () -> new BlockItem(ModBlocks.ACACIA_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> ACACIA_CORNER_TRIM = CORNER_TRIMS.register("acacia_corner_trim", () -> new BlockItem(ModBlocks.ACACIA_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_PILLAR_TRIM = PILLAR_TRIMS.register("bamboo_pillar_trim", () -> new BlockItem(ModBlocks.BAMBOO_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BAMBOO_CORNER_TRIM = CORNER_TRIMS.register("bamboo_corner_trim", () -> new BlockItem(ModBlocks.BAMBOO_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_PILLAR_TRIM = PILLAR_TRIMS.register("birch_pillar_trim", () -> new BlockItem(ModBlocks.BIRCH_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BIRCH_CORNER_TRIM = CORNER_TRIMS.register("birch_corner_trim", () -> new BlockItem(ModBlocks.BIRCH_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_PILLAR_TRIM = PILLAR_TRIMS.register("cherry_pillar_trim", () -> new BlockItem(ModBlocks.CHERRY_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CHERRY_CORNER_TRIM = CORNER_TRIMS.register("cherry_corner_trim", () -> new BlockItem(ModBlocks.CHERRY_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_PILLAR_TRIM = PILLAR_TRIMS.register("crimson_pillar_trim", () -> new BlockItem(ModBlocks.CRIMSON_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CRIMSON_CORNER_TRIM = CORNER_TRIMS.register("crimson_corner_trim", () -> new BlockItem(ModBlocks.CRIMSON_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_PILLAR_TRIM = PILLAR_TRIMS.register("dark_oak_pillar_trim", () -> new BlockItem(ModBlocks.DARK_OAK_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DARK_OAK_CORNER_TRIM = CORNER_TRIMS.register("dark_oak_corner_trim", () -> new BlockItem(ModBlocks.DARK_OAK_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_PILLAR_TRIM = PILLAR_TRIMS.register("jungle_pillar_trim", () -> new BlockItem(ModBlocks.JUNGLE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> JUNGLE_CORNER_TRIM = CORNER_TRIMS.register("jungle_corner_trim", () -> new BlockItem(ModBlocks.JUNGLE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_PILLAR_TRIM = PILLAR_TRIMS.register("mangrove_pillar_trim", () -> new BlockItem(ModBlocks.MANGROVE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> MANGROVE_CORNER_TRIM = CORNER_TRIMS.register("mangrove_corner_trim", () -> new BlockItem(ModBlocks.MANGROVE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_PILLAR_TRIM = PILLAR_TRIMS.register("oak_pillar_trim", () -> new BlockItem(ModBlocks.OAK_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OAK_CORNER_TRIM = CORNER_TRIMS.register("oak_corner_trim", () -> new BlockItem(ModBlocks.OAK_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_PILLAR_TRIM = PILLAR_TRIMS.register("spruce_pillar_trim", () -> new BlockItem(ModBlocks.SPRUCE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPRUCE_CORNER_TRIM = CORNER_TRIMS.register("spruce_corner_trim", () -> new BlockItem(ModBlocks.SPRUCE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_PILLAR_TRIM = PILLAR_TRIMS.register("warped_pillar_trim", () -> new BlockItem(ModBlocks.WARPED_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WARPED_CORNER_TRIM = CORNER_TRIMS.register("warped_corner_trim", () -> new BlockItem(ModBlocks.WARPED_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> ANDESITE_PILLAR_TRIM = PILLAR_TRIMS.register("andesite_pillar_trim", () -> new BlockItem(ModBlocks.ANDESITE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> ANDESITE_CORNER_TRIM = CORNER_TRIMS.register("andesite_corner_trim", () -> new BlockItem(ModBlocks.ANDESITE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLACKSTONE_PILLAR_TRIM = PILLAR_TRIMS.register("blackstone_pillar_trim", () -> new BlockItem(ModBlocks.BLACKSTONE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLACKSTONE_CORNER_TRIM = CORNER_TRIMS.register("blackstone_corner_trim", () -> new BlockItem(ModBlocks.BLACKSTONE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BRICKS_PILLAR_TRIM = PILLAR_TRIMS.register("bricks_pillar_trim", () -> new BlockItem(ModBlocks.BRICKS_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BRICKS_CORNER_TRIM = CORNER_TRIMS.register("bricks_corner_trim", () -> new BlockItem(ModBlocks.BRICKS_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CALCITE_PILLAR_TRIM = PILLAR_TRIMS.register("calcite_pillar_trim", () -> new BlockItem(ModBlocks.CALCITE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> CALCITE_CORNER_TRIM = CORNER_TRIMS.register("calcite_corner_trim", () -> new BlockItem(ModBlocks.CALCITE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DEEPSLATE_PILLAR_TRIM = PILLAR_TRIMS.register("deepslate_pillar_trim", () -> new BlockItem(ModBlocks.DEEPSLATE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DEEPSLATE_CORNER_TRIM = CORNER_TRIMS.register("deepslate_corner_trim", () -> new BlockItem(ModBlocks.DEEPSLATE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DIORITE_PILLAR_TRIM = PILLAR_TRIMS.register("diorite_pillar_trim", () -> new BlockItem(ModBlocks.DIORITE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DIORITE_CORNER_TRIM = CORNER_TRIMS.register("diorite_corner_trim", () -> new BlockItem(ModBlocks.DIORITE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DRIPSTONE_PILLAR_TRIM = PILLAR_TRIMS.register("dripstone_pillar_trim", () -> new BlockItem(ModBlocks.DRIPSTONE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DRIPSTONE_CORNER_TRIM = CORNER_TRIMS.register("dripstone_corner_trim", () -> new BlockItem(ModBlocks.DRIPSTONE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GRANITE_PILLAR_TRIM = PILLAR_TRIMS.register("granite_pillar_trim", () -> new BlockItem(ModBlocks.GRANITE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GRANITE_CORNER_TRIM = CORNER_TRIMS.register("granite_corner_trim", () -> new BlockItem(ModBlocks.GRANITE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> QUARTZ_PILLAR_TRIM = PILLAR_TRIMS.register("quartz_pillar_trim", () -> new BlockItem(ModBlocks.QUARTZ_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> QUARTZ_CORNER_TRIM = CORNER_TRIMS.register("quartz_corner_trim", () -> new BlockItem(ModBlocks.QUARTZ_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> STONE_PILLAR_TRIM = PILLAR_TRIMS.register("stone_pillar_trim", () -> new BlockItem(ModBlocks.STONE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> STONE_CORNER_TRIM = CORNER_TRIMS.register("stone_corner_trim", () -> new BlockItem(ModBlocks.STONE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SANDSTONE_PILLAR_TRIM = PILLAR_TRIMS.register("sandstone_pillar_trim", () -> new BlockItem(ModBlocks.SANDSTONE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SANDSTONE_CORNER_TRIM = CORNER_TRIMS.register("sandstone_corner_trim", () -> new BlockItem(ModBlocks.SANDSTONE_CORNER_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> RED_SANDSTONE_PILLAR_TRIM = PILLAR_TRIMS.register("red_sandstone_pillar_trim", () -> new BlockItem(ModBlocks.RED_SANDSTONE_PILLAR_TRIM.get(), new Item.Properties()));
    public static final RegistryEntry<Item> RED_SANDSTONE_CORNER_TRIM = CORNER_TRIMS.register("red_sandstone_corner_trim", () -> new BlockItem(ModBlocks.RED_SANDSTONE_CORNER_TRIM.get(), new Item.Properties()));

    public static final RegistryEntry<Item> TERRACOTTA_THIN_POT = POTS.register("terracotta_thin_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_THIN_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_MEDIUM_POT = POTS.register("terracotta_medium_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_MEDIUM_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_WIDE_POT = POTS.register("terracotta_wide_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_WIDE_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_THICK_POT = POTS.register("terracotta_thick_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_THICK_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_GLAZED_THIN_POT = POTS.register("white_glazed_thin_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THIN_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_GLAZED_MEDIUM_POT = POTS.register("white_glazed_medium_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_MEDIUM_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_GLAZED_WIDE_POT = POTS.register("white_glazed_wide_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_WIDE_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WHITE_GLAZED_THICK_POT = POTS.register("white_glazed_thick_pot", () -> new BlockItem(ModBlocks.WHITE_GLAZED_THICK_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_GLAZED_THIN_POT = POTS.register("blue_glazed_thin_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THIN_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_GLAZED_MEDIUM_POT = POTS.register("blue_glazed_medium_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_MEDIUM_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_GLAZED_WIDE_POT = POTS.register("blue_glazed_wide_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_WIDE_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_GLAZED_THICK_POT = POTS.register("blue_glazed_thick_pot", () -> new BlockItem(ModBlocks.BLUE_GLAZED_THICK_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GOLDEN_THIN_POT = POTS.register("golden_thin_pot", () -> new BlockItem(ModBlocks.GOLDEN_THIN_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GOLDEN_MEDIUM_POT = POTS.register("golden_medium_pot", () -> new BlockItem(ModBlocks.GOLDEN_MEDIUM_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GOLDEN_WIDE_POT = POTS.register("golden_wide_pot", () -> new BlockItem(ModBlocks.GOLDEN_WIDE_POT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GOLDEN_THICK_POT = POTS.register("golden_thick_pot", () -> new BlockItem(ModBlocks.GOLDEN_THICK_POT.get(), new Item.Properties()));

    public static final RegistryEntry<Item> BEAR_TROPHY = TROPHIES.register("bear_trophy", () -> new BlockItem(ModBlocks.BEAR_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLAZE_TROPHY = TROPHIES.register("blaze_trophy", () -> new BlockItem(ModBlocks.BLAZE_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> FOX_TROPHY = TROPHIES.register("fox_trophy", () -> new BlockItem(ModBlocks.FOX_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> GOAT_TROPHY = TROPHIES.register("goat_trophy", () -> new BlockItem(ModBlocks.GOAT_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PUFFERFISH_TROPHY = TROPHIES.register("pufferfish_trophy", () -> new BlockItem(ModBlocks.PUFFERFISH_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SALMON_TROPHY = TROPHIES.register("salmon_trophy", () -> new BlockItem(ModBlocks.SALMON_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SILVERFISH_TROPHY = TROPHIES.register("silverfish_trophy", () -> new BlockItem(ModBlocks.SILVERFISH_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SKELETON_HORSE_TROPHY = TROPHIES.register("skeleton_horse_trophy", () -> new BlockItem(ModBlocks.SKELETON_HORSE_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SPIDER_TROPHY = TROPHIES.register("spider_trophy", () -> new BlockItem(ModBlocks.SPIDER_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TROPICAL_FISH_TROPHY = TROPHIES.register("tropical_fish_trophy", () -> new BlockItem(ModBlocks.TROPICAL_FISH_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WITHER_SKELETON_TROPHY = TROPHIES.register("wither_skeleton_trophy", () -> new BlockItem(ModBlocks.WITHER_SKELETON_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WOLF_TROPHY = TROPHIES.register("wolf_trophy", () -> new BlockItem(ModBlocks.WOLF_TROPHY.get(), new Item.Properties()));

    public static final RegistryEntry<Item> PHANTOM_TROPHY = ITEMS.register("phantom_trophy", () -> new BlockItem(ModBlocks.PHANTOM_TROPHY.get(), new Item.Properties()));

    public static final RegistryEntry<Item> CREEPER_TROPHY = TROPHIES.register("creeper_trophy", () -> new BlockItem(ModBlocks.CREEPER_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> SKELETON_TROPHY = TROPHIES.register("skeleton_trophy", () -> new BlockItem(ModBlocks.SKELETON_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> EVOKER_TROPHY = TROPHIES.register("evoker_trophy", () -> new BlockItem(ModBlocks.EVOKER_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PILLAGER_TROPHY = TROPHIES.register("pillager_trophy", () -> new BlockItem(ModBlocks.PILLAGER_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> VINDICATOR_TROPHY = TROPHIES.register("vindicator_trophy", () -> new BlockItem(ModBlocks.VINDICATOR_TROPHY.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WITCH_TROPHY = TROPHIES.register("witch_trophy", () -> new BlockItem(ModBlocks.WITCH_TROPHY.get(), new Item.Properties()));

    public static final RegistryEntry<Item> WHITE_CUP = CUPS.register("white_cup", () -> new BlockItem(ModBlocks.WHITE_CUP.get(), new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_CUP = CUPS.register("yellow_cup", () -> new BlockItem(ModBlocks.YELLOW_CUP.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_CUP = CUPS.register("blue_cup", () -> new BlockItem(ModBlocks.BLUE_CUP.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WOOD_CUP = CUPS.register("wood_cup", () -> new BlockItem(ModBlocks.WOOD_CUP.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_CUP = CUPS.register("terracotta_cup", () -> new BlockItem(ModBlocks.TERRACOTTA_CUP.get(), new Item.Properties()));

    public static final RegistryEntry<Item> WHITE_PLATE = PLATES.register("white_plate", () -> new BlockItem(ModBlocks.WHITE_PLATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_PLATE = PLATES.register("yellow_plate", () -> new BlockItem(ModBlocks.YELLOW_PLATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_PLATE = PLATES.register("blue_plate", () -> new BlockItem(ModBlocks.BLUE_PLATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WOOD_PLATE = PLATES.register("wood_plate", () -> new BlockItem(ModBlocks.WOOD_PLATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_PLATE = PLATES.register("terracotta_plate", () -> new BlockItem(ModBlocks.TERRACOTTA_PLATE.get(), new Item.Properties()));

    public static final RegistryEntry<Item> WHITE_BOWL = BOWLS.register("white_bowl", () -> new BlockItem(ModBlocks.WHITE_BOWL.get(), new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_BOWL = BOWLS.register("yellow_bowl", () -> new BlockItem(ModBlocks.YELLOW_BOWL.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_BOWL = BOWLS.register("blue_bowl", () -> new BlockItem(ModBlocks.BLUE_BOWL.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WOOD_BOWL = BOWLS.register("wood_bowl", () -> new BlockItem(ModBlocks.WOOD_BOWL.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_BOWL = BOWLS.register("terracotta_bowl", () -> new BlockItem(ModBlocks.TERRACOTTA_BOWL.get(), new Item.Properties()));

    public static final RegistryEntry<Item> WHITE_CROCKERY_COMBO = CROCKERY_COMBOS.register("white_crockery_combo", () -> new BlockItem(ModBlocks.WHITE_CROCKERY_COMBO.get(), new Item.Properties()));
    public static final RegistryEntry<Item> YELLOW_CROCKERY_COMBO = CROCKERY_COMBOS.register("yellow_crockery_combo", () -> new BlockItem(ModBlocks.YELLOW_CROCKERY_COMBO.get(), new Item.Properties()));
    public static final RegistryEntry<Item> BLUE_CROCKERY_COMBO = CROCKERY_COMBOS.register("blue_crockery_combo", () -> new BlockItem(ModBlocks.BLUE_CROCKERY_COMBO.get(), new Item.Properties()));
    public static final RegistryEntry<Item> WOOD_CROCKERY_COMBO = CROCKERY_COMBOS.register("wood_crockery_combo", () -> new BlockItem(ModBlocks.WOOD_CROCKERY_COMBO.get(), new Item.Properties()));
    public static final RegistryEntry<Item> TERRACOTTA_CROCKERY_COMBO = CROCKERY_COMBOS.register("terracotta_crockery_combo", () -> new BlockItem(ModBlocks.TERRACOTTA_CROCKERY_COMBO.get(), new Item.Properties()));
}
