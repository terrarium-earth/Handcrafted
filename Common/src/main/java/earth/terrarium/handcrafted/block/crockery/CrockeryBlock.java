package earth.terrarium.handcrafted.block.crockery;

import earth.terrarium.handcrafted.block.SimpleBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class CrockeryBlock extends SimpleBlock {
    public static final IntegerProperty PIECES = IntegerProperty.create("pieces", 1, 6);
    public CrockeryBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(PIECES, 1).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(PIECES) < 6 || super.canBeReplaced(state, useContext);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(PIECES, Math.min(6, blockState.getValue(PIECES) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, bl);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PIECES, FACING, WATERLOGGED);
    }
}
