package earth.terrarium.handcrafted.block.chair.tablebench;

import earth.terrarium.handcrafted.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.block.property.DirectionalBlockSide;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class TableBenchBlock extends SimpleEntityBlock {
    public static final EnumProperty<DirectionalBlockSide> TABLE_BENCH_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);

    public TableBenchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TABLE_BENCH_SHAPE, DirectionalBlockSide.SINGLE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TableBenchBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TABLE_BENCH_SHAPE, FACING, WATERLOGGED);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(TABLE_BENCH_SHAPE, DirectionalBlockSide.getShape(this, FACING, state, level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(TABLE_BENCH_SHAPE, DirectionalBlockSide.getShape(this, FACING, blockState, context.getLevel(), blockPos));
    }
}
