package earth.terrarium.handcrafted.block.chair.woodengardenbench;

import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WoodenGardenBenchBlockEntity extends CushionBenchBlockEntity {
    public WoodenGardenBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.WOODEN_GARDEN_BENCH.get(), blockPos, blockState);
    }
}
