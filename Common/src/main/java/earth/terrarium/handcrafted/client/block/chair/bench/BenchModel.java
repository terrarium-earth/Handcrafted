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

@Environment(EnvType.CLIENT)
public class BenchModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_INVERTED_CORNER = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_inverted_corner"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "bench_right"), "main");

    public BenchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition benchSingleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).addBox(11.5F, 0.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).mirror().addBox(-1.5F, 0.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 31).addBox(11.5F, -2.0F, 14.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(11.5F, -2.0F, -1.0F, 3.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).mirror().addBox(13.0F, -1.0F, -1.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 33).addBox(0.0F, -1.0F, -1.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, 4.0F, 0.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).mirror().addBox(-1.5F, -2.0F, -1.0F, 3.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 31).mirror().addBox(-1.5F, -2.0F, 14.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 10.0F, -7.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(21, 15).addBox(1.5F, -15.0F, -0.5F, 10.0F, 15.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(11.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchCornerLayer() {
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

    public static LayerDefinition benchInvertedCornerLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition inverted_corner = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 55).addBox(-9.0F, 0.0F, -41.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 73).addBox(5.0F, 5.0F, -27.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(44, 57).mirror().addBox(-8.0F, 4.0F, -39.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(1, 57).mirror().addBox(-7.0F, 4.0F, -40.0F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-32.0F, 10.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        inverted_corner.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 55).mirror().addBox(-2.0F, -15.0F, -2.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 0.0F, -39.0F, 0.0436F, 0.0038F, -0.0435F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).addBox(11.5F, 0.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 31).addBox(11.5F, -2.0F, 14.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(11.5F, -2.0F, -1.0F, 3.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).mirror().addBox(13.0F, -1.0F, -1.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(57, 0).addBox(-1.5F, 4.0F, 0.0F, 15.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 10.0F, -7.0F));

        left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(41, 15).addBox(-14.5F, -15.0F, -0.5F, 13.0F, 15.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchMiddleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition middle = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(57, 31).mirror().addBox(-1.5F, 4.0F, 0.0F, 16.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 10.0F, -7.0F));

        middle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(67, 15).mirror().addBox(-14.5F, -15.0F, -0.5F, 16.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition benchRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, 0.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 33).addBox(0.0F, -1.0F, -1.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(57, 0).mirror().addBox(-0.5F, 4.0F, 0.0F, 15.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 15).mirror().addBox(-1.5F, -2.0F, -1.0F, 3.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 31).mirror().addBox(-1.5F, -2.0F, 14.0F, 3.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 10.0F, -7.0F));

        right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-1.5F, -14.0F, -1.0F, 3.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(41, 15).mirror().addBox(1.5F, -15.0F, -0.5F, 13.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

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
