package earth.terrarium.handcrafted.client.block.table.table;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.common.block.property.SheetState;
import earth.terrarium.handcrafted.common.block.property.TableState;
import earth.terrarium.handcrafted.common.block.table.table.TableBlock;
import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class TableRenderer implements BlockEntityRenderer<TableBlockEntity> {
    public TableRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    private static void render(ResourceLocation sheet, TableState tableState, SheetState sheetState, ResourceLocation texture, TableModel model, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.mulPose(Vector3f.XP.rotationDegrees(180));

            ModelPart northeastLeg = model.getMain().getChild("table").getChild("northeast_leg");
            ModelPart northwestLeg = model.getMain().getChild("table").getChild("northwest_leg");
            ModelPart southeastLeg = model.getMain().getChild("table").getChild("southeast_leg");
            ModelPart southwestLeg = model.getMain().getChild("table").getChild("southwest_leg");

            ModelPart northOverlay = model.getMain().getChild("overlay").getChild("overlay_side_north");
            ModelPart eastOverlay = model.getMain().getChild("overlay").getChild("overlay_side_east");
            ModelPart southOverlay = model.getMain().getChild("overlay").getChild("overlay_side_south");
            ModelPart westOverlay = model.getMain().getChild("overlay").getChild("overlay_side_west");

            switch (tableState) {
                case CENTER -> {
                    northeastLeg.visible = false;
                    northwestLeg.visible = false;
                    southeastLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case NORTH_EAST_CORNER -> {
                    northeastLeg.visible = false;
                    northwestLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case NORTH_WEST_CORNER -> {
                    northeastLeg.visible = false;
                    northwestLeg.visible = false;
                    southeastLeg.visible = false;
                }
                case SOUTH_EAST_CORNER -> {
                    northwestLeg.visible = false;
                    southeastLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case SOUTH_WEST_CORNER -> {
                    northeastLeg.visible = false;
                    southeastLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case NORTH_SIDE -> {
                    northeastLeg.visible = false;
                    northwestLeg.visible = false;
                }
                case EAST_SIDE -> {
                    northwestLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case SOUTH_SIDE -> {
                    southeastLeg.visible = false;
                    southwestLeg.visible = false;
                }
                case WEST_SIDE -> {
                    northeastLeg.visible = false;
                    southeastLeg.visible = false;
                }
            }

            switch (sheetState) {
                case CENTER -> {
                    northOverlay.visible = false;
                    eastOverlay.visible = false;
                    southOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case NORTH_SIDE -> {
                    northOverlay.visible = false;
                    eastOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case EAST_SIDE -> {
                    northOverlay.visible = false;
                    eastOverlay.visible = false;
                    southOverlay.visible = false;
                }
                case SOUTH_SIDE -> {
                    eastOverlay.visible = false;
                    southOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case WEST_SIDE -> {
                    northOverlay.visible = false;
                    southOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case NORTH_EAST_CORNER -> {
                    northOverlay.visible = false;
                    eastOverlay.visible = false;
                }
                case NORTH_WEST_CORNER -> {
                    northOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case SOUTH_EAST_CORNER -> {
                    southOverlay.visible = false;
                    eastOverlay.visible = false;
                }
                case SOUTH_WEST_CORNER -> {
                    southOverlay.visible = false;
                    westOverlay.visible = false;
                }
                case NORTH_COVER -> northOverlay.visible = false;
                case EAST_COVER -> eastOverlay.visible = false;
                case SOUTH_COVER -> southOverlay.visible = false;
                case WEST_COVER -> westOverlay.visible = false;
            }

            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/table/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            if (!sheet.toString().equals("minecraft:air")) {
                model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/table/table_cloth/" + sheet.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void render(TableBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        TableModel model = new TableModel(modelSet.bakeLayer(TableModel.LAYER_LOCATION));
        render(Registry.ITEM.getKey(entity.getStack().getItem()), entity.getBlockState().getValue(TableBlock.TABLE_BLOCK_SHAPE), entity.getBlockState().getValue(TableBlock.TABLE_SHEET_SHAPE), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, poseStack, bufferSource, packedLight, packedOverlay);
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(new ResourceLocation("air"), TableState.SINGLE, SheetState.SINGLE, Registry.ITEM.getKey(stack.getItem()), new TableModel(Minecraft.getInstance().getEntityModels().bakeLayer(TableModel.LAYER_LOCATION)), poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
