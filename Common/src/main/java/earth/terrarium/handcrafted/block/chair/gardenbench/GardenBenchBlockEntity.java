package earth.terrarium.handcrafted.block.chair.gardenbench;

import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GardenBenchBlockEntity extends BlockEntity {
    public GardenBenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.GARDEN_BENCH.get(), blockPos, blockState);
    }
}