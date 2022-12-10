package earth.terrarium.handcrafted.client.block.chair.woodenbench;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.block.chair.woodenbench.WoodenBenchBlockEntity;
import earth.terrarium.handcrafted.common.block.property.CouchShape;
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
public class WoodenBenchRenderer implements BlockEntityRenderer<WoodenBenchBlockEntity> {
    public WoodenBenchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(WoodenBenchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        CouchShape shape = entity.getBlockState().getValue(ExpandableCouchBlock.COUCH_SHAPE);
        WoodenBenchModel model = switch (shape) {
            case SINGLE -> new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_RIGHT));
            case INNER_LEFT, INNER_RIGHT ->
                    new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_CORNER));
            case OUTER_LEFT, OUTER_RIGHT ->
                    new WoodenBenchModel(modelSet.bakeLayer(WoodenBenchModel.LAYER_LOCATION_INVERTED_CORNER));
        };
        render(Registry.ITEM.getKey(entity.getCushion().getItem()), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), shape, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation cushion, ResourceLocation texture, WoodenBenchModel model, Direction direction, CouchShape shape, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(switch (direction) {
            case EAST -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(90);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(180);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(0);
            };
            case SOUTH -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(0);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(90);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(270);
            };
            case WEST -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(270);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(0);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(180);
            };
            default -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(180);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(270);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(90);
            };
        });
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/bench/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        if (!cushion.toString().equals("minecraft:air")) {
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/bench/cushion/" + cushion.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        } else {
            model.getMain().getChild("with_cushions").visible = false;
        }
        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            WoodenBenchModel model = new WoodenBenchModel(Minecraft.getInstance().getEntityModels().bakeLayer(WoodenBenchModel.LAYER_LOCATION_SINGLE));
            render(new ResourceLocation("air"), Registry.ITEM.getKey(stack.getItem()), model, Direction.SOUTH, CouchShape.SINGLE, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
