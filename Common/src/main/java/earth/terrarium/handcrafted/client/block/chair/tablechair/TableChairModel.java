package earth.terrarium.handcrafted.client.block.chair.tablechair;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class TableChairModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table_chair"), "main");

    public TableChairModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition singleLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -9.0F, -7.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(4.0F, -14.0F, 5.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 15).addBox(-5.0F, -13.9052F, 6.1705F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(27, 7).addBox(-6.0F, -9.0F, -4.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(27, 7).addBox(6.0F, -9.0F, -4.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(28, 16).addBox(-4.0F, -9.0F, -7.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-7.0F, -14.0F, 5.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -9.0F, -7.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 16).addBox(-5.0F, -9.0F, 1.0F, 10.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.9772F, 5.5229F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -10.0F, -1.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.8976F, 6.3448F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 14).addBox(-2.0F, -10.0F, -1.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -17.8976F, 6.3448F, -0.0873F, 0.0F, 0.0F));

        PartDefinition base = main.addOrReplaceChild("base", CubeListBuilder.create().texOffs(2, 0).addBox(-6.0F, -9.0F, -5.99F, 12.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition with_cushions = main.addOrReplaceChild("with_cushions", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, -5.0F, 10.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION, TableChairModel::singleLayer);
    }
}
