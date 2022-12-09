package earth.terrarium.handcrafted.common.block.table.desk;

import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class DeskBlockEntity extends TableBlockEntity {
    public DeskBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.DESK.get(), blockPos, blockState);
    }
}
