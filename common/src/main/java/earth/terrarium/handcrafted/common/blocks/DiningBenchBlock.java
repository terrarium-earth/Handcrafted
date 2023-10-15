package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blocks.base.SittableBlock;
import earth.terrarium.handcrafted.common.blocks.base.properties.DirectionalBlockProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class DiningBenchBlock extends HorizontalDirectionalBlock implements SittableBlock, SimpleWaterloggedBlock {
    public static final EnumProperty<DirectionalBlockProperty> SHAPE = EnumProperty.create("shape", DirectionalBlockProperty.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape X_AXIS_SHAPE = Block.box(3, 0, 0, 13, 9, 16);
    public static final VoxelShape Z_AXIS_SHAPE = Block.box(0, 0, 3, 16, 9, 13);
    public static final AABB SEAT = new AABB(0, 0, 0, 1, 0.5, 1);

    public DiningBenchBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(SHAPE, DirectionalBlockProperty.SINGLE)
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.sitOn(level, pos, player, null)) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME_PARTIAL;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(FACING).getAxis() == net.minecraft.core.Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return SEAT;
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(SHAPE, getShape(this, state.getValue(FACING), level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);
        BlockState state = this.defaultBlockState()
            .setValue(FACING, context.getHorizontalDirection())
            .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return state.setValue(SHAPE, getShape(this, state.getValue(FACING), context.getLevel(), pos));
    }

    public static DirectionalBlockProperty getShape(Block block, Direction direction, BlockGetter level, BlockPos pos) {
        BlockState state1 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        BlockState state2 = level.getBlockState(pos.relative(direction.getClockWise()));

        boolean check1 = state1.is(block) && state1.getValue(DiningBenchBlock.FACING) != direction;
        boolean check2 = state2.is(block) && state2.getValue(DiningBenchBlock.FACING) != direction;
        if (!state1.is(block) && !state2.is(block)) {
            return DirectionalBlockProperty.SINGLE;
        } else if (check1 && state2.is(block)) {
            return DirectionalBlockProperty.RIGHT;
        } else if (check2 && state1.is(block)) {
            return DirectionalBlockProperty.LEFT;
        } else if (check1) {
            return DirectionalBlockProperty.SINGLE;
        } else if (check2) {
            return DirectionalBlockProperty.SINGLE;
        } else if (!state1.is(block)) {
            return DirectionalBlockProperty.RIGHT;
        } else if (!state2.is(block)) {
            return DirectionalBlockProperty.LEFT;
        } else {
            return DirectionalBlockProperty.MIDDLE;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(ConstantComponents.SHEET);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
