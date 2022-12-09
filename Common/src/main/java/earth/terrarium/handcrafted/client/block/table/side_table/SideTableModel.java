package earth.terrarium.handcrafted.client.block.table.side_table;

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
public class SideTableModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "side_table"), "main");

    public SideTableModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition tableLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition overlay = main.addOrReplaceChild("overlay", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, -8.0F));

        PartDefinition overlay_side_west = overlay.addOrReplaceChild("overlay_side_west", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -16.0F, 1.99F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_north = overlay.addOrReplaceChild("overlay_side_north", CubeListBuilder.create().texOffs(32, 32).addBox(-14.0F, -16.0F, 1.99F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_top = overlay.addOrReplaceChild("overlay_top", CubeListBuilder.create().texOffs(4, 40).addBox(-14.0F, -16.01F, 2.0F, 12.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_south = overlay.addOrReplaceChild("overlay_side_south", CubeListBuilder.create().texOffs(0, 32).addBox(-14.0F, -16.0F, 14.01F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition overlay_side_east = overlay.addOrReplaceChild("overlay_side_east", CubeListBuilder.create().texOffs(32, 20).addBox(-14.0F, -16.0F, 1.99F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition table = main.addOrReplaceChild("table", CubeListBuilder.create().texOffs(12, 4).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(16, 20).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.0F, -12.0F, 2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -12.0F, -5.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.0F, -12.0F, -5.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -12.0F, 2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION, SideTableModel::tableLayer);
    }
}
