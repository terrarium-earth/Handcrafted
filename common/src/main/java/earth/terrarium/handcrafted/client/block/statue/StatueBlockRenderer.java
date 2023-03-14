package earth.terrarium.handcrafted.client.block.statue;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

@Environment(EnvType.CLIENT)
public class StatueBlockRenderer implements BlockEntityRenderer<StatueBlockEntity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public StatueBlockRenderer(BlockEntityRendererProvider.Context ctx) {
        blockRenderDispatcher = ctx.getBlockRenderDispatcher();
    }

    @Override
    public void render(StatueBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BakedModel blockModel = blockRenderDispatcher.getBlockModel(entity.getBlockState());
        try (var ignored = new CloseablePoseStack(poseStack)) {
            if (entity.getBlockState().getValue(StatueBlock.HALF) == DoubleBlockHalf.UPPER) {
                return;
            }
            blockRenderDispatcher.getModelRenderer().renderModel(poseStack.last(), bufferSource.getBuffer(Sheets.cutoutBlockSheet()), entity.getBlockState(), blockModel, 1f, 1f, 1f, packedLight, packedOverlay);
        }
    }
}
