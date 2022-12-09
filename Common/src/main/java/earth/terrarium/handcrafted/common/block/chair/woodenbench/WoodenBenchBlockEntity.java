package earth.terrarium.handcrafted.common.block.chair.woodenbench;

import earth.terrarium.handcrafted.common.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WoodenBenchBlockEntity extends CushionBenchBlockEntity {
    public WoodenBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.WOODEN_BENCH.get(), blockPos, blockState);
    }
}
