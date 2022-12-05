package earth.terrarium.handcrafted.client.block.specialbed;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.chair.ExpandableCouchBlock;
import earth.terrarium.handcrafted.block.specialbed.SpecialBedBlock;
import earth.terrarium.handcrafted.block.specialbed.SpecialBedBlockEntity;
import earth.terrarium.handcrafted.block.chair.tablebench.TableBenchBlock;
import earth.terrarium.handcrafted.block.property.DirectionalBlockSide;
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
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.properties.BedPart;

public class SpecialBedRenderer implements BlockEntityRenderer<SpecialBedBlockEntity> {
    public SpecialBedRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(SpecialBedBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        if (entity.getBlockState().getValue(BedBlock.PART) == BedPart.HEAD) {
            return;
        }
        DirectionalBlockSide doubleBed = entity.getBlockState().getValue(SpecialBedBlock.BED_SHAPE);
        SpecialBedModel model = switch (entity.getBlockState().getValue(TableBenchBlock.TABLE_BENCH_SHAPE)) {
            case SINGLE -> new SpecialBedModel(modelSet.bakeLayer(SpecialBedModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new SpecialBedModel(modelSet.bakeLayer(SpecialBedModel.LAYER_LOCATION_DOUBLE_LEFT));
            case MIDDLE -> new SpecialBedModel(modelSet.bakeLayer(SpecialBedModel.LAYER_LOCATION_SINGLE)); // TODO Make middle bed
            case RIGHT -> new SpecialBedModel(modelSet.bakeLayer(SpecialBedModel.LAYER_LOCATION_DOUBLE_RIGHT));
        };

        boolean visible = entity.getBlockState().getValue(BedBlock.OCCUPIED);
        model.getMain().getChild("sheets").getChild("with_player").visible = visible;
        model.getMain().getChild("sheets").getChild("without_player").visible = !visible;
        render(doubleBed, entity.getSheet(), entity.getCushion(), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(DirectionalBlockSide doubleBed, ResourceLocation sheet, ResourceLocation cushion, ResourceLocation texture, SpecialBedModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Vector3f.YN.rotationDegrees(direction.getOpposite().toYRot()));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
        if (doubleBed == DirectionalBlockSide.SINGLE) {
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/single/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        } else {
            String append = "_left";
            if (doubleBed == DirectionalBlockSide.LEFT) {
                append = "_left";
            } else if (doubleBed == DirectionalBlockSide.RIGHT) {
                append = "_right";
            }
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/double/" + texture.getPath() + append + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        if (!sheet.toString().equals("minecraft:air")) {
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/double/sheet/" + sheet.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        if (!cushion.toString().equals("minecraft:air")) {
            model.getMain().getChild("sheets").visible = false;
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/double/cushion/" + cushion.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(DirectionalBlockSide.SINGLE, new ResourceLocation(Handcrafted.MOD_ID, "white_sheet"), new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"), Registry.ITEM.getKey(stack.getItem()), new SpecialBedModel(Minecraft.getInstance().getEntityModels().bakeLayer(SpecialBedModel.LAYER_LOCATION_SINGLE)), Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
