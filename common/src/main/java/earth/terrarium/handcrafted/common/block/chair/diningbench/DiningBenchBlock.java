package earth.terrarium.handcrafted.common.block.chair.diningbench;

import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.common.block.SittableBlock;
import earth.terrarium.handcrafted.common.block.property.DirectionalBlockSide;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class DiningBenchBlock extends SimpleEntityBlock implements SittableBlock {
    public static final EnumProperty<DirectionalBlockSide> DINING_BENCH_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);
    public static final VoxelShape X_AXIS_SHAPE = Block.box(3, 0, 0, 13, 9, 16);
    public static final VoxelShape Z_AXIS_SHAPE = Block.box(0, 0, 3, 16, 9, 13);

    public DiningBenchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(DINING_BENCH_SHAPE, DirectionalBlockSide.SINGLE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DiningBenchBlockEntity(pos, state);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(FACING).getAxis() == Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DINING_BENCH_SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.sitOn(level, pos, player, null)) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME_PARTIAL;
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(DINING_BENCH_SHAPE, getShape(this, state.getValue(FACING), level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(DINING_BENCH_SHAPE, getShape(this, blockState.getValue(FACING), context.getLevel(), blockPos));
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return new AABB(0, 0, 0, 1, 0.5, 1);
    }

    public static DirectionalBlockSide getShape(Block block, Direction direction, BlockGetter level, BlockPos pos) {
        BlockState blockState3 = level.getBlockState(pos.relative(direction.getClockWise()));
        BlockState blockState4 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        boolean check1 = blockState3.is(block) && blockState3.getValue(DiningBenchBlock.FACING) != direction;
        boolean check2 = blockState4.is(block) && blockState4.getValue(DiningBenchBlock.FACING) != direction;
        if (!blockState3.is(block) && !blockState4.is(block)) {
            return DirectionalBlockSide.SINGLE;
        } else if (check1 && blockState4.is(block)) {
            return DirectionalBlockSide.RIGHT;
        } else if (check2 && blockState3.is(block)) {
            return DirectionalBlockSide.LEFT;
        } else if (check1) {
            return DirectionalBlockSide.SINGLE;
        } else if (check2) {
            return DirectionalBlockSide.SINGLE;
        } else if (!blockState3.is(block)) {
            return DirectionalBlockSide.RIGHT;
        } else if (!blockState4.is(block)) {
            return DirectionalBlockSide.LEFT;
        } else {
            return DirectionalBlockSide.MIDDLE;
        }
    }
}
