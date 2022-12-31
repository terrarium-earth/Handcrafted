package earth.terrarium.handcrafted.common.registry.fabric;

import earth.terrarium.handcrafted.common.registry.ModRegistryHelpers;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModRegistryHelpersImpl {
    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(ModRegistryHelpers.BlockEntityFactory<E> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory::create, blocks).build(null);
    }
}
