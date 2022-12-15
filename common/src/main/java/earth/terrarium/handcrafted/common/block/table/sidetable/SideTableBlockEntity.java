package earth.terrarium.handcrafted.common.block.table.sidetable;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SideTableBlockEntity extends ItemHoldingBlockEntity {
    public SideTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SIDE_TABLE.get(), blockPos, blockState);
    }
}
