package earth.terrarium.handcrafted.client.block.specialbed;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class SpecialBedModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_DOUBLE_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_double_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_DOUBLE_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_double_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_DOUBLE_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bed_double_right"), "main");

    public SpecialBedModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition bedSingle() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(55, 30).addBox(-8.0F, -0.1161F, -7.8839F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, 0.8839F, -23.8839F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.8839F, 17.8839F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, -11.0F, -6.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, -8.0F, -6.0F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = with_player.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 43).addBox(-8.0F, 4.25F, -4.5F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(55, 30).addBox(-8.0F, -1.75F, -4.5F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 8.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 60).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -13.0F, 11.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition frame = main.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(10, 30).addBox(8.5F, -3.5F, -3.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(8.5F, -10.5F, 25.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, -1.5F, -1.5F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(0.5F, -3.5F, -2.5F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.5F, -10.5F, 25.5F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 60).addBox(-3.5F, -5.5F, -4.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(55, 19).addBox(-3.5F, -12.5F, 24.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-2.5F, -10.5F, 25.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 18).addBox(-2.5F, -3.5F, -3.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -3.5F, -4.5F));

        PartDefinition cushion = main.addOrReplaceChild("cushion", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = cushion.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 60).addBox(-5.0F, -1.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.8839F, 17.8839F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone3 = main.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition bedDoubleLeft() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, -11.0F, -6.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(7.0F, -11.0F, -6.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, -8.0F, -6.0F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(7.0F, -8.0F, -6.0F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r1 = with_player.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 43).addBox(-7.999F, 4.25F, -4.5F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(55, 30).addBox(-7.999F, -1.75F, -4.5F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 8.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 60).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -13.0F, 11.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(55, 30).addBox(-7.999F, -0.1161F, -6.8839F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, 0.8839F, -22.8839F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(7.0F, 0.8839F, -22.8839F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.8839F, 17.8839F));

        PartDefinition frame = main.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, -0.5F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.5F, -3.5F, -1.5F, 12.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 30).addBox(0.5F, -10.5F, 26.5F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-3.5F, -5.5F, -3.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-3.5F, -12.5F, 25.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-2.5F, -10.5F, 26.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 6).addBox(-2.5F, -3.5F, -2.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -3.5F, -4.5F));

        PartDefinition cushion = main.addOrReplaceChild("cushion", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = cushion.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 60).addBox(-4.5F, 0.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.8839F, 17.8839F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition bedDoubleMiddle() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(55, 30).addBox(-7.999F, -0.1161F, -6.8839F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).mirror().addBox(-7.0F, 0.8839F, -22.8839F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(7, 30).addBox(-8.0F, 0.8839F, -22.8839F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(7.0F, 0.8839F, -22.8839F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.8839F, 17.8839F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, -11.0F, -6.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(63, 0).addBox(7.0F, -11.0F, -6.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(61, 0).addBox(-8.0F, -11.0F, -6.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, -8.0F, -6.0F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(-8.0F, -8.0F, -6.0F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(7.0F, -8.0F, -6.0F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r1 = with_player.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 43).addBox(-7.999F, 4.25F, -4.5F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(55, 30).addBox(-7.999F, -1.75F, -4.5F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 8.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 60).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -13.0F, 11.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition frame = main.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -1.5F, -0.5F, 16.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-3.5F, -3.5F, -1.5F, 16.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(38, 30).mirror().addBox(-3.5F, -10.5F, 26.5F, 16.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 35).mirror().addBox(-3.5F, -5.5F, -3.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 30).mirror().addBox(-3.5F, -12.5F, 25.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -3.5F, -4.5F));

        PartDefinition cushion = main.addOrReplaceChild("cushion", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = cushion.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 60).addBox(-4.0F, 0.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.8839F, 17.8839F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition bedDoubleRight() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sheets = main.addOrReplaceChild("sheets", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition with_player = sheets.addOrReplaceChild("with_player", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, -11.0F, -6.0F, 14.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(-8.0F, -11.0F, -6.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, -8.0F, -6.0F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(5, 30).addBox(-8.0F, -8.0F, -6.0F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r1 = with_player.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 43).addBox(-7.999F, 4.25F, -4.5F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(55, 30).addBox(-7.999F, -1.75F, -4.5F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 8.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r2 = with_player.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 60).addBox(-9.0F, 0.0F, 0.25F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -13.0F, 11.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition without_player = sheets.addOrReplaceChild("without_player", CubeListBuilder.create().texOffs(55, 30).addBox(-7.999F, -0.1161F, -6.8839F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).mirror().addBox(-7.0F, 0.8839F, -22.8839F, 14.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(7, 30).addBox(-8.0F, 0.8839F, -22.8839F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.8839F, 17.8839F));

        PartDefinition frame = main.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -1.5F, -0.5F, 15.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-3.5F, -3.5F, -1.5F, 12.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(38, 30).mirror().addBox(-3.5F, -10.5F, 26.5F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 35).mirror().addBox(-3.5F, -5.5F, -3.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 30).mirror().addBox(-3.5F, -12.5F, 25.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 6).mirror().addBox(8.5F, -10.5F, 26.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(10, 6).mirror().addBox(8.5F, -3.5F, -2.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -3.5F, -4.5F));

        PartDefinition cushion = main.addOrReplaceChild("cushion", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = cushion.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 60).addBox(-4.5F, 0.0F, -2.25F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.8839F, 17.8839F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, SpecialBedModel::bedSingle);
        registry.register(LAYER_LOCATION_DOUBLE_LEFT, SpecialBedModel::bedDoubleLeft);
        registry.register(LAYER_LOCATION_DOUBLE_MIDDLE, SpecialBedModel::bedDoubleMiddle);
        registry.register(LAYER_LOCATION_DOUBLE_RIGHT, SpecialBedModel::bedDoubleRight);
    }
}
