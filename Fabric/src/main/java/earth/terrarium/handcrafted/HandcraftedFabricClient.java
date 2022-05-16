package earth.terrarium.handcrafted;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class HandcraftedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Handcrafted.SEAT_ENTITY.get(), HandcraftedClient.MountableEntityRenderer::new);
        HandcraftedClient.initialize();
    }
}
