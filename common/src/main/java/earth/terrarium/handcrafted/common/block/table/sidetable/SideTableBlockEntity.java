package earth.terrarium.handcrafted.common.block.table.sidetable;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SideTableBlockEntity extends ItemHoldingBlockEntity {
    public SideTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.SIDE_TABLE.get(), blockPos, blockState);
    }
}
