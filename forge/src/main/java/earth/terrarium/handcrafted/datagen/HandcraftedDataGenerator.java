package earth.terrarium.handcrafted.datagen;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.datagen.provider.client.ModLangProvider;
import earth.terrarium.handcrafted.datagen.provider.server.ModLootTableProvider;
import earth.terrarium.handcrafted.datagen.provider.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Handcrafted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class HandcraftedDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Starting Handcrafted Datagen...");
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Client
        generator.addProvider(event.includeClient(), new ModLangProvider(generator));

        // Server
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
    }
}
