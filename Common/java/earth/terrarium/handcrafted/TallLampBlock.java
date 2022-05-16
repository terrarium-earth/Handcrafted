package earth.terrarium.handcrafted;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TallLampBlock extends HorizontalDirectionalBlock {
    public static final VoxelShape SHAPE_Z_AXIS = Block.box(2.0D, 0.0D, 6.0D, 14.0D, 16.0D, 10.0D);
    public static final VoxelShape SHAPE_X_AXIS = Block.box(6.0D, 0.0D, 2.0D, 10.0D, 16.0D, 14.0D);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final BooleanProperty TOP = BooleanProperty.create("top");

    public TallLampBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(TOP, false).setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(FACING).getAxis() == Direction.Axis.X ? SHAPE_X_AXIS : SHAPE_Z_AXIS;
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return canSupportCenter(levelReader, blockPos.below(), Direction.UP);
    }

    public void animateTick(BlockState state, Level level, BlockPos blockPos, Random random) {
        if (!state.getValue(TOP)) return;

        Direction direction = state.getValue(FACING);
        double centerX = blockPos.getX() + 0.5D;
        double centerY = blockPos.getY() + 0.97D;
        double centerZ = blockPos.getZ() + 0.5D;

        double heightOffset1;
        double heightOffset2;
        if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
            heightOffset1 = 0.7;
            heightOffset2 = 0.45;
        } else {
            heightOffset1 = 0.45;
            heightOffset2 = 0.7;
        }

        double y1 = blockPos.getY() + heightOffset1;
        double y2 = blockPos.getY() + heightOffset2;

        level.addParticle(ParticleTypes.SMOKE, centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);
        level.addParticle(ParticleTypes.FLAME, centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);

        switch (direction) {
            case EAST, WEST -> {
                double x1 = blockPos.getX() + 0.5D;
                double z1 = blockPos.getZ() + 0.25D;
                double x2 = blockPos.getX() + 0.5D;
                double z2 = blockPos.getZ() + 0.75D;
                level.addParticle(ParticleTypes.SMOKE, x1, y1, z1, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.FLAME, x1, y1, z1, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.SMOKE, x2, y2, z2, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.FLAME, x2, y2, z2, 0.0D, 0.0D, 0.0D);
            }
            case SOUTH, NORTH -> {
                if (state.getValue(TOP) == !state.is(this))
                    return;
                double x1 = blockPos.getX() + 0.75D;
                double z1 = blockPos.getZ() + 0.5D;
                double x2 = blockPos.getX() + 0.25D;
                double z2 = blockPos.getZ() + 0.5D;
                level.addParticle(ParticleTypes.SMOKE, x1, y1, z1, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.FLAME, x1, y1, z1, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.SMOKE, x2, y2, z2, 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.FLAME, x2, y2, z2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(TOP, FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction direction = blockPlaceContext.getHorizontalDirection().getOpposite();
        if (blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().above()).canBeReplaced(blockPlaceContext))
            return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction);
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        level.setBlock(blockPos.above(), blockState.setValue(TOP, true), 3);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        Direction disallowed = blockState.getValue(TOP) ? Direction.DOWN : Direction.UP;
        if (direction == disallowed && !blockState2.is(this)) return Blocks.AIR.defaultBlockState();
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);

    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide && player.isCreative() && blockState.getValue(TOP)) {
            BlockPos below = blockPos.below();
            BlockState belowState = level.getBlockState(below);
            if (belowState.is(this) && !belowState.getValue(TOP)) {
                level.setBlock(below, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, below, Block.getId(belowState));
            }
        }
        super.playerWillDestroy(level, blockPos, blockState, player);
    }
}
