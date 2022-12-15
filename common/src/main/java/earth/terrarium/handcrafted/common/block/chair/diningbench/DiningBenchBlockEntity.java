package earth.terrarium.handcrafted.common.block.chair.diningbench;

import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DiningBenchBlockEntity extends BlockEntity {
    public DiningBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.DINING_BENCH.get(), blockPos, blockState);
    }
}
