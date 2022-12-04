package earth.terrarium.handcrafted.block.chair.bed;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.block.property.DirectionalBlockSide;
import earth.terrarium.handcrafted.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class SingleBedBlock extends BedBlock {
    public static final EnumProperty<DirectionalBlockSide> BED_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);

    public SingleBedBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SingleBedBlockEntity(pos, state, this.getColor());
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getMainHandItem();
        if (stack.is(ModTags.CUSHIONS)) {
            if (state.getValue(BedBlock.PART) == BedPart.HEAD) {
                return SimpleEntityBlock.cushionUse(level, pos.relative(state.getValue(BedBlock.FACING).getOpposite()), player, Handcrafted.MOD_ID + ":white_cushion");
            }
            return SimpleEntityBlock.cushionUse(level, pos, player, Handcrafted.MOD_ID + ":white_cushion");
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BED_SHAPE, FACING, PART, OCCUPIED);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (direction == getNeighbourDirection(state.getValue(PART), state.getValue(FACING))) {
            return neighborState.is(this) && neighborState.getValue(PART) != state.getValue(PART) ? state.setValue(OCCUPIED, neighborState.getValue(OCCUPIED)).setValue(BED_SHAPE, getBedShape(state, level, currentPos)) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state.setValue(BED_SHAPE, getBedShape(state, level, currentPos)), direction, neighborState, level, currentPos, neighborPos);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        BlockPos blockPos = context.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level level = context.getLevel();
        return level.getBlockState(blockPos2).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(blockPos2) ? this.defaultBlockState().setValue(FACING, direction).setValue(BED_SHAPE, getBedShape(this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()), context.getLevel(), blockPos)) : null;
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    private DirectionalBlockSide getBedShape(BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockState3 = level.getBlockState(pos.relative(direction.getClockWise()));
        BlockState blockState4 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        if (!blockState3.is(this) && !blockState4.is(this)) {
            return DirectionalBlockSide.SINGLE;
        } else if (!blockState3.is(this)) {
            return DirectionalBlockSide.RIGHT;
        } else if (!blockState4.is(this)) {
            return DirectionalBlockSide.LEFT;
        } else {
            return DirectionalBlockSide.MIDDLE;
        }
    }
}
