package earth.terrarium.handcrafted.common.block.chair.chair;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ChairBlockEntity extends ItemHoldingBlockEntity {
    public ChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CHAIR.get(), blockPos, blockState);
    }
}