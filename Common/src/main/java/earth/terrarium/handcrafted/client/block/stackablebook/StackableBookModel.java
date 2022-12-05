package earth.terrarium.handcrafted.client.block.stackablebook;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.client.BaseModel;
import earth.terrarium.handcrafted.client.HandcraftedClient;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class StackableBookModel extends BaseModel {
    public static final ModelLayerLocation LAYER_LOCATION_BOOK_1 = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "book_1"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_BOOK_2 = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "book_2"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_BOOK_3 = new ModelLayerLocation(new ResourceLocation(Handcrafted.MOD_ID, "book_3"), "main");

    public StackableBookModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition book1() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition book = main.addOrReplaceChild("book", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

        book.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-6.0F, 4.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -2.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static LayerDefinition book2() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition book2 = main.addOrReplaceChild("book2", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

        book2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-6.0F, 4.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F))
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -2.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static LayerDefinition book3() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition book4 = main.addOrReplaceChild("book4", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition cube_r1 = book4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-6.0F, 4.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(2.0F, -5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F))
                .texOffs(0, 18).addBox(-4.0F, -5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F))
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -2.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static void register(HandcraftedClient.LayerDefinitionRegistry registry) {
        registry.register(LAYER_LOCATION_BOOK_1, StackableBookModel::book1);
        registry.register(LAYER_LOCATION_BOOK_2, StackableBookModel::book2);
        registry.register(LAYER_LOCATION_BOOK_3, StackableBookModel::book3);
    }
}
