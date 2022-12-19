package earth.terrarium.handcrafted.common.block.trophy;

import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class StatueTrophyBlockEntity extends BlockEntity {
    public StatueTrophyBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public static StatueTrophyBlockEntity ofEntity(BlockPos blockPos, BlockState blockState) {
        return new StatueTrophyBlockEntity(ModBlockEntities.STATUE_ENTITY.get(), blockPos, blockState);
    }

    public static StatueTrophyBlockEntity ofBlock(BlockPos blockPos, BlockState blockState) {
        return new StatueTrophyBlockEntity(ModBlockEntities.STATUE_BLOCK.get(), blockPos, blockState);
    }
}