package earth.terrarium.handcrafted.common.block.table.table;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TableBlockEntity extends ItemHoldingBlockEntity {

    public TableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.TABLE.get(), blockPos, blockState);
    }
}
