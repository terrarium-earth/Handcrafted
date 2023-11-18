package earth.terrarium.handcrafted.datagen.provider.client;


import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Handcrafted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FANCY_PAINTING.get());
        basicItem(ModItems.STACKABLE_BOOK.get());
        ModItems.CUSHIONS.stream().map(RegistryEntry::get).forEach(i -> basicItem(i, "cushion"));
        ModItems.SHEETS.stream().map(RegistryEntry::get).forEach(i -> basicItem(i, "sheet"));
        ModItems.CROCKERY.stream().map(RegistryEntry::get).forEach(i -> basicItem(i, "crockery"));
    }

    public void basicItem(Item item, String folder) {
        ResourceLocation itemLocation = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));

        getBuilder(item.toString())
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", new ResourceLocation(itemLocation.getNamespace(), "item/" + folder + "/" + itemLocation.getPath()));
    }
}
