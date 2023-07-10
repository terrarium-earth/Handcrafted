package earth.terrarium.handcrafted.client.entity.fancypainting;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.entity.FancyPainting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.jetbrains.annotations.NotNull;

public class FancyPaintingRenderer extends EntityRenderer<FancyPainting> {

    public static final ResourceLocation SMALL_FRAME_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/small_painting_frame.png");
    public static final ResourceLocation MEDIUM_FRAME_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/medium_painting_frame.png");
    public static final ResourceLocation LARGE_FRAME_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/large_painting_frame.png");
    public static final ResourceLocation WIDE_FRAME_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/wide_painting_frame.png");
    public static final ResourceLocation TALL_FRAME_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/tall_painting_frame.png");

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
        ResourceLocation frameTexture;
        if (width == 32 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_MEDIUM));
            frameTexture = MEDIUM_FRAME_TEXTURE;
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.NORTH) poseStack.translate(-0.4, 0.0, 0.0);
            if (dir == Direction.SOUTH) poseStack.translate(0.4, 0.0, 0.0);
        } else if (width == 48 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_LARGE));
            frameTexture = LARGE_FRAME_TEXTURE;
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.EAST) poseStack.translate(0.0, 0.0, 0.4);
            if (dir == Direction.WEST) poseStack.translate(0.0, 0.0, -0.4);
        } else if (width == 16 && height == 32) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_TALL));
            frameTexture = TALL_FRAME_TEXTURE;
            poseStack.translate(0.0, -0.4, 0.0);
            if (dir == Direction.EAST) poseStack.translate(0.0, 0.0, 0.4);
            if (dir == Direction.WEST) poseStack.translate(0.0, 0.0, -0.4);
        } else if (width == 32 && height == 16) {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_WIDE));
            frameTexture = WIDE_FRAME_TEXTURE;
            if (dir == Direction.NORTH) poseStack.translate(-0.4, 0.0, 0.0);
            if (dir == Direction.SOUTH) poseStack.translate(0.4, 0.0, 0.0);
        } else {
            model = new FancyPaintingModel(modelSet.bakeLayer(FancyPaintingModel.LAYER_LOCATION_SMALL));
            frameTexture = SMALL_FRAME_TEXTURE;
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

        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.translate(0.0, 0.875, 0.0);
            poseStack.mulPose(Axis.YN.rotationDegrees(dir.getOpposite().toYRot()));
            poseStack.mulPose(Axis.XP.rotationDegrees(180));
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entitySolid(frameTexture)), packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

            poseStack.translate(0, 0, 0.01f);
            poseStack.scale(width / 16f, height / 16f, 1);

            if (width == 32 && height == 32) {
                poseStack.translate(-4 / 16f, -5 / 16f, 0);
            } else if (width == 48 && height == 32) {
                poseStack.translate(-8 / 16f, -5 / 16f, 0);
            } else if (width == 16 && height == 32) {
                poseStack.translate(-8 / 16f, -5 / 16f, 0);
            } else if (width == 32 && height == 16) {
                poseStack.translate(-4 / 16f, 6 / 16f, 0);
            } else {
                poseStack.translate(-8 / 16f, 6 / 16f, 0);
            }

            renderPainting(poseStack, buffer.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity))), dir, packedLight, OverlayTexture.NO_OVERLAY);
        }
    }

    private static void renderPainting(PoseStack poseStack, VertexConsumer consumer, Direction dir, int light, int overlay) {
        Vec3i normal = dir.getNormal();
        consumer.vertex(poseStack.last().pose(), 0, 0, 0).color(255, 255, 255, 255).uv(0, 0).overlayCoords(overlay).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 0, 1, 0).color(255, 255, 255, 255).uv(0, 1).overlayCoords(overlay).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 1, 1, 0).color(255, 255, 255, 255).uv(1, 1).overlayCoords(overlay).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 1, 0, 0).color(255, 255, 255, 255).uv(1, 0).overlayCoords(overlay).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(FancyPainting entity) {
        return new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/" + BuiltInRegistries.PAINTING_VARIANT.getKey(entity.getVariant().value()).getPath() + ".png");
    }
}