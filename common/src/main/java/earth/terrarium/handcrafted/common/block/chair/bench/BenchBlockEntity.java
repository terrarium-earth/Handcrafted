package earth.terrarium.handcrafted.common.block.chair.bench;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BenchBlockEntity extends BlockEntity {
    public BenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.METAL_BENCH.get(), blockPos, blockState);
    }
}