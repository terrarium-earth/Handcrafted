package earth.terrarium.handcrafted.client.entity.fancypainting;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class FancyPaintingModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SMALL = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_small"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MEDIUM = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_medium"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LARGE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_large"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_TALL = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_tall"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_WIDE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "fancy_painting_wide"), "main");

    public FancyPaintingModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition paintingLargeLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 42).addBox(-24.0F, -34.0F, -1.0F, 48.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-24.0F, -2.0F, -1.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-24.0F, -36.0F, -1.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-26.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(24.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-25.0F, -2.0F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -1.1152F, 1.0793F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingMediumLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 42).addBox(-8.0F, -34.0F, -1.0F, 32.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -2.0F, -1.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -36.0F, -1.0F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-10.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(24.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-17.0F, -2.0F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -1.1152F, 1.0793F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingSmallLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 42).addBox(-8.0F, -18.0F, -1.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -20.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-10.0F, -20.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(8.0F, -20.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-25.0F, -2.0F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -1.1152F, 1.0793F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingTallLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 42).addBox(-8.0F, -34.0F, -1.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-8.0F, -36.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-10.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(8.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-25.0F, -2.0F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -1.1152F, 1.0793F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition paintingWideLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 42).addBox(-16.0F, -9.6846F, -1.1776F, 32.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-16.0F, 6.3154F, -1.1776F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 38).addBox(-16.0F, -11.6846F, -1.1776F, 32.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(8, 0).addBox(-18.0F, -11.6846F, -1.1776F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(4, 0).addBox(16.0F, -11.6846F, -1.1776F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 15.6846F, 0.1776F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-17.0F, -2.0F, -0.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 7.2002F, 0.9017F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_LARGE, FancyPaintingModel::paintingLargeLayer);
        registry.register(LAYER_LOCATION_MEDIUM, FancyPaintingModel::paintingMediumLayer);
        registry.register(LAYER_LOCATION_SMALL, FancyPaintingModel::paintingSmallLayer);
        registry.register(LAYER_LOCATION_TALL, FancyPaintingModel::paintingTallLayer);
        registry.register(LAYER_LOCATION_WIDE, FancyPaintingModel::paintingWideLayer);
    }
}
