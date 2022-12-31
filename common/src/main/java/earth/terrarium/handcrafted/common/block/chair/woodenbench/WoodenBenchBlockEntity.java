package earth.terrarium.handcrafted.common.block.chair.woodenbench;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WoodenBenchBlockEntity extends ItemHoldingBlockEntity {
    public WoodenBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.BENCH.get(), blockPos, blockState);
    }
}
