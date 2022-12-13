package earth.terrarium.handcrafted.forge;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import earth.terrarium.handcrafted.common.registry.forge.ModRegistryHelpersImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Handcrafted.MOD_ID)
public class HandcraftedForge {
    public HandcraftedForge() {
        Handcrafted.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(HandcraftedForge::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> HandcraftedClientForge::init);
        bus.addListener(HandcraftedForge::onClientSetup);
        ModRegistryHelpersImpl.REGISTRIES.values().forEach(deferredRegister -> deferredRegister.register(bus));
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        Handcrafted.postInit();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        HandcraftedClient.initializeClient();
        HandcraftedClientForge.postInit();
    }
}