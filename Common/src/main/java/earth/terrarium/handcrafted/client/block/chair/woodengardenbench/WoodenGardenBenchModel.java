package earth.terrarium.handcrafted.client.block.chair.woodengardenbench;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class WoodenGardenBenchModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_INVERTED_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_inverted_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "wooden_garden_bench_right"), "main");

    public WoodenGardenBenchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition benchSingleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(57, 96).addBox(-67.0F, -11.0F, -8.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(57, 96).mirror().addBox(-80.0F, -11.0F, -8.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(92, 82).addBox(-67.0F, -13.0F, 5.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(92, 82).mirror().addBox(-80.0F, -13.0F, 5.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 84).addBox(-78.5F, -13.0F, -6.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 84).addBox(-65.5F, -13.0F, -6.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(-78.0F, -7.0F, -7.0F, 12.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(38, 52).addBox(-80.0F, -11.0F, -7.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(72.0F, 21.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(90, 35).addBox(-5.0F, -14.119F, -6.0861F, 10.0F, 14.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(69, 96).mirror().addBox(-8.0F, -14.7189F, -7.4812F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(69, 96).addBox(5.0F, -14.7189F, -7.4812F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-72.0F, -10.8722F, -0.4633F, 0.1309F, 0.0F, 0.0F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(0, 80).addBox(-77.0F, 8.5F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.5F, 0.0F));

        PartDefinition cube_r2 = with_cushions.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 80).addBox(-5.0F, 2.7594F, -10.475F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-72.0F, 6.6278F, -0.4633F, -1.4399F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(57, 96).addBox(-48.0F, -11.0F, -8.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(38, 52).addBox(-45.0F, -11.0F, -7.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).addBox(-47.0F, -7.0F, -7.0F, 15.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(78, 0).addBox(-47.0F, -7.0F, 7.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(40.0F, 21.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 52).addBox(-6.5F, -3.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-47.0F, -8.0F, 1.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 82).addBox(-8.0F, -14.0442F, -6.4316F, 16.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.0F, -11.0F, 0.0F, 0.0F, 1.5708F, -0.1309F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(60, 82).addBox(-8.0F, -14.0442F, -6.4316F, 16.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.0F, -11.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(69, 96).addBox(-3.0F, -14.0F, -3.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.0F, -11.0F, -5.0F, 0.1309F, 0.0F, -0.1309F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(52, 52).addBox(-46.0F, 8.5F, -6.0F, 14.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(88, 67).addBox(-46.0F, 8.5F, 6.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.5F, 0.0F));

        PartDefinition cube_r5 = with_cushions.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 67).addBox(-6.5F, -1.5F, -7.0F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.296F, 3.7471F, 1.5257F, 0.0F, 1.5708F, 1.4399F));

        PartDefinition cube_r6 = with_cushions.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 67).addBox(-5.0F, 4.4F, -4.35F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.0F, 0.3497F, 0.2333F, -1.4399F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchInvertedCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(57, 96).addBox(-8.0F, -11.0F, -40.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(4.0F, -5.0F, -28.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-7.0F, -7.0F, -40.0F, 14.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(30, 81).addBox(-8.0F, -7.0F, -39.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.0F, 21.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(69, 96).addBox(-3.0F, -14.0F, -3.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, -37.0F, 0.1309F, 0.0F, -0.1309F));

        PartDefinition with_cushion = main.addOrReplaceChild("with_cushions", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -48.0F));

        PartDefinition cube_r2 = with_cushion.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(88, 67).addBox(11.5F, -2.5F, 10.5F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 52).addBox(11.5F, -2.5F, -1.5F, 14.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -6.5F, 20.5F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(38, 52).addBox(24.0F, -11.0F, -7.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(44, 19).mirror().addBox(24.0F, -7.0F, -7.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(92, 82).addBox(37.0F, -13.0F, 5.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(57, 96).addBox(37.0F, -11.0F, -8.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 84).addBox(38.5F, -13.0F, -6.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-32.0F, 21.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(69, 96).addBox(-1.0F, -14.0F, -3.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, -11.0F, -5.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 19).addBox(-8.0F, -13.0F, 1.5F, 13.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.0F, -11.0F, -8.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, 8.1503F, -6.2333F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(32.0F, -17.1503F, 0.2333F));

        PartDefinition cube_r3 = with_cushions.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 67).addBox(-8.0F, 4.4F, -3.35F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -1.4399F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchMiddleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -7.0F, -7.0F, 16.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(8.0F, -11.0F, -7.0F, 16.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, 21.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 82).addBox(-8.0F, -13.0F, 1.5F, 16.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -11.0F, -8.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(48, 4).addBox(8.0F, -9.0F, -6.0F, 16.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = with_cushions.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 37).addBox(-8.0F, 4.4F, -3.35F, 16.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -18.1503F, 0.2333F, -1.4399F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(57, 96).mirror().addBox(-8.0F, -11.0F, -8.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(92, 82).mirror().addBox(-8.0F, -13.0F, 5.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 84).addBox(-6.5F, -13.0F, -6.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(38, 52).addBox(-5.0F, -11.0F, -7.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(44, 19).addBox(-6.0F, -7.0F, -7.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(69, 96).mirror().addBox(-2.0F, -14.0F, -3.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -11.0F, -5.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 19).addBox(-5.0F, -14.0F, 1.5F, 13.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0086F, -7.8695F, 0.1309F, 0.0F, 0.0F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(0, 65).addBox(-5.0F, -9.0F, -6.0F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = with_cushions.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 67).addBox(-5.0F, 4.4F, -3.35F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.1503F, 0.2333F, -1.4399F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, WoodenGardenBenchModel::benchSingleLayer);
        registry.register(LAYER_LOCATION_CORNER, WoodenGardenBenchModel::benchCornerLayer);
        registry.register(LAYER_LOCATION_INVERTED_CORNER, WoodenGardenBenchModel::benchInvertedCornerLayer);
        registry.register(LAYER_LOCATION_LEFT, WoodenGardenBenchModel::benchLeftLayer);
        registry.register(LAYER_LOCATION_MIDDLE, WoodenGardenBenchModel::benchMiddleLayer);
        registry.register(LAYER_LOCATION_RIGHT, WoodenGardenBenchModel::benchRightLayer);
    }
}
