package earth.terrarium.handcrafted.datagen.provider;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        createWoodSetRecip1e(consumer, "chair", 2, r -> r
                .pattern("#  ")
                .pattern("###")
                .pattern("# #"));

        createWoodSetRecip1e(consumer, "table", 2, r -> r
                .pattern("   ")
                .pattern("###")
                .pattern("# #"));
    }

    public static void createWoodSetRecip1e(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{ModItems.ACACIA_BOARD.get(), ModItems.BIRCH_BOARD.get(), ModItems.DARK_OAK_BOARD.get(), ModItems.JUNGLE_BOARD.get(), ModItems.MANGROVE_BOARD.get(), ModItems.OAK_BOARD.get(), ModItems.SPRUCE_BOARD.get(), ModItems.CRIMSON_BOARD.get(), ModItems.WARPED_BOARD.get()}) {
            String woodName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().split("_")[0];
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, woodName + "_" + "chair"));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }
}
