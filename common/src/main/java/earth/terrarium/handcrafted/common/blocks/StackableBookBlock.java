package earth.terrarium.handcrafted.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class StackableBookBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<StackableBookBlock> CODEC = simpleCodec(StackableBookBlock::new);

    public static final IntegerProperty BOOKS = IntegerProperty.create("books", 1, 4);
    public static final IntegerProperty SEED = IntegerProperty.create("seed", 1, 256);

    public static final VoxelShape SHAPE_1 = Block.box(3, 0, 2, 13, 4, 14);

    public static final VoxelShape SHAPE_2 = Shapes.join(
        Block.box(3, 0, 2, 13, 4, 14),
        Block.box(3, 4, 2, 13, 8, 14),
        BooleanOp.OR);

    public static final VoxelShape SHAPE_3 = Stream.of(
        Block.box(3, 0, 2, 13, 4, 14),
        Block.box(3, 4, 2, 13, 8, 14),
        Block.box(3, 8, 2, 13, 12, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_4 = Stream.of(
        Block.box(3, 0, 2, 13, 4, 14),
        Block.box(3, 4, 2, 13, 8, 14),
        Block.box(3, 8, 2, 13, 12, 14),
        Block.box(3, 12, 2, 13, 16, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public StackableBookBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState()
            .setValue(FACING, Direction.NORTH)
            .setValue(BOOKS, 1)
            .setValue(SEED, 1));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BOOKS, SEED);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(BOOKS)) {
            case 2 -> SHAPE_2;
            case 3 -> SHAPE_3;
            case 4 -> SHAPE_4;
            default -> SHAPE_1;
        };
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() &&
            useContext.getItemInHand().is(this.asItem()) && state.getValue(BOOKS) < 4 ||
            super.canBeReplaced(state, useContext);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(this)) {
            return state.setValue(BOOKS, Math.min(4, state.getValue(BOOKS) + 1));
        } else {
            BlockState placementState = super.getStateForPlacement(context);
            if (placementState == null) return null;
            Random seededRandom = new Random(context.getClickedPos().asLong());
            return placementState
                .setValue(FACING, Direction.from2DDataValue(seededRandom.nextInt(4)))
                .setValue(SEED, seededRandom.nextInt(256) + 1);
        }
    }

    public static String bookName(BlockState state) {
        return switch (state.getValue(BOOKS)) {
            case 2 -> "double";
            case 3 -> "triple";
            case 4 -> "quadruple";
            default -> "single";
        };
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
