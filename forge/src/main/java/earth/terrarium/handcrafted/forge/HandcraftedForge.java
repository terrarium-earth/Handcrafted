package earth.terrarium.handcrafted.forge;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.forge.HandcraftedClientForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Handcrafted.MOD_ID)
public class HandcraftedForge {

    public HandcraftedForge() {
        Handcrafted.init();
        if (FMLEnvironment.dist.isClient()) {
            HandcraftedClientForge.init();
        }
    }
}
