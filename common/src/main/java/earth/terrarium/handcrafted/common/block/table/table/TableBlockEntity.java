package earth.terrarium.handcrafted.common.block.table.table;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TableBlockEntity extends ItemHoldingBlockEntity {

    public TableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.TABLE.get(), blockPos, blockState);
    }
}
