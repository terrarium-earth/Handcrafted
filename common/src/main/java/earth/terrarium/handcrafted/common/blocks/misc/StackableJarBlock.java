package earth.terrarium.handcrafted.common.blocks.misc;

import com.mojang.serialization.MapCodec;
import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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
    public static final MapCodec<StackableJarBlock> CODEC = simpleCodec(StackableJarBlock::new);

    public static final IntegerProperty JARS = IntegerProperty.create("jars", 1, 3);
    public static final VoxelShape SHAPE_1 = Block.box(0, 0, 0, 9, 9, 9);
    public static final VoxelShape SHAPE_2 = Block.box(0, 0, 0, 9, 9, 9);
    public static final VoxelShape SHAPE_3 = Block.box(0, 0, 0, 9, 16, 9);

    public StackableJarBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState()
            .setValue(FACING, Direction.NORTH)
            .setValue(JARS, 1)
            .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
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
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(this)) {
            return state.setValue(JARS, Math.min(3, state.getValue(JARS) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            BlockState placementState = super.getStateForPlacement(context);
            if (placementState == null) return null;
            return placementState
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, JARS, WATERLOGGED);
    }
}
