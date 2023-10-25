package earth.terrarium.handcrafted.client.renderer.fancypainting;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.entities.FancyPainting;
import earth.terrarium.handcrafted.common.registry.ModPaintingVariants;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.stream.Collectors;

public class FancyPaintingRenderer extends EntityRenderer<FancyPainting> {
    private static final ResourceLocation FRAME_SMALL_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/small_painting_frame.png");
    private static final ResourceLocation FRAME_MEDIUM_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/medium_painting_frame.png");
    private static final ResourceLocation FRAME_LARGE_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/large_painting_frame.png");
    private static final ResourceLocation FRAME_TALL_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/tall_painting_frame.png");
    private static final ResourceLocation FRAME_WIDE_TEXTURE = new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/wide_painting_frame.png");

    private static final Map<PaintingVariant, ResourceLocation> PAINTING_TEXTURES_BY_VARIANT = ModPaintingVariants.PAINTING_VARIANTS.stream()
        .collect(Collectors.toUnmodifiableMap(RegistryEntry::get, v -> new ResourceLocation(Handcrafted.MOD_ID, "textures/painting/" + v.getId().getPath() + ".png")));

    private static final Map<PaintingVariant, ResourceLocation> FRAME_TEXTURES_BY_VARIANT = ModPaintingVariants.PAINTING_VARIANTS.stream()
        .map(RegistryEntry::get)
        .collect(Collectors.toUnmodifiableMap(v -> v, v -> {
            int width = v.getWidth();
            int height = v.getHeight();
            if (width == 16 && height == 16)
                return FRAME_SMALL_TEXTURE;
            if (width == 32 && height == 32)
                return FRAME_MEDIUM_TEXTURE;
            if (width == 48 && height == 32)
                return FRAME_LARGE_TEXTURE;
            if (width == 16 && height == 32)
                return FRAME_TALL_TEXTURE;
            if (width == 32 && height == 16)
                return FRAME_WIDE_TEXTURE;
            throw new IllegalStateException("Unknown painting variant: " + v);
        }));

    private final Map<PaintingVariant, ModelPart> modelByVariant;


    public FancyPaintingRenderer(EntityRendererProvider.Context context) {
        super(context);
        var small = context.bakeLayer(FancyPaintingModel.LAYER_LOCATION_SMALL).getChild("main");
        var medium = context.bakeLayer(FancyPaintingModel.LAYER_LOCATION_MEDIUM).getChild("main");
        var large = context.bakeLayer(FancyPaintingModel.LAYER_LOCATION_LARGE).getChild("main");
        var tall = context.bakeLayer(FancyPaintingModel.LAYER_LOCATION_TALL).getChild("main");
        var wide = context.bakeLayer(FancyPaintingModel.LAYER_LOCATION_WIDE).getChild("main");

        modelByVariant = ModPaintingVariants.PAINTING_VARIANTS.stream()
            .map(RegistryEntry::get)
            .collect(Collectors.toUnmodifiableMap(v -> v, v -> {
                int width = v.getWidth();
                int height = v.getHeight();
                if (width == 16 && height == 16) return small;
                if (width == 32 && height == 32) return medium;
                if (width == 48 && height == 32) return large;
                if (width == 16 && height == 32) return tall;
                if (width == 32 && height == 16) return wide;
                throw new IllegalStateException("Unknown painting variant: " + v);
            }));
    }

    @Override
    public void render(FancyPainting entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        var variant = entity.getVariant().value();
        var direction = entity.getDirection();

        var frameVertex = buffer.getBuffer(RenderType.entitySolid(FRAME_TEXTURES_BY_VARIANT.get(variant)));

        int width = variant.getWidth();
        int height = variant.getHeight();
        try (var ignored = new CloseablePoseStack(poseStack)) {
            poseStack.scale(0.8f, 0.8f, 0.8f);
            poseStack.mulPose(Axis.YN.rotationDegrees(direction.toYRot()));
            poseStack.translate(0, 0.875f, 0.46125f);
            poseStack.mulPose(Axis.XP.rotationDegrees(180));
            modelByVariant.get(variant).render(poseStack, frameVertex, packedLight, OverlayTexture.NO_OVERLAY);

            var paintingVertex = buffer.getBuffer(RenderType.entitySolid(getTextureLocation(entity)));
            poseStack.translate(width / 2f / -16f, -0.125f + 0.5 * ((32 - height) / 16f), 0.46125);
            poseStack.scale(width / 16f, height / 16f, 1);
            renderPainting(poseStack, paintingVertex, direction, packedLight);
        }
    }

    private static void renderPainting(PoseStack poseStack, VertexConsumer consumer, Direction dir, int light) {
        Vec3i normal = dir.getNormal();
        consumer.vertex(poseStack.last().pose(), 0, 0, 0).color(255, 255, 255, 255).uv(0, 0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 0, 1, 0).color(255, 255, 255, 255).uv(0, 1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 1, 1, 0).color(255, 255, 255, 255).uv(1, 1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
        consumer.vertex(poseStack.last().pose(), 1, 0, 0).color(255, 255, 255, 255).uv(1, 0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(poseStack.last().normal(), normal.getX(), normal.getY(), normal.getZ()).endVertex();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(FancyPainting entity) {
        return PAINTING_TEXTURES_BY_VARIANT.get(entity.getVariant().value());
    }
}