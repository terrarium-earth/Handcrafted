package earth.terrarium.handcrafted.client.block.table.table;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class TableModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "table"), "main");

    public TableModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition tableLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition overlay = main.addOrReplaceChild("overlay", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_north = overlay.addOrReplaceChild("overlay_side_north", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -16.0F, -8.01F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_top = overlay.addOrReplaceChild("overlay_top", CubeListBuilder.create().texOffs(0, 40).addBox(-8.0F, -16.01F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_south = overlay.addOrReplaceChild("overlay_side_south", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -16.0F, 8.01F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_west = overlay.addOrReplaceChild("overlay_side_west", CubeListBuilder.create().texOffs(16, 16).addBox(8.001F, -16.0F, -7.99F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_east = overlay.addOrReplaceChild("overlay_side_east", CubeListBuilder.create().texOffs(32, 16).addBox(-8.001F, -16.0F, -7.99F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition table = main.addOrReplaceChild("table", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition southwest_leg = table.addOrReplaceChild("southwest_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -12.0F, 4.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition northwest_leg = table.addOrReplaceChild("northwest_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -12.0F, -7.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition northeast_leg = table.addOrReplaceChild("northeast_leg", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -12.0F, -7.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition southeast_leg = table.addOrReplaceChild("southeast_leg", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -12.0F, 4.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION, TableModel::tableLayer);
    }
}
