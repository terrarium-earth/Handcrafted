package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blocks.base.ModularSeatBlock;
import earth.terrarium.handcrafted.common.blocks.base.properties.ModularSeatProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class MetalBenchBlock extends ModularSeatBlock {
    public static final AABB SEAT = new AABB(0, 0, 0, 1, 0.5, 1);
    public static final VoxelShape VOXEL_SHAPE = Block.box(0, 0, 0, 16, 10, 16);

    public MetalBenchBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(SHAPE, ModularSeatProperty.SINGLE)
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(WATERLOGGED, false)
        );
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return SEAT;
    }
}
