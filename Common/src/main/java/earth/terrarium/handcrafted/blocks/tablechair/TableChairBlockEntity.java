package earth.terrarium.handcrafted.blocks.tablechair;

import earth.terrarium.handcrafted.blocks.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TableChairBlockEntity extends CushionBenchBlockEntity {
    public TableChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.TABLE_CHAIR.get(), blockPos, blockState);
    }
}