package earth.terrarium.handcrafted.forge;

import dev.architectury.platform.forge.EventBuses;
import earth.terrarium.handcrafted.Handcrafted;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Handcrafted.MOD_ID)
public class HandcraftedForge {
    public HandcraftedForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Handcrafted.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Handcrafted.init();
    }
}
