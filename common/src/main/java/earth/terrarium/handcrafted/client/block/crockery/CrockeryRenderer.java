package earth.terrarium.handcrafted.client.block.crockery;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlockEntity;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryComboBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

@Environment(EnvType.CLIENT)
public class CrockeryRenderer implements BlockEntityRenderer<CrockeryBlockEntity> {
    public CrockeryRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(CrockeryBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (entity.getStack().isEmpty()) return;
        poseStack.pushPose();
        poseStack.translate(0.5, 1.25f / 16, 0.5);
        poseStack.mulPose(Axis.YN.rotationDegrees(entity.getBlockState().getValue(CrockeryComboBlock.FACING).getOpposite().toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(270));
        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getStack(), ItemTransforms.TransformType.GROUND, packedLight, packedOverlay, poseStack, bufferSource, 0);
        poseStack.popPose();
    }
}
