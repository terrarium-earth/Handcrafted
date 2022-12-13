package earth.terrarium.handcrafted.client.forge;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;

public class ClientUtilsImpl {
    public static BakedModel getModel(ModelManager dispatcher, ResourceLocation id) {
        return dispatcher.getModel(id);
    }
}
