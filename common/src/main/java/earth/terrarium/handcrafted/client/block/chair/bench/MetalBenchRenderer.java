package earth.terrarium.handcrafted.client.block.chair.bench;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.chair.bench.BenchBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.block.property.CouchShape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class MetalBenchRenderer implements BlockEntityRenderer<BenchBlockEntity> {
    public MetalBenchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(ResourceLocation texture, BenchModel model, Direction direction, CouchShape shape, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(switch (direction) {
                case EAST -> switch (shape) {
                    case INNER_LEFT -> Axis.YP.rotationDegrees(0);
                    case MIDDLE, LEFT, RIGHT, SINGLE -> Axis.YP.rotationDegrees(90);
                    case OUTER_RIGHT -> Axis.YP.rotationDegrees(180);
                    case OUTER_LEFT, INNER_RIGHT -> Axis.YP.rotationDegrees(270);
                };
                case SOUTH -> switch (shape) {
                    case MIDDLE, LEFT, RIGHT, SINGLE -> Axis.YP.rotationDegrees(0);
                    case OUTER_RIGHT -> Axis.YP.rotationDegrees(90);
                    case OUTER_LEFT, INNER_RIGHT -> Axis.YP.rotationDegrees(180);
                    case INNER_LEFT -> Axis.YP.rotationDegrees(270);
                };
                case WEST -> switch (shape) {
                    case OUTER_RIGHT -> Axis.YP.rotationDegrees(0);
                    case INNER_RIGHT, OUTER_LEFT -> Axis.YP.rotationDegrees(90);
                    case INNER_LEFT -> Axis.YP.rotationDegrees(180);
                    case MIDDLE, LEFT, RIGHT, SINGLE -> Axis.YP.rotationDegrees(270);
                };
                default -> switch (shape) {
                    case OUTER_LEFT, INNER_RIGHT -> Axis.YP.rotationDegrees(0);
                    case INNER_LEFT -> Axis.YP.rotationDegrees(90);
                    case MIDDLE, LEFT, RIGHT, SINGLE -> Axis.YP.rotationDegrees(180);
                    case OUTER_RIGHT -> Axis.YP.rotationDegrees(270);
                };
            });
            poseStack.mulPose(Axis.XP.rotationDegrees(180));
            poseStack.mulPose(Axis.YP.rotationDegrees(180));
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chair/bench/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void render(BenchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        CouchShape shape = entity.getBlockState().getValue(ExpandableCouchBlock.COUCH_SHAPE);
        BenchModel model = switch (shape) {
            case SINGLE -> new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_RIGHT));
            case INNER_LEFT, INNER_RIGHT -> new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_CORNER));
            case OUTER_LEFT, OUTER_RIGHT ->
                new BenchModel(modelSet.bakeLayer(BenchModel.LAYER_LOCATION_INVERTED_CORNER));
        };
        render(BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), shape, poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            try (var ignored = new CloseablePoseStack(poseStack)) {
                poseStack.scale(0.75f, 0.75f, 0.75f);
                render(BuiltInRegistries.ITEM.getKey(stack.getItem()), new BenchModel(Minecraft.getInstance().getEntityModels().bakeLayer(BenchModel.LAYER_LOCATION_SINGLE)), Direction.SOUTH, CouchShape.SINGLE, poseStack, buffer, packedLight, packedOverlay);
            }
        }
    }
}
