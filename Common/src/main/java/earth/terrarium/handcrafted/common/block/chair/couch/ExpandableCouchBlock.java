package earth.terrarium.handcrafted.common.block.chair.couch;

import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.common.block.property.CouchShape;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

@MethodsReturnNonnullByDefault
public abstract class ExpandableCouchBlock extends SimpleEntityBlock {
    public static final EnumProperty<CouchShape> COUCH_SHAPE = EnumProperty.create("shape", CouchShape.class);

    public ExpandableCouchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(COUCH_SHAPE, CouchShape.SINGLE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        Direction direction = state.getValue(FACING);
        CouchShape couchShape = state.getValue(COUCH_SHAPE);
        switch (mirror) {
            case LEFT_RIGHT -> {
                if (direction.getAxis() == Direction.Axis.Z) {
                    var shape = switch (couchShape) {
                        case OUTER_LEFT -> CouchShape.OUTER_RIGHT;
                        case OUTER_RIGHT -> CouchShape.OUTER_LEFT;
                        case INNER_LEFT -> CouchShape.INNER_RIGHT;
                        case INNER_RIGHT -> CouchShape.INNER_LEFT;
                        default -> couchShape;
                    };
                    return state.rotate(Rotation.CLOCKWISE_180).setValue(COUCH_SHAPE, shape);
                }
            }
            case FRONT_BACK -> {
                if (direction.getAxis() == Direction.Axis.X) {
                    var shape = switch (couchShape) {
                        case OUTER_LEFT -> CouchShape.OUTER_RIGHT;
                        case OUTER_RIGHT -> CouchShape.OUTER_LEFT;
                        case INNER_LEFT -> CouchShape.INNER_LEFT;
                        case INNER_RIGHT -> CouchShape.INNER_RIGHT;
                        default -> couchShape;
                    };
                    return state.rotate(Rotation.CLOCKWISE_180).setValue(COUCH_SHAPE, shape);
                }
            }
        }

        return super.mirror(state, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUCH_SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(COUCH_SHAPE, getCouchShape(state, level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(COUCH_SHAPE, getCouchShape(blockState, context.getLevel(), blockPos));
    }

    private boolean canTakeShape(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
        BlockState blockState = level.getBlockState(pos.relative(face));
        return !blockState.is(this) || blockState.getValue(FACING) != state.getValue(FACING);
    }

    private CouchShape getCouchShape(BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockState = level.getBlockState(pos.relative(direction));
        if (blockState.is(this)) {
            Direction direction2 = blockState.getValue(FACING);
            if (direction2.getAxis() != state.getValue(FACING).getAxis() && canTakeShape(state, level, pos, direction2.getOpposite())) {
                if (direction2 == direction.getCounterClockWise()) {
                    return CouchShape.OUTER_LEFT;
                }

                return CouchShape.OUTER_RIGHT;
            }
        }

        BlockState blockState2 = level.getBlockState(pos.relative(direction.getOpposite()));
        if (blockState2.is(this)) {
            Direction direction3 = blockState2.getValue(FACING);
            if (direction3.getAxis() != state.getValue(FACING).getAxis() && canTakeShape(state, level, pos, direction3)) {
                if (direction3 == direction.getCounterClockWise()) {
                    return CouchShape.INNER_LEFT;
                }

                return CouchShape.INNER_RIGHT;
            }
        }

        BlockState blockState3 = level.getBlockState(pos.relative(direction.getClockWise()));
        BlockState blockState4 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        if (!blockState3.is(this) && !blockState4.is(this)) {
            return CouchShape.SINGLE;
        } else if (!blockState3.is(this)) {
            return CouchShape.RIGHT;
        } else if (!blockState4.is(this)) {
            return CouchShape.LEFT;
        } else {
            return CouchShape.MIDDLE;
        }
    }
}
