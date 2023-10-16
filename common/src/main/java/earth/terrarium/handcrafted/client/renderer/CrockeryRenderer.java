package earth.terrarium.handcrafted.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlockEntity;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryComboBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.item.ItemDisplayContext;

public class CrockeryRenderer implements BlockEntityRenderer<CrockeryBlockEntity> {

    @Override
    public void render(CrockeryBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (entity.getStack().isEmpty()) return;
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.25f / 16, 0.5);
            poseStack.mulPose(Axis.YN.rotationDegrees(entity.getBlockState().getValue(CrockeryComboBlock.FACING).getOpposite().toYRot()));
            poseStack.mulPose(Axis.XP.rotationDegrees(270));
            Minecraft.getInstance().getItemRenderer().renderStatic(entity.getStack(), ItemDisplayContext.GROUND, packedLight, packedOverlay, poseStack, bufferSource, Minecraft.getInstance().level, 0);
        }
    }
}
