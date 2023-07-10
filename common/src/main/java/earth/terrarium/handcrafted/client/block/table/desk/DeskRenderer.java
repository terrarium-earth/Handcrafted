package earth.terrarium.handcrafted.client.block.table.desk;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.table.desk.DeskBlockEntity;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlock;
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

public class DeskRenderer implements BlockEntityRenderer<DeskBlockEntity> {
    public DeskRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(ResourceLocation sheet, ResourceLocation texture, DeskModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(Axis.YN.rotationDegrees(direction.toYRot()));
            poseStack.mulPose(Axis.XP.rotationDegrees(180));

            model.getMain().getChild("overlay").visible = false;
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/desk/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            model.getMain().getChild("overlay").visible = true;
            model.getMain().getChild("table").visible = false;
            if (!sheet.toString().equals("minecraft:air")) {
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/table_cloth/" + sheet.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void render(DeskBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        DeskModel model = new DeskModel(modelSet.bakeLayer(DeskModel.LAYER_LOCATION));
        render(BuiltInRegistries.ITEM.getKey(entity.getStack().getItem()), BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(NightstandBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(new ResourceLocation("air"), BuiltInRegistries.ITEM.getKey(stack.getItem()), new DeskModel(Minecraft.getInstance().getEntityModels().bakeLayer(DeskModel.LAYER_LOCATION)), Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
