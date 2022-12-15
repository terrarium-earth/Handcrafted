package earth.terrarium.handcrafted.client.block.table.nightstand;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlock;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlockEntity;
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
public class NightstandRenderer implements BlockEntityRenderer<NightstandBlockEntity> {
    public NightstandRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(NightstandBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        NightstandModel model = new NightstandModel(modelSet.bakeLayer(NightstandModel.LAYER_LOCATION));
        render(Registry.ITEM.getKey(entity.getStack().getItem()), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model,entity.getBlockState().getValue(NightstandBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation sheet, ResourceLocation texture, NightstandModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.toYRot()));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));

        model.getMain().getChild("overlay").visible = false;
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/nightstand/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        model.getMain().getChild("overlay").visible = true;
        model.getMain().getChild("table").visible = false;
        if (!sheet.toString().equals("minecraft:air")) {
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/table_cloth/" + sheet.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }

        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(new ResourceLocation("air"), Registry.ITEM.getKey(stack.getItem()), new NightstandModel(Minecraft.getInstance().getEntityModels().bakeLayer(NightstandModel.LAYER_LOCATION)), Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
