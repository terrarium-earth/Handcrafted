package earth.terrarium.handcrafted.client.blocks.tablechair;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.blocks.ExpandableCouchBlock;
import earth.terrarium.handcrafted.blocks.property.CouchShape;
import earth.terrarium.handcrafted.blocks.tablechair.TableChairBlockEntity;
import net.minecraft.client.Minecraft;
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

public class TableChairRenderer implements BlockEntityRenderer<TableChairBlockEntity> {
    public TableChairRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(TableChairBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        CouchShape shape = entity.getBlockState().getValue(ExpandableCouchBlock.COUCH_SHAPE);
        render(entity.getCushion(), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), entity.getBlockState().getValue(ExpandableCouchBlock.FACING), shape, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation cushion, ResourceLocation texture, Direction direction, CouchShape shape, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        TableChairModel model = new TableChairModel(Minecraft.getInstance().getEntityModels().bakeLayer(TableChairModel.LAYER_LOCATION));
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.getOpposite().toYRot()));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
        model.getMain().getChild("with_cushions").visible = false;
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/table_chair/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        model.getMain().getChild("with_cushions").visible = true;
        if (!cushion.toString().equals("minecraft:air")) {
            model.getMain().getChild("base").visible = false;
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/table_chair/cushion/" + cushion.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
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
            render(new ResourceLocation("air"), Registry.ITEM.getKey(stack.getItem()), Direction.SOUTH, CouchShape.SINGLE, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
