package earth.terrarium.handcrafted.client.block.chair.tablebench;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.common.block.chair.tablebench.TableBenchBlock;
import earth.terrarium.handcrafted.common.block.chair.tablebench.TableBenchBlockEntity;
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
public class TableBenchRenderer implements BlockEntityRenderer<TableBenchBlockEntity> {
    public TableBenchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(TableBenchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        TableBenchModel model = switch (entity.getBlockState().getValue(TableBenchBlock.TABLE_BENCH_SHAPE)) {
            case SINGLE -> new TableBenchModel(modelSet.bakeLayer(TableBenchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new TableBenchModel(modelSet.bakeLayer(TableBenchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new TableBenchModel(modelSet.bakeLayer(TableBenchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new TableBenchModel(modelSet.bakeLayer(TableBenchModel.LAYER_LOCATION_RIGHT));
        };
        render(Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(TableBenchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation texture, TableBenchModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.toYRot()));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chair/table_bench/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            TableBenchModel model = new TableBenchModel(Minecraft.getInstance().getEntityModels().bakeLayer(TableBenchModel.LAYER_LOCATION_SINGLE));
            render(Registry.ITEM.getKey(stack.getItem()), model, Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
