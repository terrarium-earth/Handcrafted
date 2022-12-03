package earth.terrarium.handcrafted.block.chair.gardenbench;

import earth.terrarium.handcrafted.block.chair.ExpandableCouchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GardenBenchBlock extends ExpandableCouchBlock {

    public GardenBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GardenBenchBlockEntity(pos, state);
    }
}
