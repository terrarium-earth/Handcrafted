package earth.terrarium.handcrafted.common.block.stackablejar;

import earth.terrarium.handcrafted.common.block.SimpleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class StackableJarBlock extends SimpleBlock {
    public static final IntegerProperty JARS = IntegerProperty.create("jars", 1, 3);
    public static final VoxelShape SHAPE_1 = Block.box(0, 0, 0, 9, 9, 9);
    public static final VoxelShape SHAPE_2 = Block.box(0, 0, 0, 9, 9, 9);
    public static final VoxelShape SHAPE_3 = Block.box(0, 0, 0, 9, 16, 9);

    public StackableJarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(JARS, 1).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(JARS) < 3 || super.canBeReplaced(state, useContext);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = switch (state.getValue(JARS)) {
            case 2 -> SHAPE_2;
            case 3 -> SHAPE_3;
            default -> SHAPE_1;
        };
        return shape.move(3.5f / 16, 0, 3.5f / 16);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(JARS, Math.min(3, blockState.getValue(JARS) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, bl);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, JARS, WATERLOGGED);
    }
}
