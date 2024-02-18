package earth.terrarium.handcrafted.common.blocks;

import com.mojang.serialization.MapCodec;
import earth.terrarium.handcrafted.common.blocks.base.SittableBlock;
import earth.terrarium.handcrafted.common.blocks.base.properties.OptionalColorProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.InteractionUtils;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
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
public class ChairBlock extends HorizontalDirectionalBlock implements SittableBlock, SimpleWaterloggedBlock {
    public static final MapCodec<ChairBlock> CODEC = simpleCodec(ChairBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<OptionalColorProperty> COLOR = EnumProperty.create("color", OptionalColorProperty.class);

    public static final AABB SEAT = new AABB(0, 0, 0, 1, 0.5, 1);
    public static final VoxelShape VOXEL_SHAPE = Block.box(0, 0, 0, 16, 10, 16);

    public ChairBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(WATERLOGGED, false)
            .setValue(COLOR, OptionalColorProperty.NONE)
        );
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && state.getBlock() != newState.getBlock()) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), state.getValue(COLOR).toCushion());
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, COLOR);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return SEAT;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        var result = InteractionUtils.interactOptionalCushion(state, level, pos, player, hand, COLOR);
        if (result != InteractionResult.PASS) return result;

        if (this.sitOn(level, pos, player, state.getValue(FACING))) {
            return InteractionResult.CONSUME;
        }

        return InteractionResult.CONSUME_PARTIAL;
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())
            .setValue(WATERLOGGED, fluidState.getType().equals(Fluids.WATER));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.CUSHION);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
