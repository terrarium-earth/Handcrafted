package earth.terrarium.handcrafted.client.block.chair.diningbench;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.chair.diningbench.DiningBenchBlock;
import earth.terrarium.handcrafted.common.block.chair.diningbench.DiningBenchBlockEntity;
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
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class DiningBenchRenderer implements BlockEntityRenderer<DiningBenchBlockEntity> {
    public DiningBenchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(ResourceLocation texture, DiningBenchModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.toYRot()));
            poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chair/dining_bench/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void render(DiningBenchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        DiningBenchModel model = switch (entity.getBlockState().getValue(DiningBenchBlock.DINING_BENCH_SHAPE)) {
            case SINGLE -> new DiningBenchModel(modelSet.bakeLayer(DiningBenchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new DiningBenchModel(modelSet.bakeLayer(DiningBenchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new DiningBenchModel(modelSet.bakeLayer(DiningBenchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new DiningBenchModel(modelSet.bakeLayer(DiningBenchModel.LAYER_LOCATION_RIGHT));
        };
        render(Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(DiningBenchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            DiningBenchModel model = new DiningBenchModel(Minecraft.getInstance().getEntityModels().bakeLayer(DiningBenchModel.LAYER_LOCATION_SINGLE));
            render(Registry.ITEM.getKey(stack.getItem()), model, Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
