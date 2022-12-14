package earth.terrarium.handcrafted.datagen;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.datagen.provider.ModLootTableProvider;
import earth.terrarium.handcrafted.datagen.provider.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Handcrafted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class HandcraftedDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Starting Handcrafted Datagen...");
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
        System.out.println("Finished Handcrafted Datagen");
    }
}
