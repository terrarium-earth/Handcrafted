package earth.terrarium.handcrafted.client.block.chair.tablebench;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class TableBenchModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_SINGLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table_bench_single"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_LEFT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table_bench_left"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_MIDDLE = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table_bench_middle"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_RIGHT = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table_bench_right"), "main");

    public TableBenchModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition benchSingleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bench_single = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 13).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -9.0F, -5.0F, 16.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bench_single.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-7.0F, -6.0F, -4.0F, 3.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4618F, 0.3258F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r2 = bench_single.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2577F, -3.0986F, 0.0F, 0.0F, 0.0F, -0.0873F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition benchLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bench_left = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 34).addBox(-8.0F, -3.0F, -3.0F, 14.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -9.0F, -5.0F, 16.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bench_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2577F, -3.0986F, 0.0F, 0.0F, 0.0F, -0.0873F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition benchMiddleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bench_middle = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(20, 21).addBox(-8.0F, -3.0F, -3.0F, 16.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -9.0F, -5.0F, 16.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition benchRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bench_right = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0F, -3.0F, -3.0F, 14.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -9.0F, -5.0F, 16.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bench_right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-7.0F, -6.0F, -4.0F, 3.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4618F, 0.3258F, 0.0F, 0.0F, 0.0F, 0.0873F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_SINGLE, TableBenchModel::benchSingleLayer);
        registry.register(LAYER_LOCATION_LEFT, TableBenchModel::benchLeftLayer);
        registry.register(LAYER_LOCATION_MIDDLE, TableBenchModel::benchMiddleLayer);
        registry.register(LAYER_LOCATION_RIGHT, TableBenchModel::benchRightLayer);
    }
}
