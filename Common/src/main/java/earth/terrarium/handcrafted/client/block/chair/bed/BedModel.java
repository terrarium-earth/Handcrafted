package earth.terrarium.handcrafted.client.block.chair.bed;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class BedModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_DOUBLE_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_double_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_DOUBLE_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_double_right"), "main");

    public BedModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition bedSingle() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.8839F, -23.8839F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.8839F, 17.8839F));

        PartDefinition cube_r1 = sheets.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 30).addBox(-5.0F, -1.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(6, 39).addBox(-7.0F, -9.25F, -7.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(55, 0).addBox(-8.0F, 4.25F, -4.5F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(55, 0).addBox(-8.0F, -1.75F, -4.5F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.75F, 7.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r3 = with_player.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(56, 40).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.25F, 10.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(55, 0).addBox(-8.0F, -7.25F, 9.0F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        PartDefinition frame = main.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(10, 30).addBox(8.5F, -3.5F, -3.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(8.5F, -10.5F, 25.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-2.5F, -1.5F, -1.5F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(0.5F, -3.5F, -2.5F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 3).addBox(0.5F, -10.5F, 25.5F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(55, 18).addBox(-3.5F, -5.5F, -4.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(55, 13).addBox(-3.5F, -12.5F, 24.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-2.5F, -10.5F, 25.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-2.5F, -3.5F, -3.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -3.5F, -4.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition bedDoubleLeft() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.25F, -8.0F, 12.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-7.0F, -12.25F, 20.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 6).addBox(-7.0F, -5.25F, -9.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -3.25F, -7.0F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-8.0F, -7.25F, -10.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-8.0F, -14.25F, 19.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(38, 30).addBox(-4.0F, -12.25F, 20.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.25F, 1.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.8839F, -23.8839F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.1339F, 16.8839F));

        PartDefinition cube_r1 = sheets.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(57, 16).addBox(-5.0F, -1.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(0, 30).addBox(-6.0F, -9.25F, -7.0F, 13.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 30).addBox(-16.0F, -3.8076F, -7.1259F, 16.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -8.4424F, 10.1259F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r3 = with_player.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 49).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(57, 0).addBox(-7.0F, -7.0F, -0.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.25F, 10.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(0, 49).addBox(-8.0F, -7.25F, 9.0F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition bedDoubleRight() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 35).addBox(-8.0F, -14.0F, 21.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 6).addBox(4.0F, -7.0F, -8.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(4.0F, -14.0F, 21.0F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -5.0F, -6.0F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -7.0F, -7.0F, 12.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-8.0F, -9.0F, -9.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-8.0F, -16.0F, 20.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, 0.8839F, -23.8839F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -8.8839F, 17.8839F));

        PartDefinition cube_r1 = sheets.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(57, 16).addBox(-5.0F, -1.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(0, 30).addBox(9.0F, -9.25F, -7.0F, 13.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(57, 0).addBox(9.0F, -7.0F, -0.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(46, 49).addBox(7.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.25F, 10.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r3 = with_player.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(42, 30).addBox(0.0F, -3.8076F, -7.1259F, 16.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -8.4424F, 10.1259F, 0.3054F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(0, 49).addBox(8.0F, -7.25F, 9.0F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.1339F, -16.8839F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, BedModel::bedSingle);
        registry.register(LAYER_LOCATION_DOUBLE_LEFT, BedModel::bedDoubleLeft);
        registry.register(LAYER_LOCATION_DOUBLE_RIGHT, BedModel::bedDoubleRight);
    }
}
