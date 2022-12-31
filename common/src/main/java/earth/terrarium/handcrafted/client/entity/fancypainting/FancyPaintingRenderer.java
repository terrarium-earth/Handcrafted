package earth.terrarium.handcrafted.client.entity.fancypainting;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.entity.FancyPainting;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class FancyPaintingRenderer extends EntityRenderer<FancyPainting> {
    public FancyPaintingRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(FancyPainting entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        PaintingVariant variant = entity.getVariant().value();
        Direction dir = entity.getDirection();
        int width = variant.getWidth();
        int height = variant.getHeight();
        FancyPaintingModel model;
        if (width == 32 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_MEDIUM));
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.NORTH) poseStack.translate(-0.4, 0.0, 0.0);
            if (dir == Direction.SOUTH) poseStack.translate(0.4, 0.0, 0.0);
        } else if (width == 48 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_LARGE));
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.EAST) poseStack.translate(0.0, 0.0, 0.4);
            if (dir == Direction.WEST) poseStack.translate(0.0, 0.0, -0.4);
        } else if (width == 16 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_TALL));
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.EAST) poseStack.translate(0.0, 0.0, 0.4);
            if (dir == Direction.WEST) poseStack.translate(0.0, 0.0, -0.4);
        } else if (width == 32 && height == 16) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_WIDE));
            if (dir == Direction.NORTH) poseStack.translate(-0.4, 0.0, 0.0);
            if (dir == Direction.SOUTH) poseStack.translate(0.4, 0.0, 0.0);
        } else {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_SMALL));
            if (dir == Direction.EAST) poseStack.translate(0.0, 0.0, 0.4);
            if (dir == Direction.WEST) poseStack.translate(0.0, 0.0, -0.4);
        }

        poseStack.scale(0.8f, 0.8f, 0.8f);
        switch (dir) {
            case NORTH -> poseStack.translate(0.0, 0, -0.023);
            case EAST -> poseStack.translate(0.023, 0, -0.5);
            case SOUTH -> poseStack.translate(0.0, 0, 0.023);
            case WEST -> poseStack.translate(-0.023, 0, 0.5);
        }

        poseStack.pushPose();
        poseStack.translate(0.0, 0.875, 0.0);
        poseStack.mulPose(Axis.YN.rotationDegrees(dir.getOpposite().toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(180));
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entitySolid(getTextureLocation(entity))), packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(FancyPainting entity) {
        return new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/" + BuiltInRegistries.PAINTING_VARIANT.getKey(entity.getVariant().value()).getPath() + ".png");
    }
}