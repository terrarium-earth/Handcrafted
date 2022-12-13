package earth.terrarium.handcrafted.common.block.table.table;

import earth.terrarium.handcrafted.common.block.property.SheetState;
import earth.terrarium.handcrafted.common.block.property.TableState;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
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
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class TableBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<TableState> TABLE_BLOCK_SHAPE = EnumProperty.create("table_shape", TableState.class);
    public static final EnumProperty<SheetState> TABLE_SHEET_SHAPE = EnumProperty.create("sheet_shape", SheetState.class);

    public TableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TABLE_BLOCK_SHAPE, TableState.SINGLE).setValue(TABLE_SHEET_SHAPE, SheetState.SINGLE).setValue(WATERLOGGED, false));
    }

    public TableBlock(Properties properties, boolean registerDefaultState) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TABLE_BLOCK_SHAPE, TableState.SINGLE).setValue(TABLE_SHEET_SHAPE, SheetState.SINGLE).setValue(WATERLOGGED, false));
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TableBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return sheetUse(level, pos, player, ItemStack.EMPTY);
    }

    public static InteractionResult sheetUse(Level level, BlockPos pos, Player player, ItemStack defaultSheet) {
        if (!level.isClientSide()) {
            if (level.getBlockEntity(pos) instanceof TableBlockEntity entity) {
                ItemStack stack = player.getMainHandItem();
                if ((entity.getSheet().isEmpty() || ItemStack.isSameIgnoreDurability(entity.getSheet(), defaultSheet)) && stack.is(ModTags.SHEETS)) {
                    ItemStack copy = stack.copy();
                    copy.setCount(1);
                    entity.setSheet(copy);
                    if (!player.isCreative()) stack.shrink(1);
                    return InteractionResult.SUCCESS;
                } else if (player.isCrouching()) {
                    if (!ItemStack.isSameIgnoreDurability(entity.getSheet(), defaultSheet)) {
                        ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getSheet());
                        entity.setSheet(defaultSheet);
                        itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                        level.addFreshEntity(itemEntity);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.CONSUME_PARTIAL;
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
}