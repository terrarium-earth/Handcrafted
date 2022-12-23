package earth.terrarium.handcrafted.datagen.provider.server;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

@MethodsReturnNonnullByDefault
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        createColouredSetRecipe(consumer, "cushion", 8, r -> r
                .define('/', Items.FEATHER)
                .pattern("###")
                .pattern("///")
                .pattern("###"));

        createColouredSetRecipe(consumer, "sheet", 8, r -> r
                .pattern("   ")
                .pattern("###")
                .pattern("   "));

        createSimple(consumer, ModItems.HAMMER.get(), 1, r -> r
                .unlockedBy("has_board", has(ModTags.BOARDS))
                .define('#', ModTags.BOARDS)
                .define('/', Items.IRON_INGOT)
                .pattern(" / ")
                .pattern(" #/")
                .pattern("#  "));

        createSimple(consumer, ModItems.STACKABLE_BOOK.get(), 3, r -> r
                .unlockedBy("has_book", has(Items.BOOK))
                .define('#', Items.BOOK)
                .define('/', Tags.Items.DYES)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("/#/"));

        createSimpleShapeless(consumer, ModItems.FANCY_PAINTING.get(), 1, r -> r
                .unlockedBy("has_painting", has(Items.PAINTING))
                .requires(Items.PAINTING)
                .requires(Items.GOLD_INGOT));

        createWoodSetRecipe(consumer, "chair", 2, r -> r
                .pattern("#  ")
                .pattern("###")
                .pattern("# #"));

        createWoodSetRecipe(consumer, "table", 2, r -> r
                .pattern("   ")
                .pattern("###")
                .pattern("# #"));

        createWoodSetRecipe(consumer, "bench", 3, r -> r
                .pattern("###")
                .pattern("###")
                .pattern("# #"));

        createSimple(consumer, ModItems.BENCH.get(), 1, r -> r
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .define('#', Items.IRON_INGOT)
                .define('/', Items.IRON_BARS)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("/ /"));

        createSimple(consumer, ModItems.FROZEN_BENCH.get(), 1, r -> r
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .define('#', ModItems.BENCH.get())
                .define('/', Items.SNOWBALL)
                .pattern("///")
                .pattern(" # ")
                .pattern("   "));

        createWoodSetRecipe(consumer, "couch", 3, r -> r
                .define('@', ModItems.WHITE_CUSHION.get())
                .define('/', Items.WHITE_WOOL)
                .pattern(" @ ")
                .pattern("#/#")
                .pattern("###"));

        createWoodSetRecipe(consumer, "fancy_bed", 1, r -> r
                .define('@', ModItems.WHITE_CUSHION.get())
                .define('$', ModItems.WHITE_SHEET.get())
                .define('/', Items.WHITE_WOOL)
                .pattern("@$ ")
                .pattern("///")
                .pattern("###"));

        createWoodSetRecipe(consumer, "dining_bench", 3, r -> r
                .pattern("   ")
                .pattern("###")
                .pattern("# #"));

        createWoodSetRecipeWithPlanks(consumer, "nightstand", 2, r -> r
                .define('@', Items.CHEST)
                .pattern("///")
                .pattern("#@#")
                .pattern("###"));

        createWoodSetRecipeWithPlanks(consumer, "desk", 2, r -> r
                .define('@', Items.CHEST)
                .pattern("///")
                .pattern("#@#")
                .pattern("# #"));

        createWoodSetRecipeWithPlanks(consumer, "side_table", 2, r -> r
                .pattern("   ")
                .pattern("#/#")
                .pattern("# #"));

        createWoodSetRecipe(consumer, "counter", 2, r -> r
                .define('@', Items.CHEST)
                .define('/', Items.CALCITE)
                .pattern("///")
                .pattern("#@#")
                .pattern("###"));

        createWoodSetRecipe(consumer, "drawer", 2, r -> r
                .define('/', Items.CHEST)
                .pattern("###")
                .pattern("#/#")
                .pattern("###"));

        createWoodSetRecipeWithPlanks(consumer, "cupboard", 2, r -> r
                .define('@', Items.CHEST)
                .pattern("###")
                .pattern("/@/")
                .pattern("###"));

        createWoodSetRecipe(consumer, "shelf", 2, r -> r
                .pattern("###")
                .pattern("   ")
                .pattern("###"));

        createSimple(consumer, ModItems.OVEN.get(), 1, r -> r
                .unlockedBy("has_smoker", has(Items.SMOKER))
                .define('#', Items.BRICK)
                .define('/', Items.IRON_BARS)
                .define('@', Items.SMOKER)
                .pattern("#/#")
                .pattern("#@#")
                .pattern("###"));

        createSimple(consumer, ModItems.KITCHEN_HOOD.get(), 1, r -> r
                .unlockedBy("has_oven", has(ModItems.OVEN.get()))
                .define('#', Items.IRON_BARS)
                .define('/', ModItems.KITCHEN_HOOD_PIPE.get())
                .pattern(" / ")
                .pattern("###")
                .pattern("   "));

        createSimple(consumer, ModItems.KITCHEN_HOOD_PIPE.get(), 1, r -> r
                .unlockedBy("has_oven", has(ModItems.OVEN.get()))
                .define('#', Items.IRON_BARS)
                .pattern("# #")
                .pattern("# #")
                .pattern("# #"));

        createWoodSetRecipe(consumer, "pillar_trim", 4, r -> r
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # "));

        createWoodSetRecipe(consumer, "corner_trim", 4, r -> r
                .pattern("###")
                .pattern("  #")
                .pattern("  #"));

        createTrim(consumer, "pillar_trim", 4, r -> r
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # "));

        createTrim(consumer, "corner_trim", 4, r -> r
                .pattern("###")
                .pattern("  #")
                .pattern("  #"));

        createSimpleShapeless(consumer, ModItems.BERRY_JAM_JAR.get(), 1, r -> r
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .requires(Items.SWEET_BERRIES)
                .requires(Items.GLASS_BOTTLE));

        createSimpleShapeless(consumer, ModItems.WHITE_CUP.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_CUP.get())
                .requires(Items.WHITE_DYE));

        createSimpleShapeless(consumer, ModItems.YELLOW_CUP.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_CUP.get())
                .requires(Items.YELLOW_DYE));

        createSimpleShapeless(consumer, ModItems.BLUE_CUP.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_CUP.get())
                .requires(Items.BLUE_DYE));

        createSimple(consumer, ModItems.WOOD_CUP.get(), 3, r -> r
                .unlockedBy("has_board", has(ModTags.BOARDS))
                .define('#', ModTags.BOARDS)
                .pattern("   ")
                .pattern(" # ")
                .pattern(" # "));

        createSimple(consumer, ModItems.TERRACOTTA_CUP.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("   ")
                .pattern(" # ")
                .pattern(" # "));

        createSimpleShapeless(consumer, ModItems.WHITE_PLATE.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_PLATE.get())
                .requires(Items.WHITE_DYE));

        createSimpleShapeless(consumer, ModItems.YELLOW_PLATE.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_PLATE.get())
                .requires(Items.YELLOW_DYE));

        createSimpleShapeless(consumer, ModItems.BLUE_PLATE.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_PLATE.get())
                .requires(Items.BLUE_DYE));

        createSimple(consumer, ModItems.WOOD_PLATE.get(), 3, r -> r
                .unlockedBy("has_board", has(ModTags.BOARDS))
                .define('#', ModTags.BOARDS)
                .pattern("   ")
                .pattern("###")
                .pattern("   "));

        createSimple(consumer, ModItems.TERRACOTTA_PLATE.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("   ")
                .pattern("###")
                .pattern("   "));

        createSimpleShapeless(consumer, ModItems.WHITE_BOWL.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_BOWL.get())
                .requires(Items.WHITE_DYE));

        createSimpleShapeless(consumer, ModItems.YELLOW_BOWL.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_BOWL.get())
                .requires(Items.YELLOW_DYE));

        createSimpleShapeless(consumer, ModItems.BLUE_BOWL.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_BOWL.get())
                .requires(Items.BLUE_DYE));

        createSimple(consumer, ModItems.WOOD_BOWL.get(), 3, r -> r
                .unlockedBy("has_board", has(ModTags.BOARDS))
                .define('#', ModTags.BOARDS)
                .pattern("# #")
                .pattern(" # ")
                .pattern("   "));

        createSimple(consumer, ModItems.TERRACOTTA_BOWL.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("# #")
                .pattern(" # ")
                .pattern("   "));

        createSimpleShapeless(consumer, ModItems.WHITE_CROCKERY_COMBO.get(), 1, r -> r
                .unlockedBy("has_terracotta=_plate", has(ModItems.TERRACOTTA_PLATE.get()))
                .unlockedBy("has_terracotta_bowl", has(ModItems.TERRACOTTA_BOWL.get()))
                .requires(ModItems.WHITE_CUP.get())
                .requires(ModItems.WHITE_PLATE.get()));

        createSimpleShapeless(consumer, ModItems.YELLOW_CROCKERY_COMBO.get(), 1, r -> r
                .unlockedBy("has_terracotta=_plate", has(ModItems.TERRACOTTA_PLATE.get()))
                .unlockedBy("has_terracotta_bowl", has(ModItems.TERRACOTTA_BOWL.get()))
                .requires(ModItems.YELLOW_CUP.get())
                .requires(ModItems.YELLOW_PLATE.get()));

        createSimpleShapeless(consumer, ModItems.BLUE_CROCKERY_COMBO.get(), 1, r -> r
                .unlockedBy("has_terracotta=_plate", has(ModItems.TERRACOTTA_PLATE.get()))
                .unlockedBy("has_terracotta_bowl", has(ModItems.TERRACOTTA_BOWL.get()))
                .requires(ModItems.BLUE_CUP.get())
                .requires(ModItems.BLUE_PLATE.get()));

        createSimpleShapeless(consumer, ModItems.WOOD_CROCKERY_COMBO.get(), 1, r -> r
                .unlockedBy("has_terracotta=_plate", has(ModItems.TERRACOTTA_PLATE.get()))
                .unlockedBy("has_terracotta_bowl", has(ModItems.TERRACOTTA_BOWL.get()))
                .requires(ModItems.WOOD_CUP.get())
                .requires(ModItems.WOOD_PLATE.get()));

        createSimpleShapeless(consumer, ModItems.TERRACOTTA_CROCKERY_COMBO.get(), 1, r -> r
                .unlockedBy("has_terracotta=_plate", has(ModItems.TERRACOTTA_PLATE.get()))
                .unlockedBy("has_terracotta_bowl", has(ModItems.TERRACOTTA_BOWL.get()))
                .requires(ModItems.TERRACOTTA_CUP.get())
                .requires(ModItems.TERRACOTTA_PLATE.get()));

        createSimple(consumer, ModItems.TERRACOTTA_THIN_POT.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("## ")
                .pattern("## ")
                .pattern("   "));

        createSimple(consumer, ModItems.TERRACOTTA_MEDIUM_POT.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.TERRACOTTA_WIDE_POT.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # "));

        createSimple(consumer, ModItems.TERRACOTTA_THICK_POT.get(), 3, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern("# #")
                .pattern("# #")
                .pattern("###"));

        createSimpleShapeless(consumer, ModItems.WHITE_GLAZED_THIN_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_THIN_POT.get())
                .requires(Items.WHITE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.WHITE_GLAZED_MEDIUM_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_MEDIUM_POT.get())
                .requires(Items.WHITE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.WHITE_GLAZED_WIDE_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_WIDE_POT.get())
                .requires(Items.WHITE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.WHITE_GLAZED_THICK_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_THICK_POT.get())
                .requires(Items.WHITE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.BLUE_GLAZED_THIN_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_THIN_POT.get())
                .requires(Items.BLUE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.BLUE_GLAZED_MEDIUM_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_MEDIUM_POT.get())
                .requires(Items.BLUE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.BLUE_GLAZED_WIDE_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_WIDE_POT.get())
                .requires(Items.BLUE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.BLUE_GLAZED_THICK_POT.get(), 1, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .requires(ModItems.TERRACOTTA_THICK_POT.get())
                .requires(Items.BLUE_GLAZED_TERRACOTTA));

        createSimpleShapeless(consumer, ModItems.GOLDEN_THIN_POT.get(), 1, r -> r
                .unlockedBy("has_gold_block", has(Items.GOLD_BLOCK))
                .requires(ModItems.TERRACOTTA_THIN_POT.get())
                .requires(Items.GOLD_BLOCK));

        createSimpleShapeless(consumer, ModItems.GOLDEN_MEDIUM_POT.get(), 1, r -> r
                .unlockedBy("has_gold_block", has(Items.GOLD_BLOCK))
                .requires(ModItems.TERRACOTTA_MEDIUM_POT.get())
                .requires(Items.GOLD_BLOCK));

        createSimpleShapeless(consumer, ModItems.GOLDEN_WIDE_POT.get(), 1, r -> r
                .unlockedBy("has_gold_block", has(Items.GOLD_BLOCK))
                .requires(ModItems.TERRACOTTA_WIDE_POT.get())
                .requires(Items.GOLD_BLOCK));

        createSimpleShapeless(consumer, ModItems.GOLDEN_THICK_POT.get(), 1, r -> r
                .unlockedBy("has_gold_block", has(Items.GOLD_BLOCK))
                .requires(ModItems.TERRACOTTA_THICK_POT.get())
                .requires(Items.GOLD_BLOCK));

        createWallTrophy(consumer, ModItems.BEAR_TROPHY.get(), 1, Items.COD);
        createWallTrophy(consumer, ModItems.BLAZE_TROPHY.get(), 1, Items.BLAZE_ROD);
        createWallTrophy(consumer, ModItems.FOX_TROPHY.get(), 1, Items.SWEET_BERRIES);
        createWallTrophy(consumer, ModItems.GOAT_TROPHY.get(), 1, Items.GOAT_HORN);
        createWallTrophy(consumer, ModItems.PUFFERFISH_TROPHY.get(), 1, Items.PUFFERFISH);
        createWallTrophy(consumer, ModItems.SALMON_TROPHY.get(), 1, Items.SALMON);
        createWallTrophy(consumer, ModItems.SILVERFISH_TROPHY.get(), 1, Items.CHISELED_STONE_BRICKS);
        createWallTrophy(consumer, ModItems.SKELETON_HORSE_TROPHY.get(), 1, Items.SADDLE);
        createWallTrophy(consumer, ModItems.SPIDER_TROPHY.get(), 1, Items.SPIDER_EYE);
        createWallTrophy(consumer, ModItems.TROPICAL_FISH_TROPHY.get(), 1, Items.TROPICAL_FISH);
        createWallTrophy(consumer, ModItems.WITHER_SKELETON_TROPHY.get(), 1, Items.WITHER_SKELETON_SKULL);
        createWallTrophy(consumer, ModItems.WOLF_TROPHY.get(), 1, Items.BONE);

        createSimple(consumer, ModItems.PHANTOM_TROPHY.get(), 1, r -> r
                .unlockedBy("has_phantom_membrane", has(Items.PHANTOM_MEMBRANE))
                .define('#', Items.PHANTOM_MEMBRANE)
                .define('/', ModTags.BOARDS)
                .define('@', Items.CHAIN)
                .pattern("@@@")
                .pattern("/#/")
                .pattern("   "));

        createStatueTrophy(consumer, ModItems.CREEPER_TROPHY.get(), 1, Items.CREEPER_HEAD);
        createStatueTrophy(consumer, ModItems.SKELETON_TROPHY.get(), 1, Items.SKELETON_SKULL);
        createStatueTrophy(consumer, ModItems.EVOKER_TROPHY.get(), 1, Items.TOTEM_OF_UNDYING);
        createStatueTrophy(consumer, ModItems.PILLAGER_TROPHY.get(), 1, Items.CROSSBOW);
        createStatueTrophy(consumer, ModItems.VINDICATOR_TROPHY.get(), 1, Items.IRON_AXE);
        createStatueTrophy(consumer, ModItems.WITCH_TROPHY.get(), 1, Items.GLASS_BOTTLE);

    }

    public static void createSimple(Consumer<FinishedRecipe> consumer, Item output, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(output)).getPath();
        func.apply(ShapedRecipeBuilder.shaped(output, count))
                .group(name)
                .save(consumer);
    }

    public static void createSimpleShapeless(Consumer<FinishedRecipe> consumer, Item output, int count, Function<ShapelessRecipeBuilder, ShapelessRecipeBuilder> func) {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(output)).getPath();
        func.apply(ShapelessRecipeBuilder.shapeless(output, count))
                .group(name)
                .save(consumer);
    }

    public static void createWoodSetRecipe(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{ModItems.ACACIA_BOARD.get(), ModItems.BIRCH_BOARD.get(), ModItems.DARK_OAK_BOARD.get(), ModItems.JUNGLE_BOARD.get(), ModItems.MANGROVE_BOARD.get(), ModItems.OAK_BOARD.get(), ModItems.SPRUCE_BOARD.get(), ModItems.CRIMSON_BOARD.get(), ModItems.WARPED_BOARD.get()}) {
            String woodName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_board", "");
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, woodName + "_" + suffix));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }

    public static void createWoodSetRecipeWithPlanks(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{ModItems.ACACIA_BOARD.get(), ModItems.BIRCH_BOARD.get(), ModItems.DARK_OAK_BOARD.get(), ModItems.JUNGLE_BOARD.get(), ModItems.MANGROVE_BOARD.get(), ModItems.OAK_BOARD.get(), ModItems.SPRUCE_BOARD.get(), ModItems.CRIMSON_BOARD.get(), ModItems.WARPED_BOARD.get()}) {
            String woodName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_board", "");
            Item planks = ForgeRegistries.ITEMS.getValue(new ResourceLocation(woodName + "_planks"));
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, woodName + "_" + suffix));

            assert output != null;
            assert planks != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .define('/', planks)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }

    public static void createColouredSetRecipe(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{Items.BLACK_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL, Items.CYAN_WOOL, Items.GRAY_WOOL, Items.GREEN_WOOL, Items.LIGHT_BLUE_WOOL, Items.LIGHT_GRAY_WOOL, Items.LIME_WOOL, Items.MAGENTA_WOOL, Items.ORANGE_WOOL, Items.PINK_WOOL, Items.PURPLE_WOOL, Items.RED_WOOL, Items.WHITE_WOOL, Items.YELLOW_WOOL}) {
            String woolName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_wool", "");
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, woolName + "_" + suffix));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }

    public static void createTrim(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{Items.ANDESITE, Items.BLACKSTONE, Items.BRICKS, Items.CALCITE, Items.DEEPSLATE, Items.DIORITE, Items.DRIPSTONE_BLOCK, Items.GRANITE, Items.QUARTZ_BLOCK, Items.STONE}) {
            String trimName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_block", "");
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, trimName + "_" + suffix));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }

    public static void createWallTrophy(Consumer<FinishedRecipe> consumer, Item output, int count, Item input) {
        ShapedRecipeBuilder.shaped(output, count)
                .define('#', ModTags.BOARDS)
                .define('/', input)
                .group("trophy")
                .unlockedBy("has_trophy", has(ModTags.BOARDS))
                .pattern("###")
                .pattern("#/#")
                .pattern("###")
                .save(consumer);

    }

    public static void createStatueTrophy(Consumer<FinishedRecipe> consumer, Item output, int count, Item input) {
        ShapedRecipeBuilder.shaped(output, count)
                .define('#', Items.STONE)
                .define('/', input)
                .group("trophy")
                .unlockedBy("has_trophy", has(Items.STONE))
                .pattern(" # ")
                .pattern("#/#")
                .pattern("# #")
                .save(consumer);

    }
}
