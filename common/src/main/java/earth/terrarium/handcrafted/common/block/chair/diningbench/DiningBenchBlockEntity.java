package earth.terrarium.handcrafted.common.block.chair.diningbench;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DiningBenchBlockEntity extends BlockEntity {
    public DiningBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.DINING_BENCH.get(), blockPos, blockState);
    }
}
