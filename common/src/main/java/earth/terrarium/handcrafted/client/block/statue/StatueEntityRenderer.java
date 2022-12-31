package earth.terrarium.handcrafted.client.block.statue;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

@Environment(EnvType.CLIENT)
public class StatueEntityRenderer implements BlockEntityRenderer<StatueBlockEntity> {
    public StatueEntityRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(ResourceLocation texture, StatueModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Axis.YN.rotationDegrees(direction.toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(180));
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/trophy/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }

    @Override
    public void render(StatueBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (entity.getBlockState().getValue(StatueBlock.HALF) == DoubleBlockHalf.UPPER) return;
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        StatueModel model = new StatueModel(modelSet.bakeLayer(StatueModel.LAYER_LOCATION_WITCH));
        render(BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            poseStack.pushPose();
            poseStack.mulPose(Axis.YN.rotationDegrees(180));
            poseStack.translate(-1, 0, -1);
            render(BuiltInRegistries.ITEM.getKey(stack.getItem()), new StatueModel(Minecraft.getInstance().getEntityModels().bakeLayer(StatueModel.LAYER_LOCATION_WITCH)), Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
            poseStack.popPose();
        }
    }
}
