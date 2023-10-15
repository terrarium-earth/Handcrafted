package earth.terrarium.handcrafted.common.blocks.crockery;

import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
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
public class CrockeryBlock extends SimpleBlock {
    public static final IntegerProperty PIECES = IntegerProperty.create("pieces", 1, 6);

    public static final VoxelShape SHAPE_1 = Block.box(3, 0, 3, 13, 1, 13);
    public static final VoxelShape SHAPE_2 = Block.box(3, 0, 3, 13, 2, 13);
    public static final VoxelShape SHAPE_3 = Block.box(3, 0, 3, 13, 3, 13);
    public static final VoxelShape SHAPE_4 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape SHAPE_5 = Block.box(3, 0, 3, 13, 5, 13);
    public static final VoxelShape SHAPE_6 = Block.box(3, 0, 3, 13, 6, 13);

    public CrockeryBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(PIECES, 1).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PIECES, WATERLOGGED);
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(PIECES) < 6 || super.canBeReplaced(state, useContext);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(PIECES)) {
            case 2 -> SHAPE_2;
            case 3 -> SHAPE_3;
            case 4 -> SHAPE_4;
            case 5 -> SHAPE_5;
            case 6 -> SHAPE_6;
            default -> SHAPE_1;
        };
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(this)) {
            return state.setValue(PIECES, Math.min(6, state.getValue(PIECES) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            BlockState placementState = super.getStateForPlacement(context);
            if (placementState == null) return null;
            return placementState.setValue(WATERLOGGED, bl);
        }
    }

    public static String piecesName(BlockState state) {
        return switch (state.getValue(PIECES)) {
            case 2 -> "double";
            case 3 -> "triple";
            case 4 -> "quadruple";
            case 5 -> "quintuple";
            case 6 -> "sextuple";
            default -> "single";
        };
    }
}
