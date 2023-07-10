package earth.terrarium.handcrafted.client.block.statue;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class StatueModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_WITCH = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "statue_trophy_witch"), "main");

    public StatueModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition witch() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 79).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
            .texOffs(28, 28).addBox(-4.0F, -6.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(28, 28).addBox(0.0F, -6.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(0, 18).addBox(-4.0F, -22.0F, -2.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F))
            .texOffs(0, 0).addBox(-4.0F, -32.0F, -3.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
            .texOffs(0, 48).addBox(-5.0F, -34.0F, -4.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
            .texOffs(24, 0).addBox(-1.0F, -25.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0).addBox(0.0F, -24.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
            .texOffs(28, 18).addBox(-8.5F, -22.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(0, 80).addBox(-6.0F, -24.0F, -14.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 67).addBox(7.0F, -0.5F, -7.5F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.5F, 0.5F, -0.3927F, 0.0F, 0.0F));

        main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 112).addBox(-10.0F, -42.0F, 1.0F, 17.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 18).addBox(-8.501F, -24.0F, -11.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3751F, -9.9655F, -0.829F, 0.0F, 0.0F));

        main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 18).addBox(-4.0F, 27.0F, -1.001F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2874F, 3.9599F, 0.0F, 0.0F, 0.0F, -2.7053F));

        main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 18).addBox(18.0F, 8.0F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -1.789F));

        main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 79).addBox(-1.25F, -44.5F, -6.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 71).addBox(-3.25F, -42.5F, -8.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2181F, 0.0038F, 0.0435F));

        main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 60).addBox(-3.25F, -39.5F, -5.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 128);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_WITCH, StatueModel::witch);
    }
}
