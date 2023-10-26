package earth.terrarium.handcrafted.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends TagsProvider<Item> {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, Registries.ITEM, completableFuture, Handcrafted.MOD_ID, existingFileHelper);
    }

    public static final List<Item> COUNTER_MATERIALS = List.of(
        Items.ACACIA_PLANKS,
        Items.ANDESITE,
        Items.BAMBOO_PLANKS,
        Items.BIRCH_PLANKS,
        Items.BLACKSTONE,
        Items.BRICKS,
        Items.CALCITE,
        Items.CHERRY_PLANKS,
        Items.CRIMSON_PLANKS,
        Items.DARK_OAK_PLANKS,
        Items.DEEPSLATE,
        Items.DIORITE,
        Items.DRIPSTONE_BLOCK,
        Items.GRANITE,
        Items.JUNGLE_PLANKS,
        Items.MANGROVE_PLANKS,
        Items.OAK_PLANKS,
        Items.QUARTZ_BLOCK,
        Items.SMOOTH_STONE,
        Items.SPRUCE_PLANKS,
        Items.WARPED_PLANKS);

    public static final List<Item> TRIM_MATERIALS = List.of(
        Items.ACACIA_PLANKS,
        Items.BAMBOO_PLANKS,
        Items.BIRCH_PLANKS,
        Items.CHERRY_PLANKS,
        Items.CRIMSON_PLANKS,
        Items.DARK_OAK_PLANKS,
        Items.JUNGLE_PLANKS,
        Items.MANGROVE_PLANKS,
        Items.OAK_PLANKS,
        Items.SPRUCE_PLANKS,
        Items.WARPED_PLANKS,
        Items.ANDESITE,
        Items.BLACKSTONE,
        Items.BRICKS,
        Items.CALCITE,
        Items.DEEPSLATE,
        Items.DIORITE,
        Items.DRIPSTONE_BLOCK,
        Items.GRANITE,
        Items.QUARTZ_BLOCK,
        Items.STONE,
        Items.SANDSTONE,
        Items.RED_SANDSTONE
    );

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        COUNTER_MATERIALS.forEach(b -> tag(ModItemTags.COUNTER_MATERIALS).add(TagEntry.element(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(b)))));
        TRIM_MATERIALS.forEach(b -> tag(ModItemTags.TRIM_MATERIALS).add(TagEntry.element(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(b)))));
        ModBlocks.FANCY_BEDS.stream().forEach(b -> tag(ItemTags.BEDS).add(TagEntry.element(b.getId())));

        addSet(ModItems.CUSHIONS, "cushions");
        addSet(ModItems.SHEETS, "sheets");
        addSet(ModItems.BENCHES, "benches");
        addSet(ModItems.WOODEN_BENCHES, "wooden_benches");
        addSet(ModItems.METAL_BENCHES, "metal_benches");
        addSet(ModItems.COUCHES, "couches");
        addSet(ModItems.CHAIRS, "chairs");
        addSet(ModItems.DINING_BENCHES, "dining_benches");
        addSet(ModItems.SIDE_TABLES, "side_tables");
        addSet(ModItems.DESKS, "desks");
        addSet(ModItems.NIGHTSTANDS, "nightstands");
        addSet(ModItems.TABLES, "tables");
        addSet(ModItems.FANCY_BEDS, "fancy_beds");
        addSet(ModItems.COUNTERS, "counters");
        addSet(ModItems.CUPBOARDS, "cupboards");
        addSet(ModItems.DRAWERS, "drawers");
        addSet(ModItems.SHELVES, "shelves");
        addSet(ModItems.POTS, "pots");
        addSet(ModItems.TRIMS, "trims");
        addSet(ModItems.PILLAR_TRIMS, "pillar_trims");
        addSet(ModItems.CORNER_TRIMS, "corner_trims");
        addSet(ModItems.TROPHIES, "trophies");
        addSet(ModItems.CROCKERY, "crockery");
        addSet(ModItems.CUPS, "cups");
        addSet(ModItems.PLATES, "plates");
        addSet(ModItems.BOWLS, "bowls");
        addSet(ModItems.CROCKERY_COMBOS, "crockery_combos");
    }

    private void addSet(ResourcefulRegistry<Item> registry, String name) {
        registry.stream().forEach(b -> tag(TagKey.create(Registries.ITEM, new ResourceLocation(Handcrafted.MOD_ID, name))).add(TagEntry.element(b.getId())));
    }
}
