package earth.terrarium.handcrafted.client.block.stackablebook;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlock;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;

@Environment(EnvType.CLIENT)
public class StackableBookRenderer implements BlockEntityRenderer<StackableBookBlockEntity> {
    public StackableBookRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(int books, long seed, ResourceLocation texture, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.getOpposite().toYRot()));
            poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
            EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();

            RandomSource random = RandomSource.create(seed);
            for (int i = 0; i < books; i++) {

                StackableBookModel model = switch (i + 1) {
                    case 2 -> new StackableBookModel(modelSet.bakeLayer(StackableBookModel.LAYER_LOCATION_BOOK_2));
                    case 4 -> new StackableBookModel(modelSet.bakeLayer(StackableBookModel.LAYER_LOCATION_BOOK_3));
                    default -> new StackableBookModel(modelSet.bakeLayer(StackableBookModel.LAYER_LOCATION_BOOK_1));
                };

                poseStack.translate(0, -4f / 16 * i, 0);
                poseStack.mulPose(Vector3f.YP.rotationDegrees(random.nextInt()));
                String colour = DyeColor.byId(random.nextInt(DyeColor.values().length)).toString();
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(texture.getNamespace(), "textures/block/stackable_book/" + colour + "_book" + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
                poseStack.translate(0, 4f / 16 * i, 0);
            }
        }
    }

    @Override
    public void render(StackableBookBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        render(entity.getBlockState().getValue(StackableBookBlock.BOOKS), entity.getBlockPos().asLong(), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), entity.getBlockState().getValue(ExpandableCouchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }
}
