package earth.terrarium.handcrafted.common.block.table.side_table;

import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SideTableBlockEntity extends TableBlockEntity {
    public SideTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SIDE_TABLE.get(), blockPos, blockState);
    }
}
