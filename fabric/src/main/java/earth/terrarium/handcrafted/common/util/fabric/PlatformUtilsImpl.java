package earth.terrarium.handcrafted.common.util.fabric;

import earth.terrarium.handcrafted.common.util.PlatformUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlatformUtilsImpl {
    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(PlatformUtils.BlockEntityFactory<E> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory::create, blocks).build(null);
    }
}