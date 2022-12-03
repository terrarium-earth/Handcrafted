package earth.terrarium.handcrafted.client.block.chair.couch;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CouchModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_INVERTED_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_inverted_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "couch_right"), "main");

    public CouchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition couchSingleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition single = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -8.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 19.0F, 2.0F));

        single.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 24).addBox(-5.0F, -5.0F, -8.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        single.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 44).addBox(-7.0F, -15.0F, 0.0F, 14.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, -8.0F, 0.2182F, 0.0F, 0.0F));

        single.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, -5.0F, -8.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition couchCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition corner = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(57, 47).mirror().addBox(-0.5F, 4.0F, 0.0F, 15.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 53).mirror().addBox(-0.5F, 4.0F, 14.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 10.0F, -7.0F));

        corner.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(0.0F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, 2.0F, 1.5708F, 1.4399F, 1.4399F));

        corner.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 31).addBox(-3.0F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.1298F, 0.017F, -0.1298F));

        corner.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-2.5F, 0.0F, -1.5F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 0.0F, 1.5708F, 0.0F));

        corner.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 32).mirror().addBox(-13.5F, -15.0F, -0.5F, 15.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        corner.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(17, 32).addBox(-8.0F, -15.0F, 0.0F, 15.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 7.0F, 0.0F, 1.5708F, -0.1309F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition couchInvertedCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition inverted_corner = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(16, 101).addBox(-8.0F, -5.0F, -6.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(16, 120).addBox(-8.0F, -5.0F, -8.0F, 14.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        inverted_corner.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 101).addBox(-4.0F, -15.0F, -2.0F, 4.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -1.0F, -6.0F, 0.0F, 0.0F, 0.2182F));

        inverted_corner.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(88, 99).addBox(0.0F, -15.0F, 0.0F, 2.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -1.0F, -6.0F, 0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition couchLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 63).addBox(-4.0F, 0.0F, -8.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 19.0F, 2.0F));

        left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 44).addBox(-8.0F, -15.0F, 0.0F, 15.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, -8.0F, 0.2182F, 0.0F, 0.0F));

        left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, -5.0F, -8.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition couchMiddleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition middle = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 82).addBox(-4.0F, 0.0F, -8.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 19.0F, 2.0F));

        middle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 44).addBox(-8.0F, -15.0F, 0.0F, 16.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, -8.0F, 0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition couchRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 63).mirror().addBox(-4.0F, 0.0F, -8.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 19.0F, 2.0F));

        right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 24).addBox(-5.0F, -5.0F, -8.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 44).mirror().addBox(-7.0F, -15.0F, 0.0F, 15.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 4.0F, -8.0F, 0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, CouchModel::couchSingleLayer);
        registry.register(LAYER_LOCATION_CORNER, CouchModel::couchCornerLayer);
        registry.register(LAYER_LOCATION_INVERTED_CORNER, CouchModel::couchInvertedCornerLayer);
        registry.register(LAYER_LOCATION_LEFT, CouchModel::couchLeftLayer);
        registry.register(LAYER_LOCATION_MIDDLE, CouchModel::couchMiddleLayer);
        registry.register(LAYER_LOCATION_RIGHT, CouchModel::couchRightLayer);
    }
}
