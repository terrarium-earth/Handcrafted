package earth.terrarium.handcrafted.client.renderer.fancypainting;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.utils.ClientPlatformUtils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class FancyPaintingModel {
    public static final ModelLayerLocation LAYER_LOCATION_SMALL = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_small"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MEDIUM = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_medium"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LARGE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_large"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_TALL = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_tall"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_WIDE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_wide"), "main");

    public static LayerDefinition paintingLargeLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 38).addBox(-24.0F, 6.0F, 6.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-24.0F, -28.0F, 6.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-26.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(24.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(16, 0).addBox(-19.0F, -0.5F, 1.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 6.4228F, 8.2706F, -2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingMediumLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 38).addBox(-16.0F, 6.0F, 6.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-18.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(16.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-16.0F, -28.0F, 6.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(16, 0).addBox(-11.0F, -0.5F, 1.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 6.4228F, 8.2706F, -2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingSmallLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 38).addBox(-8.0F, -2.0F, 6.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-10.0F, -20.0F, 6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(8.0F, -20.0F, 6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -20.0F, 6.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(16, 0).addBox(-3.0F, -0.5F, 1.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5772F, 8.2706F, -2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingTallLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 38).addBox(-8.0F, 6.0F, 6.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-10.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(8.0F, -28.0F, 6.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -28.0F, 6.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(16, 0).addBox(-3.0F, -1.5F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5814F, 6.0402F, -2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingWideLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 38).addBox(-16.0F, -2.0F, 6.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-18.0F, -20.0F, 6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(16.0F, -20.0F, 6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-16.0F, -20.0F, 6.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(16, 0).addBox(-11.0F, -1.5F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -1.4186F, 6.0402F, -2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(ClientPlatformUtils.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_LARGE, FancyPaintingModel::paintingLargeLayer);
        registry.register(LAYER_LOCATION_MEDIUM, FancyPaintingModel::paintingMediumLayer);
        registry.register(LAYER_LOCATION_SMALL, FancyPaintingModel::paintingSmallLayer);
        registry.register(LAYER_LOCATION_TALL, FancyPaintingModel::paintingTallLayer);
        registry.register(LAYER_LOCATION_WIDE, FancyPaintingModel::paintingWideLayer);
    }
}
