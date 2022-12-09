package earth.terrarium.handcrafted.common.block.trophy;

import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StatueTrophyBlockEntity extends BlockEntity {
    public StatueTrophyBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.STATUE.get(), blockPos, blockState);
    }
}
