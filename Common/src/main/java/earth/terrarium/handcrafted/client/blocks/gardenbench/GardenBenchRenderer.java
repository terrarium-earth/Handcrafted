package earth.terrarium.handcrafted.client.blocks.gardenbench;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.blocks.ExpandableCouchBlock;
import earth.terrarium.handcrafted.blocks.property.CouchShape;
import earth.terrarium.handcrafted.blocks.gardenbench.GardenBenchBlockEntity;
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

public class GardenBenchRenderer implements BlockEntityRenderer<GardenBenchBlockEntity> {
    public GardenBenchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(GardenBenchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        CouchShape shape = entity.getBlockState().getValue(ExpandableCouchBlock.COUCH_SHAPE);
        GardenBenchModel model = switch (shape) {
            case SINGLE -> new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_RIGHT));
            case INNER_LEFT, INNER_RIGHT ->
                    new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_CORNER));
            case OUTER_LEFT, OUTER_RIGHT ->
                    new GardenBenchModel(modelSet.bakeLayer(GardenBenchModel.LAYER_LOCATION_INVERTED_CORNER));
        };
        render(Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), shape, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation texture, GardenBenchModel model, Direction direction, CouchShape shape, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
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
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/garden_bench/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(Registry.ITEM.getKey(stack.getItem()), new GardenBenchModel(Minecraft.getInstance().getEntityModels().bakeLayer(GardenBenchModel.LAYER_LOCATION_SINGLE)), Direction.SOUTH, CouchShape.SINGLE, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
