package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ShelfBlockEntity extends ItemHoldingBlockEntity {
    public ShelfBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.SHELF.get(), blockPos, blockState);
    }
}
