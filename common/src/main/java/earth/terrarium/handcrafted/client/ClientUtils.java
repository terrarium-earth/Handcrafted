package earth.terrarium.handcrafted.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.NotImplementedException;

@Environment(EnvType.CLIENT)
public class ClientUtils {

    @ExpectPlatform
    public static BakedModel getModel(ModelManager dispatcher, ResourceLocation id) {
        throw new NotImplementedException();
    }
}
