package earth.terrarium.handcrafted.common.block.crockery;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CrockeryBlockEntity extends ItemHoldingBlockEntity {
    public CrockeryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CROCKERY.get(), blockPos, blockState);
    }
}
