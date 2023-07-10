package earth.terrarium.handcrafted.common.block.table.table;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.property.SheetState;
import earth.terrarium.handcrafted.common.block.property.TableState;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class TableBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<TableState> TABLE_BLOCK_SHAPE = EnumProperty.create("table_shape", TableState.class);
    public static final EnumProperty<SheetState> TABLE_SHEET_SHAPE = EnumProperty.create("sheet_shape", SheetState.class);
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
        this.registerDefaultState(this.defaultBlockState().setValue(TABLE_BLOCK_SHAPE, TableState.SINGLE).setValue(TABLE_SHEET_SHAPE, SheetState.SINGLE).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TableBlockEntity(pos, state);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(TABLE_BLOCK_SHAPE)) {
            case SINGLE -> SINGLE_SHAPE;
            case CENTER -> CENTER_SHAPE;
            case NORTH_EAST_CORNER -> NORTH_EAST_CORNER_SHAPE;
            case NORTH_WEST_CORNER -> NORTH_WEST_CORNER_SHAPE;
            case SOUTH_EAST_CORNER -> SOUTH_EAST_CORNER_SHAPE;
            case SOUTH_WEST_CORNER -> SOUTH_WEST_CORNER_SHAPE;
            case NORTH_SIDE -> NORTH_SIDE_SHAPE;
            case EAST_SIDE -> EAST_SIDE_SHAPE;
            case SOUTH_SIDE -> SOUTH_SIDE_SHAPE;
            case WEST_SIDE -> WEST_SIDE_SHAPE;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, TABLE_BLOCK_SHAPE, TABLE_SHEET_SHAPE);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(TABLE_BLOCK_SHAPE, getShape(level, currentPos)).setValue(TABLE_SHEET_SHAPE, getSheetShape(level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(TABLE_BLOCK_SHAPE, getShape(context.getLevel(), blockPos)).setValue(TABLE_SHEET_SHAPE, getSheetShape(context.getLevel(), blockPos));
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> f.is(ModTags.SHEETS), SoundEvents.WOOL_PLACE);
    }

    public TableState getShape(BlockGetter level, BlockPos pos) {
        boolean northPresent = level.getBlockState(pos.relative(Direction.NORTH)).is(ModTags.TABLE_ATTACHMENTS);
        boolean eastPresent = level.getBlockState(pos.relative(Direction.EAST)).is(ModTags.TABLE_ATTACHMENTS);
        boolean southPresent = level.getBlockState(pos.relative(Direction.SOUTH)).is(ModTags.TABLE_ATTACHMENTS);
        boolean westPresent = level.getBlockState(pos.relative(Direction.WEST)).is(ModTags.TABLE_ATTACHMENTS);

        if (northPresent && eastPresent && southPresent && westPresent) return TableState.CENTER;

        if (northPresent && southPresent) return TableState.CENTER;
        if (eastPresent && westPresent) return TableState.CENTER;

        if (northPresent && eastPresent) return TableState.SOUTH_WEST_CORNER;
        if (eastPresent && southPresent) return TableState.NORTH_WEST_CORNER;
        if (southPresent && westPresent) return TableState.NORTH_EAST_CORNER;
        if (westPresent && northPresent) return TableState.SOUTH_EAST_CORNER;

        if (northPresent) return TableState.SOUTH_SIDE;
        if (eastPresent) return TableState.WEST_SIDE;
        if (southPresent) return TableState.NORTH_SIDE;
        if (westPresent) return TableState.EAST_SIDE;

        return TableState.SINGLE;
    }

    public SheetState getSheetShape(BlockGetter level, BlockPos pos) {
        boolean northPresent = level.getBlockState(pos.relative(Direction.NORTH)).is(ModTags.TABLE_ATTACHMENTS);
        boolean eastPresent = level.getBlockState(pos.relative(Direction.EAST)).is(ModTags.TABLE_ATTACHMENTS);
        boolean southPresent = level.getBlockState(pos.relative(Direction.SOUTH)).is(ModTags.TABLE_ATTACHMENTS);
        boolean westPresent = level.getBlockState(pos.relative(Direction.WEST)).is(ModTags.TABLE_ATTACHMENTS);

        if (northPresent && eastPresent && southPresent && westPresent) return SheetState.CENTER;

        if (northPresent && eastPresent && southPresent) return SheetState.WEST_SIDE;
        if (northPresent && eastPresent && westPresent) return SheetState.SOUTH_SIDE;
        if (northPresent && southPresent && westPresent) return SheetState.EAST_SIDE;
        if (eastPresent && southPresent && westPresent) return SheetState.NORTH_SIDE;

        if (northPresent && eastPresent) return SheetState.SOUTH_WEST_CORNER;
        if (eastPresent && southPresent) return SheetState.NORTH_WEST_CORNER;
        if (southPresent && westPresent) return SheetState.NORTH_EAST_CORNER;
        if (westPresent && northPresent) return SheetState.SOUTH_EAST_CORNER;

        if (northPresent) return SheetState.SOUTH_COVER;
        if (eastPresent) return SheetState.WEST_COVER;
        if (southPresent) return SheetState.NORTH_COVER;
        if (westPresent) return SheetState.EAST_COVER;

        return SheetState.SINGLE;
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
            Block.box(12, 0, 1, 15, 12, 4),
            Block.box(1, 0, 1, 4, 12, 4)
        ).reduce(Shapes::or).get();
        EAST_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(12, 0, 1, 15, 12, 4)
        ).reduce(Shapes::or).get();
        SOUTH_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(1, 0, 12, 4, 12, 15)
        ).reduce(Shapes::or).get();
        WEST_SIDE_SHAPE = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(1, 0, 1, 4, 12, 4),
            Block.box(1, 0, 12, 4, 12, 15)
        ).reduce(Shapes::or).get();
    }
}