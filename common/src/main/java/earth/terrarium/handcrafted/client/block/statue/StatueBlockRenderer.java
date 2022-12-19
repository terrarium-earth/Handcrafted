package earth.terrarium.handcrafted.client.block.statue;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

@Environment(EnvType.CLIENT)
public class StatueBlockRenderer implements BlockEntityRenderer<StatueTrophyBlockEntity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public StatueBlockRenderer(BlockEntityRendererProvider.Context ctx) {
        blockRenderDispatcher = ctx.getBlockRenderDispatcher();
    }

    @Override
    public void render(StatueTrophyBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BakedModel blockModel = blockRenderDispatcher.getBlockModel(entity.getBlockState());
        poseStack.pushPose();
        if (entity.getBlockState().getValue(StatueTrophyBlock.HALF) == DoubleBlockHalf.UPPER) {
            poseStack.popPose();
            return;
        }
        blockRenderDispatcher.getModelRenderer().renderModel(poseStack.last(), bufferSource.getBuffer(Sheets.cutoutBlockSheet()), entity.getBlockState(), blockModel, 1f, 1f, 1f, packedLight, packedOverlay);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(StatueTrophyBlockEntity blockEntity) {
        return true;
    }

    @Override
    public boolean shouldRender(StatueTrophyBlockEntity blockEntity, Vec3 cameraPos) {
        return Vec3.atCenterOf(blockEntity.getBlockPos()).multiply(1.0, 0.0, 1.0).closerThan(cameraPos.multiply(1.0, 0.0, 1.0), (double)this.getViewDistance());
    }
}
