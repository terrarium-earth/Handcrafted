package earth.terrarium.handcrafted.fabric;

import earth.terrarium.handcrafted.Handcrafted;
import net.fabricmc.api.ModInitializer;

public class HandcraftedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Handcrafted.init();
    }
}
