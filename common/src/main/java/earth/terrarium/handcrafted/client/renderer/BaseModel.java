package earth.terrarium.handcrafted.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;

public abstract class BaseModel extends Model {
    private final ModelPart main;

    public BaseModel(ModelPart root) {
        super(RenderType::entityCutout);
        main = root.getChild("main");
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, buffer, packedLight, packedOverlay);
    }

    public ModelPart getMain() {
        return this.main;
    }
}
