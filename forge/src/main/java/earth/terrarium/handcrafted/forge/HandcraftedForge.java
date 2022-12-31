package earth.terrarium.handcrafted.forge;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
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
        bus.addListener(HandcraftedForge::onRegisterCreativeTabs);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        Handcrafted.postInit();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        HandcraftedClient.initializeClient();
        HandcraftedClientForge.postInit();
    }

    public static void onRegisterCreativeTabs(CreativeModeTabEvent.Register event) {
        ModItems.onRegisterCreativeTabs((loc, item, items) -> event.registerCreativeModeTab(loc, b -> b
                .title(Component.translatable("itemGroup." + loc.getNamespace() + "." + loc.getPath()))
                .icon(() -> item.get().getDefaultInstance())
                .displayItems((featureFlagSet, output, bl) -> items.forEach(output::accept))
                .build()));
    }
}