package earth.terrarium.handcrafted.common.blocks.base;

import earth.terrarium.handcrafted.common.blocks.base.properties.ModularSeatProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public abstract class ModularSeatBlock extends HorizontalDirectionalBlock implements SittableBlock, SimpleWaterloggedBlock {
    public static final EnumProperty<ModularSeatProperty> SHAPE = EnumProperty.create("shape", ModularSeatProperty.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ModularSeatBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(SHAPE, ModularSeatProperty.SINGLE)
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        Direction direction = state.getValue(FACING);
        ModularSeatProperty couchShape = state.getValue(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT -> {
                if (direction.getAxis() == Direction.Axis.Z) {
                    var shape = switch (couchShape) {
                        case OUTER_LEFT -> ModularSeatProperty.OUTER_RIGHT;
                        case OUTER_RIGHT -> ModularSeatProperty.OUTER_LEFT;
                        case INNER_LEFT -> ModularSeatProperty.INNER_RIGHT;
                        case INNER_RIGHT -> ModularSeatProperty.INNER_LEFT;
                        default -> couchShape;
                    };
                    return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, shape);
                }
            }
            case FRONT_BACK -> {
                if (direction.getAxis() == Direction.Axis.X) {
                    var shape = switch (couchShape) {
                        case OUTER_LEFT -> ModularSeatProperty.OUTER_RIGHT;
                        case OUTER_RIGHT -> ModularSeatProperty.OUTER_LEFT;
                        case INNER_LEFT -> ModularSeatProperty.INNER_LEFT;
                        case INNER_RIGHT -> ModularSeatProperty.INNER_RIGHT;
                        default -> couchShape;
                    };
                    return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, shape);
                }
            }
        }

        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(SHAPE, getShape(state, level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.sitOn(level, pos, player, state.getValue(FACING))) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME_PARTIAL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);
        BlockState state = this.defaultBlockState()
            .setValue(FACING, context.getHorizontalDirection().getOpposite())
            .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return state.setValue(SHAPE, getShape(state, context.getLevel(), pos));
    }

    public boolean canTakeShape(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
        BlockState other = level.getBlockState(pos.relative(face));
        return !other.is(this) || other.getValue(FACING) != state.getValue(FACING);
    }

    public ModularSeatProperty getShape(BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = state.getValue(FACING);

        BlockState state1 = level.getBlockState(pos.relative(direction.getOpposite()));
        if (state1.is(this)) {
            Direction dir = state1.getValue(FACING);
            if (dir.getAxis() != state.getValue(FACING).getAxis() && canTakeShape(state, level, pos, dir)) {
                return dir == direction.getCounterClockWise() ?
                    ModularSeatProperty.OUTER_LEFT :
                    ModularSeatProperty.OUTER_RIGHT;
            }
        }

        BlockState state2 = level.getBlockState(pos.relative(direction));
        if (state2.is(this)) {
            Direction dir = state2.getValue(FACING);
            if (dir.getAxis() != state.getValue(FACING).getAxis() && canTakeShape(state, level, pos, dir.getOpposite())) {
                return dir == direction.getCounterClockWise() ?
                    ModularSeatProperty.INNER_LEFT :
                    ModularSeatProperty.INNER_RIGHT;
            }
        }

        BlockState state3 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        BlockState state4 = level.getBlockState(pos.relative(direction.getClockWise()));
        if (!state3.is(this) && !state4.is(this)) {
            return ModularSeatProperty.SINGLE;
        } else if (!state3.is(this)) {
            return ModularSeatProperty.RIGHT;
        } else if (!state4.is(this)) {
            return ModularSeatProperty.LEFT;
        } else {
            return ModularSeatProperty.MIDDLE;
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
