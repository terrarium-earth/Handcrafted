package earth.terrarium.handcrafted.client.block.fancybed;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.block.chair.diningbench.DiningBenchBlock;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlock;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlockEntity;
import earth.terrarium.handcrafted.common.block.property.DirectionalBlockSide;
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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.properties.BedPart;

@Environment(EnvType.CLIENT)
public class FancyBedRenderer implements BlockEntityRenderer<FancyBedBlockEntity> {
    public FancyBedRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(DirectionalBlockSide doubleBed, ResourceLocation sheet, ResourceLocation cushion, ResourceLocation texture, FancyBedModel model, Direction direction, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(Axis.YN.rotationDegrees(direction.getOpposite().toYRot()));
            poseStack.mulPose(Axis.XP.rotationDegrees(180));
            model.getMain().getChild("sheets").visible = false;
            if (doubleBed == DirectionalBlockSide.SINGLE) {
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/single/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            } else {
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/double/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
            model.getMain().getChild("sheets").visible = true;
            if (!sheet.toString().equals("minecraft:air")) {
                model.getMain().getChild("frame").visible = false;
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/sheet/" + sheet.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
            if (!cushion.toString().equals("minecraft:air")) {
                model.getMain().getChild("sheets").visible = false;
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/bed/cushion/" + cushion.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void render(FancyBedBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        if (entity.getBlockState().getValue(BedBlock.PART) == BedPart.HEAD) {
            return;
        }
        DirectionalBlockSide doubleBed = entity.getBlockState().getValue(FancyBedBlock.BED_SHAPE);
        FancyBedModel model = switch (entity.getBlockState().getValue(DiningBenchBlock.DINING_BENCH_SHAPE)) {
            case SINGLE -> new FancyBedModel(modelSet.bakeLayer(FancyBedModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new FancyBedModel(modelSet.bakeLayer(FancyBedModel.LAYER_LOCATION_DOUBLE_LEFT));
            case MIDDLE -> new FancyBedModel(modelSet.bakeLayer(FancyBedModel.LAYER_LOCATION_DOUBLE_MIDDLE));
            case RIGHT -> new FancyBedModel(modelSet.bakeLayer(FancyBedModel.LAYER_LOCATION_DOUBLE_RIGHT));
        };

        boolean visible = entity.getBlockState().getValue(BedBlock.OCCUPIED);
        model.getMain().getChild("sheets").getChild("with_player").visible = visible;
        model.getMain().getChild("sheets").getChild("without_player").visible = !visible;
        render(doubleBed, BuiltInRegistries.ITEM.getKey(entity.getSheet().getItem()), BuiltInRegistries.ITEM.getKey(entity.getStack().getItem()), BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            try (var ignored = new CloseablePoseStack(poseStack)) {
                poseStack.scale(0.75f, 0.75f, 0.75f);
                render(DirectionalBlockSide.SINGLE, new ResourceLocation(Handcrafted.MOD_ID, "white_sheet"), new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"), BuiltInRegistries.ITEM.getKey(stack.getItem()), new FancyBedModel(Minecraft.getInstance().getEntityModels().bakeLayer(FancyBedModel.LAYER_LOCATION_SINGLE)), Direction.SOUTH, poseStack, buffer, packedLight, packedOverlay);
            }
        }
    }
}
