package earth.terrarium.handcrafted.datagen.provider.server;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModPaintingVariants;
import earth.terrarium.handcrafted.common.tags.ModPaintingVariantTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagsProvider<PaintingVariant> {

    public ModPaintingVariantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, Registries.PAINTING_VARIANT, completableFuture, Handcrafted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        ModPaintingVariants.PAINTING_VARIANTS.stream().forEach(p -> tag(ModPaintingVariantTags.PAINTINGS).add(TagEntry.element(p.getId())));
    }
}
