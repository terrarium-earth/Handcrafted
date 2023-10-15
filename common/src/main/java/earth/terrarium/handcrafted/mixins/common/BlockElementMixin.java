package earth.terrarium.handcrafted.mixins.common;

import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.renderer.block.model.BlockElement$Deserializer")
public abstract class BlockElementMixin {

    @Shadow
    protected abstract Vector3f getVector3f(JsonObject json, String memberName);

    // Remove rotation limit
    @Inject(method = "getAngle", at = @At("HEAD"), cancellable = true)
    private void handcrafted$onDeserializeRotationAngle(JsonObject json, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(GsonHelper.getAsFloat(json, "angle"));
    }

    // Remove size limit
    @Inject(method = "getTo", at = @At("HEAD"), cancellable = true)
    private void handcrafted$getTo(JsonObject json, CallbackInfoReturnable<Vector3f> cir) {
        cir.setReturnValue(getVector3f(json, "to"));
    }

    // Remove size limit
    @Inject(method = "getFrom", at = @At("HEAD"), cancellable = true)
    private void handcrafted$getFrom(JsonObject json, CallbackInfoReturnable<Vector3f> cir) {
        cir.setReturnValue(getVector3f(json, "from"));
    }
}
