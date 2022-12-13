package earth.terrarium.handcrafted.client.block.chair.bench;

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
public class BenchModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_INVERTED_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_main"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_right"), "main");

    public BenchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition benchSingleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(16, 0).addBox(5.0F, -14.0F, -8.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(5.0F, -16.0F, 7.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).mirror().addBox(-8.0F, -14.0F, -8.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 7.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-7.0F, -13.5F, -0.5F, 14.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 6.5F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.5F, -14.5F, -0.5F, 3.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 0).addBox(11.5F, -14.5F, -0.5F, 3.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -15.5F, 6.5F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -2.5F, 0.0F, 15.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -12.5F, -8.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(24, 0).addBox(11.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -14.0F, -7.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r5 = main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -2.5F, 0.0F, 15.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -12.5F, -8.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r6 = main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 0).addBox(-5.0F, -17.0F, 0.0F, 10.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -7.5F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-8.0F, -14.0F, -8.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(65, 52).addBox(-7.0F, -10.0F, 7.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-3.0F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -14.0F, -7.0F, 0.1298F, 0.017F, -0.1298F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 37).addBox(-7.5F, -13.5F, -0.5F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -9.5F, 6.5F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-2.5F, 0.0F, -1.5F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -14.0F, -7.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 34).mirror().addBox(-7.5F, -17.0F, 0.0F, 15.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -13.0F, -7.5F, 3.0107F, 0.0F, 3.1416F));

        PartDefinition cube_r5 = main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(32, 34).mirror().addBox(-7.5F, -17.0F, 0.0F, 15.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, -13.0F, 0.5F, 0.0F, 1.5708F, -0.1309F));

        PartDefinition cube_r6 = main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.0F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -14.0F, -5.0F, 1.5708F, 1.4399F, 1.4399F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchInvertedCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(8, 16).addBox(-9.0F, -14.0F, -9.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(5.0F, -9.0F, 5.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(94, 35).addBox(-0.5F, -14.5F, -0.5F, 15.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -9.5F, 6.5F, 0.0F, 1.5708F, -1.5708F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -17.0F, -2.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -14.0F, -7.0F, 0.0628F, 0.0F, -0.0628F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(16, 0).addBox(5.0F, -14.0F, -8.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(5.0F, -16.0F, 7.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(82, 5).addBox(-8.0F, -7.5F, 0.5F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -10.5F, 0.5F, 1.5708F, 0.0F, 3.1416F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 20).addBox(0.75F, -17.0F, 0.0F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.75F, -13.0F, -7.5F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -14.0F, -7.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 0).addBox(-33.5F, -14.5F, -0.5F, 3.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.5F, -15.5F, 6.5F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchMiddleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(94, 20).addBox(-15.5F, -13.5F, -0.5F, 16.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -9.5F, 6.5F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 17).addBox(-15.25F, -17.0F, 0.0F, 16.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.25F, -13.0F, -7.5F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-8.0F, -14.0F, -8.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 7.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(82, 5).mirror().addBox(-9.0F, 24.5F, 0.5F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -10.5F, -31.5F, 1.5708F, 0.0F, 3.1416F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-46.5F, 17.5F, -0.5F, 3.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(38.5F, -15.5F, -25.5F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -14.0F, -7.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(68, 20).mirror().addBox(-13.0F, -17.0F, 0.0F, 13.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -13.0F, -7.5F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, BenchModel::benchSingleLayer);
        registry.register(LAYER_LOCATION_CORNER, BenchModel::benchCornerLayer);
        registry.register(LAYER_LOCATION_INVERTED_CORNER, BenchModel::benchInvertedCornerLayer);
        registry.register(LAYER_LOCATION_LEFT, BenchModel::benchLeftLayer);
        registry.register(LAYER_LOCATION_MIDDLE, BenchModel::benchMiddleLayer);
        registry.register(LAYER_LOCATION_RIGHT, BenchModel::benchRightLayer);
    }
}
