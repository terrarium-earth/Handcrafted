package earth.terrarium.handcrafted.common.block.chair.chair;

import earth.terrarium.handcrafted.common.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ChairBlockEntity extends CushionBenchBlockEntity {
    public ChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CHAIR.get(), blockPos, blockState);
    }
}