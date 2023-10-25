package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blocks.base.properties.OptionalColorProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.TableProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.InteractionUtils;
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
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class TableBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<TableProperty> SHAPE = EnumProperty.create("shape", TableProperty.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<OptionalColorProperty> COLOR = EnumProperty.create("color", OptionalColorProperty.class);

    public static final VoxelShape SINGLE_SHAPE;
    public static final VoxelShape CENTER_SHAPE;
    public static final VoxelShape NORTH_EAST_CORNER_SHAPE;
    public static final VoxelShape NORTH_WEST_CORNER_SHAPE;
    public static final VoxelShape SOUTH_EAST_CORNER_SHAPE;
    public static final VoxelShape SOUTH_WEST_CORNER_SHAPE;
    public static final VoxelShape NORTH_SIDE_SHAPE;
    public static final VoxelShape EAST_SIDE_SHAPE;
    public static final VoxelShape SOUTH_SIDE_SHAPE;
    public static final VoxelShape WEST_SIDE_SHAPE;

    public TableBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(SHAPE, TableProperty.SINGLE)
            .setValue(WATERLOGGED, false)
            .setValue(COLOR, OptionalColorProperty.NONE)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED, COLOR);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && state.getBlock() != newState.getBlock()) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), state.getValue(COLOR).toSheet());
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return InteractionUtils.interactOptionalSheet(state, level, pos, player, hand, COLOR);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(SHAPE)) {
            case SINGLE -> SINGLE_SHAPE;
            case NORTH_EAST_CORNER -> NORTH_EAST_CORNER_SHAPE;
            case NORTH_WEST_CORNER -> NORTH_WEST_CORNER_SHAPE;
            case SOUTH_EAST_CORNER -> SOUTH_EAST_CORNER_SHAPE;
            case SOUTH_WEST_CORNER -> SOUTH_WEST_CORNER_SHAPE;
            case NORTH_SIDE -> NORTH_SIDE_SHAPE;
            case EAST_SIDE -> EAST_SIDE_SHAPE;
            case SOUTH_SIDE -> SOUTH_SIDE_SHAPE;
            case WEST_SIDE -> WEST_SIDE_SHAPE;
            default -> CENTER_SHAPE;
        };
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ?
            state.setValue(SHAPE, getShape(level, currentPos)) :
            super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);
        BlockState state = this.defaultBlockState()
            .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return state.setValue(SHAPE, getShape(context.getLevel(), pos));
    }

    public TableProperty getShape(BlockGetter level, BlockPos pos) {
        boolean northPresent = level.getBlockState(pos.relative(Direction.NORTH)).is(this);
        boolean eastPresent = level.getBlockState(pos.relative(Direction.EAST)).is(this);
        boolean southPresent = level.getBlockState(pos.relative(Direction.SOUTH)).is(this);
        boolean westPresent = level.getBlockState(pos.relative(Direction.WEST)).is(this);

        if (northPresent && eastPresent && southPresent && westPresent) return TableProperty.CENTER;

        if (northPresent && eastPresent && southPresent) return TableProperty.WEST_CENTER;
        if (northPresent && eastPresent && westPresent) return TableProperty.SOUTH_CENTER;
        if (northPresent && southPresent && westPresent) return TableProperty.EAST_CENTER;
        if (eastPresent && southPresent && westPresent) return TableProperty.NORTH_CENTER;

        if (northPresent && southPresent) return TableProperty.EAST_WEST_CENTER;
        if (eastPresent && westPresent) return TableProperty.NORTH_SOUTH_CENTER;

        if (northPresent && eastPresent) return TableProperty.SOUTH_WEST_CORNER;
        if (eastPresent && southPresent) return TableProperty.NORTH_WEST_CORNER;
        if (southPresent && westPresent) return TableProperty.NORTH_EAST_CORNER;
        if (westPresent && northPresent) return TableProperty.SOUTH_EAST_CORNER;

        if (northPresent) return TableProperty.NORTH_SIDE;
        if (eastPresent) return TableProperty.EAST_SIDE;
        if (southPresent) return TableProperty.SOUTH_SIDE;
        if (westPresent) return TableProperty.WEST_SIDE;

        return TableProperty.SINGLE;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(ConstantComponents.SHEET);
    }

    static {
        SINGLE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(12, 0, 1, 15, 12, 4),
            Block.box(1, 0, 1, 4, 12, 4),
            Block.box(1, 0, 12, 4, 12, 15)
        ).reduce(Shapes::or).get();

        CENTER_SHAPE = Block.box(0, 12, 0, 16, 16, 16);
        NORTH_EAST_CORNER_SHAPE = Shapes.or(Block.box(0, 12, 0, 16, 16, 16), Block.box(12, 0, 1, 15, 12, 4));
        NORTH_WEST_CORNER_SHAPE = Shapes.or(Block.box(0, 12, 0, 16, 16, 16), Block.box(1, 0, 1, 4, 12, 4));
        SOUTH_EAST_CORNER_SHAPE = Shapes.or(Block.box(0, 12, 0, 16, 16, 16), Block.box(12, 0, 12, 15, 12, 15));
        SOUTH_WEST_CORNER_SHAPE = Shapes.or(Block.box(0, 12, 0, 16, 16, 16), Block.box(1, 0, 12, 4, 12, 15));

        NORTH_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(1, 0, 12, 4, 12, 15)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        EAST_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(1, 0, 1, 4, 12, 4),
            Block.box(1, 0, 12, 4, 12, 15)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        SOUTH_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 1, 15, 12, 4),
            Block.box(1, 0, 1, 4, 12, 4)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        WEST_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(12, 0, 1, 15, 12, 4)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
