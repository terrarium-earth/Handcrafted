package earth.terrarium.handcrafted.block.stackablebook;

import earth.terrarium.handcrafted.block.SimpleEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class StackableBookBlock extends SimpleEntityBlock {
    public static final IntegerProperty BOOKS = IntegerProperty.create("books", 1, 4);

    public StackableBookBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(BOOKS, 1).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));

    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StackableBookBlockEntity(pos, state);
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(BOOKS) < 4 || super.canBeReplaced(state, useContext);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(BOOKS, Math.min(4, blockState.getValue(BOOKS) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, bl);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BOOKS, FACING, WATERLOGGED);
    }
}