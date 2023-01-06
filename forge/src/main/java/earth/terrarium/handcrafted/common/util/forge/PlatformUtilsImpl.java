package earth.terrarium.handcrafted.common.util.forge;

import earth.terrarium.handcrafted.common.util.PlatformUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlatformUtilsImpl {
    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(PlatformUtils.BlockEntityFactory<E> factory, Block... blocks) {
        return BlockEntityType.Builder.of(factory::create, blocks).build(null);
    }
}