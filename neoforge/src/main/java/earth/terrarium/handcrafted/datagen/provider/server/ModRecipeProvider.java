package earth.terrarium.handcrafted.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings({"deprecation", "SameParameterValue"})
public class ModRecipeProvider extends RecipeProvider {
    private RecipeOutput output;

    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        this.output = output;

        coloredSet(ModItems.CUSHIONS, 16, r -> r
            .define('/', Items.FEATHER)
            .pattern("###")
            .pattern("///")
            .pattern("###"));

        sheets(ModItems.SHEETS, 8);

        colorReplace(ModItems.BLACK_CUSHION, ModItemTags.CUSHIONS, () -> Items.BLACK_DYE);
        colorReplace(ModItems.BLUE_CUSHION, ModItemTags.CUSHIONS, () -> Items.BLUE_DYE);
        colorReplace(ModItems.BROWN_CUSHION, ModItemTags.CUSHIONS, () -> Items.BROWN_DYE);
        colorReplace(ModItems.CYAN_CUSHION, ModItemTags.CUSHIONS, () -> Items.CYAN_DYE);
        colorReplace(ModItems.GRAY_CUSHION, ModItemTags.CUSHIONS, () -> Items.GRAY_DYE);
        colorReplace(ModItems.GREEN_CUSHION, ModItemTags.CUSHIONS, () -> Items.GREEN_DYE);
        colorReplace(ModItems.LIGHT_BLUE_CUSHION, ModItemTags.CUSHIONS, () -> Items.LIGHT_BLUE_DYE);
        colorReplace(ModItems.LIGHT_GRAY_CUSHION, ModItemTags.CUSHIONS, () -> Items.LIGHT_GRAY_DYE);
        colorReplace(ModItems.LIME_CUSHION, ModItemTags.CUSHIONS, () -> Items.LIME_DYE);
        colorReplace(ModItems.MAGENTA_CUSHION, ModItemTags.CUSHIONS, () -> Items.MAGENTA_DYE);
        colorReplace(ModItems.ORANGE_CUSHION, ModItemTags.CUSHIONS, () -> Items.ORANGE_DYE);
        colorReplace(ModItems.PINK_CUSHION, ModItemTags.CUSHIONS, () -> Items.PINK_DYE);
        colorReplace(ModItems.PURPLE_CUSHION, ModItemTags.CUSHIONS, () -> Items.PURPLE_DYE);
        colorReplace(ModItems.RED_CUSHION, ModItemTags.CUSHIONS, () -> Items.RED_DYE);
        colorReplace(ModItems.WHITE_CUSHION, ModItemTags.CUSHIONS, () -> Items.WHITE_DYE);
        colorReplace(ModItems.YELLOW_CUSHION, ModItemTags.CUSHIONS, () -> Items.YELLOW_DYE);

        colorReplace(ModItems.BLACK_SHEET, ModItemTags.SHEETS, () -> Items.BLACK_DYE);
        colorReplace(ModItems.BLUE_SHEET, ModItemTags.SHEETS, () -> Items.BLUE_DYE);
        colorReplace(ModItems.BROWN_SHEET, ModItemTags.SHEETS, () -> Items.BROWN_DYE);
        colorReplace(ModItems.CYAN_SHEET, ModItemTags.SHEETS, () -> Items.CYAN_DYE);
        colorReplace(ModItems.GRAY_SHEET, ModItemTags.SHEETS, () -> Items.GRAY_DYE);
        colorReplace(ModItems.GREEN_SHEET, ModItemTags.SHEETS, () -> Items.GREEN_DYE);
        colorReplace(ModItems.LIGHT_BLUE_SHEET, ModItemTags.SHEETS, () -> Items.LIGHT_BLUE_DYE);
        colorReplace(ModItems.LIGHT_GRAY_SHEET, ModItemTags.SHEETS, () -> Items.LIGHT_GRAY_DYE);
        colorReplace(ModItems.LIME_SHEET, ModItemTags.SHEETS, () -> Items.LIME_DYE);
        colorReplace(ModItems.MAGENTA_SHEET, ModItemTags.SHEETS, () -> Items.MAGENTA_DYE);
        colorReplace(ModItems.ORANGE_SHEET, ModItemTags.SHEETS, () -> Items.ORANGE_DYE);
        colorReplace(ModItems.PINK_SHEET, ModItemTags.SHEETS, () -> Items.PINK_DYE);
        colorReplace(ModItems.PURPLE_SHEET, ModItemTags.SHEETS, () -> Items.PURPLE_DYE);
        colorReplace(ModItems.RED_SHEET, ModItemTags.SHEETS, () -> Items.RED_DYE);
        colorReplace(ModItems.WHITE_SHEET, ModItemTags.SHEETS, () -> Items.WHITE_DYE);
        colorReplace(ModItems.YELLOW_SHEET, ModItemTags.SHEETS, () -> Items.YELLOW_DYE);

        shaped(ModItems.BENCH, 1, () -> Items.IRON_INGOT, r -> r
            .define('/', Items.IRON_BARS)
            .pattern("/#/")
            .pattern("/#/")
            .pattern("/ /"));

        shapeless(ModItems.FROZEN_BENCH, 1, ModItems.BENCH, r -> r
            .requires(Items.SNOWBALL));

        woodWithSlabSet(ModItems.WOODEN_BENCHES, 2, r -> r
            .pattern("###")
            .pattern("---")
            .pattern("# #"));

        woodSet(ModItems.COUCHES, 2, r -> r
            .define('/', ModItemTags.CUSHIONS)
            .define('@', ItemTags.WOOL)
            .pattern("@/@")
            .pattern("###"));

        woodWithSlabSet(ModItems.CHAIRS, 2, r -> r
            .define('/', Items.STICK)
            .pattern("- ")
            .pattern("##")
            .pattern("//"));

        woodWithSlabSet(ModItems.DINING_BENCHES, 2, r -> r
            .pattern("---")
            .pattern("# #"));

        woodWithSlabSet(ModItems.SIDE_TABLES, 2, r -> r
            .define('/', Items.CHEST)
            .pattern("---")
            .pattern("#/#")
            .pattern("# #"));

        woodWithSlabSet(ModItems.DESKS, 2, r -> r
            .define('/', Items.CHEST)
            .pattern("---")
            .pattern("#/#"));

        woodSet(ModItems.NIGHTSTANDS, 2, r -> r
            .define('/', Items.CHEST)
            .pattern("###")
            .pattern("#/#"));

        woodSet(ModItems.TABLES, 2, r -> r
            .define('/', Items.STICK)
            .pattern("###")
            .pattern("/ /"));

        woodSet(ModItems.FANCY_BEDS, 1, r -> r
            .define('/', ModItemTags.CUSHIONS)
            .define('@', ModItemTags.SHEETS)
            .define('$', ItemTags.WOOL)
            .pattern(" /@")
            .pattern("#$$")
            .pattern("###"));

        woodSet(ModItems.COUNTERS, 3, r -> r
            .define('/', Items.CHEST)
            .define('@', Items.CALCITE)
            .pattern("@@@")
            .pattern("#/#"));

        woodSet(ModItems.CUPBOARDS, 3, r -> r
            .define('/', Items.CHEST)
            .pattern("###")
            .pattern("#/#")
            .pattern("###"));

        woodWithSlabSet(ModItems.DRAWERS, 2, r -> r
            .define('/', Items.CHEST)
            .pattern("#/#")
            .pattern("---")
            .pattern("---"));

        woodWithSlabSet(ModItems.SHELVES, 2, r -> r
            .define('/', Items.CHEST)
            .pattern("---")
            .pattern("#/#")
            .pattern("---"));

        trim(ModItems.PILLAR_TRIMS, 4, r -> r
            .pattern("#")
            .pattern("#")
            .pattern("#"));

        trim(ModItems.CORNER_TRIMS, 4, r -> r
            .pattern("#  ")
            .pattern("#  ")
            .pattern("###"));

        shaped(ModItems.HAMMER, 1, () -> Items.IRON_INGOT, r -> r
            .define('/', Items.STICK)
            .pattern(" # ")
            .pattern(" /#")
            .pattern("/  "));

        shapeless(ModItems.BERRY_JAM_JAR, 1, () -> Items.SWEET_BERRIES, r -> r
            .requires(Items.GLASS_BOTTLE));

        shapeless(ModItems.STACKABLE_BOOK, 4, () -> Items.BOOK, r -> r
            .requires(Items.BOOK, 3));

        shapeless(ModItems.FANCY_PAINTING, 1, () -> Items.PAINTING, r -> r
            .requires(Items.GOLD_INGOT));

        shaped(ModItems.PHANTOM_TROPHY, 1, () -> Items.PHANTOM_MEMBRANE, r -> r
            .define('/', ItemTags.PLANKS)
            .define('@', Items.CHAIN)
            .pattern("@@@")
            .pattern("/#/"));

        wallTrophy(ModItems.BEAR_TROPHY, () -> Items.COD);
        wallTrophy(ModItems.BLAZE_TROPHY, () -> Items.BLAZE_ROD);
        wallTrophy(ModItems.FOX_TROPHY, () -> Items.SWEET_BERRIES);
        wallTrophy(ModItems.GOAT_TROPHY, () -> Items.GOAT_HORN);
        wallTrophy(ModItems.PUFFERFISH_TROPHY, () -> Items.PUFFERFISH);
        wallTrophy(ModItems.SALMON_TROPHY, () -> Items.SALMON);
        wallTrophy(ModItems.SILVERFISH_TROPHY, () -> Items.CHISELED_STONE_BRICKS);
        wallTrophy(ModItems.SKELETON_HORSE_TROPHY, () -> Items.SADDLE);
        wallTrophy(ModItems.SPIDER_TROPHY, () -> Items.SPIDER_EYE);
        wallTrophy(ModItems.TROPICAL_FISH_TROPHY, () -> Items.TROPICAL_FISH);
        wallTrophy(ModItems.WITHER_SKELETON_TROPHY, () -> Items.WITHER_SKELETON_SKULL);
        wallTrophy(ModItems.WOLF_TROPHY, () -> Items.BONE);

        statueTrophy(ModItems.CREEPER_TROPHY, () -> Items.CREEPER_HEAD);
        statueTrophy(ModItems.SKELETON_TROPHY, () -> Items.SKELETON_SKULL);
        statueTrophy(ModItems.EVOKER_TROPHY, () -> Items.TOTEM_OF_UNDYING);
        statueTrophy(ModItems.PILLAGER_TROPHY, () -> Items.CROSSBOW);
        statueTrophy(ModItems.VINDICATOR_TROPHY, () -> Items.IRON_AXE);
        statueTrophy(ModItems.WITCH_TROPHY, () -> Items.GLASS_BOTTLE);

        shaped(ModItems.TERRACOTTA_THIN_POT, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("##")
            .pattern("##"));

        shaped(ModItems.TERRACOTTA_MEDIUM_POT, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("##")
            .pattern("##")
            .pattern("##"));

        shaped(ModItems.TERRACOTTA_WIDE_POT, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("# #")
            .pattern("# #")
            .pattern(" # "));

        shaped(ModItems.TERRACOTTA_THICK_POT, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("# #")
            .pattern("# #")
            .pattern("###"));

        pot(ModItems.WHITE_GLAZED_THIN_POT, ModItems.WHITE_GLAZED_MEDIUM_POT,
            ModItems.WHITE_GLAZED_WIDE_POT, ModItems.WHITE_GLAZED_THICK_POT,
            () -> Items.WHITE_GLAZED_TERRACOTTA);

        pot(ModItems.BLUE_GLAZED_THIN_POT, ModItems.BLUE_GLAZED_MEDIUM_POT,
            ModItems.BLUE_GLAZED_WIDE_POT, ModItems.BLUE_GLAZED_THICK_POT,
            () -> Items.BLUE_GLAZED_TERRACOTTA);

        pot(ModItems.GOLDEN_THIN_POT, ModItems.GOLDEN_MEDIUM_POT,
            ModItems.GOLDEN_WIDE_POT, ModItems.GOLDEN_THICK_POT,
            () -> Items.GOLD_BLOCK);

        shaped(ModItems.WOOD_CUP, 3, ItemTags.WOODEN_SLABS, r -> r
            .pattern("# #")
            .pattern(" # "));

        shaped(ModItems.WOOD_BOWL, 3, ItemTags.WOODEN_SLABS, r -> r
            .define('/', ItemTags.PLANKS)
            .pattern("# #")
            .pattern(" / "));

        shaped(ModItems.WOOD_PLATE, 3, ItemTags.WOODEN_SLABS, r -> r
            .pattern("###"));

        shapeless(ModItems.WOOD_CROCKERY_COMBO, 1, ModItems.WOOD_CUP, r -> r
            .requires(ModItems.WOOD_PLATE.get()));

        shaped(ModItems.TERRACOTTA_CUP, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("#")
            .pattern("#"));

        shaped(ModItems.TERRACOTTA_BOWL, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("# #")
            .pattern(" # "));

        shaped(ModItems.TERRACOTTA_PLATE, 3, () -> Items.TERRACOTTA, r -> r
            .pattern("###"));

        shapeless(ModItems.TERRACOTTA_CROCKERY_COMBO, 1, ModItems.TERRACOTTA_CUP, r -> r
            .requires(ModItems.TERRACOTTA_PLATE.get()));

        crockery(ModItems.WHITE_CUP, ModItems.WHITE_BOWL,
            ModItems.WHITE_PLATE, ModItems.WHITE_CROCKERY_COMBO,
            () -> Items.WHITE_DYE);

        crockery(ModItems.BLUE_CUP, ModItems.BLUE_BOWL,
            ModItems.BLUE_PLATE, ModItems.BLUE_CROCKERY_COMBO,
            () -> Items.BLUE_DYE);

        crockery(ModItems.YELLOW_CUP, ModItems.YELLOW_BOWL,
            ModItems.YELLOW_PLATE, ModItems.YELLOW_CROCKERY_COMBO,
            () -> Items.YELLOW_DYE);

        shaped(ModItems.OVEN, 1, () -> Items.BRICK, r -> r
            .define('/', Items.IRON_BARS)
            .define('@', Items.SMOKER)
            .pattern("#/#")
            .pattern("#@#")
            .pattern("###"));

        shaped(ModItems.KITCHEN_HOOD, 1, () -> Items.IRON_BARS, r -> r
            .define('/', ModItems.KITCHEN_HOOD_PIPE.get())
            .pattern(" / ")
            .pattern("###")
            .pattern("   "));

        shaped(ModItems.KITCHEN_HOOD_PIPE, 1, () -> Items.IRON_BARS, r -> r
            .pattern("# #")
            .pattern("# #")
            .pattern("# #"));
    }

    private void shaped(RegistryEntry<Item> result, int count, Supplier<Item> mainItem, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                .define('#', mainItem.get())
                .unlockedBy("has_" + result.getId().getPath(), has(mainItem.get())))
            .save(output);
    }

    private void shaped(RegistryEntry<Item> result, int count, TagKey<Item> mainItem, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                .define('#', mainItem)
                .unlockedBy("has_" + result.getId().getPath(), has(mainItem)))
            .save(output);
    }

    private void shapeless(RegistryEntry<Item> result, int count, Supplier<Item> mainItem, Function<ShapelessRecipeBuilder, ShapelessRecipeBuilder> builder) {
        builder.apply(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), count)
                .requires(mainItem.get())
                .unlockedBy("has_" + result.getId().getPath(), has(mainItem.get())))
            .save(output);
    }

    private void woodSet(ResourcefulRegistry<Item> registry, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        registry.stream().forEach(result -> {
            Item wood = getPlanks(result);
            builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                    .define('#', wood)
                    .unlockedBy("has_" + result.getId().getPath(), has(wood)))
                .save(output);
        });
    }

    private void woodWithSlabSet(ResourcefulRegistry<Item> registry, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        registry.stream().forEach(result -> {
            Item wood = getPlanks(result);
            Item slab = getSlab(result);
            builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                    .define('#', wood)
                    .define('-', slab)
                    .unlockedBy("has_" + result.getId().getPath(), has(wood)))
                .save(output);
        });
    }

    private void coloredSet(ResourcefulRegistry<Item> registry, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        registry.stream().forEach(result -> {
            Item wool = getWool(result);
            builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                    .define('#', wool)
                    .unlockedBy("has_" + result.getId().getPath(), has(wool)))
                .save(output);
        });
    }

    private void sheets(ResourcefulRegistry<Item> registry, int count) {
        registry.stream().forEach(result -> {
            Item wool = getWool(result);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), count)
                .requires(wool)
                .requires(wool)
                .requires(wool)
                .unlockedBy("has_" + result.getId().getPath(), has(wool))
                .save(output);
        });
    }

    private void trim(ResourcefulRegistry<Item> registry, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        registry.stream().forEach(result -> {
            Item material = ModItemTagProvider.TRIM_MATERIALS.stream().filter(i ->
                Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(i)).getPath().split("_")[0]
                    .equals(result.getId().getPath().split("_")[0])).findFirst().orElseThrow();
            builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                    .define('#', material)
                    .unlockedBy("has_" + result.getId().getPath(), has(material)))
                .save(output);
        });
    }


    private void wallTrophy(RegistryEntry<Item> result, Supplier<Item> catalyst) {
        shaped(result, 1, ItemTags.PLANKS, r -> r
            .define('/', catalyst.get())
            .pattern("###")
            .pattern("#/#")
            .pattern("###"));
    }

    private void statueTrophy(RegistryEntry<Item> result, Supplier<Item> catalyst) {
        shaped(result, 1, () -> Items.STONE, r -> r
            .define('/', catalyst.get())
            .pattern(" # ")
            .pattern("#/#")
            .pattern("# #"));
    }

    private void pot(
        RegistryEntry<Item> thin, RegistryEntry<Item> medium,
        RegistryEntry<Item> wide, RegistryEntry<Item> thick,
        Supplier<Item> catalyst) {
        pot(thin, catalyst, ModItems.TERRACOTTA_THIN_POT);
        pot(medium, catalyst, ModItems.TERRACOTTA_MEDIUM_POT);
        pot(wide, catalyst, ModItems.TERRACOTTA_WIDE_POT);
        pot(thick, catalyst, ModItems.TERRACOTTA_THICK_POT);
    }

    private void pot(RegistryEntry<Item> result, Supplier<Item> catalyst, Supplier<Item> terracottaPot) {
        shapeless(result, 1, catalyst, r -> r
            .requires(terracottaPot.get()));
    }

    private void crockery(
        RegistryEntry<Item> cup, RegistryEntry<Item> bowl,
        RegistryEntry<Item> plate, RegistryEntry<Item> combo,
        Supplier<Item> catalyst) {
        crockery(cup, catalyst, ModItems.TERRACOTTA_CUP);
        crockery(bowl, catalyst, ModItems.TERRACOTTA_BOWL);
        crockery(plate, catalyst, ModItems.TERRACOTTA_PLATE);
        crockery(combo, catalyst, ModItems.TERRACOTTA_CROCKERY_COMBO);
    }

    private void crockery(RegistryEntry<Item> result, Supplier<Item> catalyst, Supplier<Item> terracottaPot) {
        shapeless(result, 1, catalyst, r -> r
            .requires(terracottaPot.get()));
    }

    private void colorReplace(RegistryEntry<Item> result, TagKey<Item> mainItem, Supplier<Item> otherItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), 1)
            .requires(mainItem)
            .requires(otherItem.get())
            .unlockedBy("has_" + result.getId().getPath(), has(mainItem))
            .save(output, BuiltInRegistries.ITEM.getKey(result.get()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(otherItem.get()).getPath());
    }

    private Item getPlanks(RegistryEntry<Item> result) {
        if (result.getId().getPath().contains("dark_oak")) {
            return Items.DARK_OAK_PLANKS;
        }
        return BuiltInRegistries.ITEM.get(new ResourceLocation(result.getId().getPath().split("_")[0] + "_planks"));
    }

    private Item getSlab(RegistryEntry<Item> result) {
        if (result.getId().getPath().contains("dark_oak")) {
            return Items.DARK_OAK_SLAB;
        }
        return BuiltInRegistries.ITEM.get(new ResourceLocation(result.getId().getPath().split("_")[0] + "_slab"));
    }

    private Item getWool(RegistryEntry<Item> result) {
        if (result.getId().getPath().contains("light_blue")) {
            return Items.LIGHT_BLUE_WOOL;
        }
        if (result.getId().getPath().contains("light_gray")) {
            return Items.LIGHT_GRAY_WOOL;
        }
        return BuiltInRegistries.ITEM.get(new ResourceLocation(result.getId().getPath().split("_")[0] + "_wool"));
    }
}
