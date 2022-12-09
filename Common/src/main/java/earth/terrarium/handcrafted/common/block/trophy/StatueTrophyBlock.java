package earth.terrarium.handcrafted.common.block.trophy;

import earth.terrarium.handcrafted.common.block.SimpleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StatueTrophyBlock extends SimpleBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 32, 16);

    public StatueTrophyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return SHAPE.move(offset.x(), offset.y(), offset.z());
    }
}
