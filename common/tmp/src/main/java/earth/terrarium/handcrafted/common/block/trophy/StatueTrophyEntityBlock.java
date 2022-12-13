package earth.terrarium.handcrafted.common.block.trophy;

import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class StatueTrophyEntityBlock extends SimpleEntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 32, 16);

    public StatueTrophyEntityBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return SHAPE.move(offset.x(), offset.y(), offset.z());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StatueTrophyBlockEntity(pos, state);
    }
}
