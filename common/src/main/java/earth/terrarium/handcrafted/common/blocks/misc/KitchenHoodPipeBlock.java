package earth.terrarium.handcrafted.common.blocks.misc;

import com.mojang.serialization.MapCodec;
import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
import earth.terrarium.handcrafted.common.registry.ModSoundEvents;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class KitchenHoodPipeBlock extends SimpleBlock implements Hammerable {
    public static final MapCodec<KitchenHoodPipeBlock> CODEC = simpleCodec(KitchenHoodPipeBlock::new);

    public static final BooleanProperty CORNER = BooleanProperty.create("corner");
    public static final VoxelShape SHAPE;
    public static final VoxelShape NORTH_SHAPE;
    public static final VoxelShape EAST_SHAPE;
    public static final VoxelShape SOUTH_SHAPE;
    public static final VoxelShape WEST_SHAPE;

    public KitchenHoodPipeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CORNER, false).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));

    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (!state.getValue(CORNER)) {
            return SHAPE;
        }
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> EAST_SHAPE;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CORNER, WATERLOGGED);
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        level.setBlock(pos, state.setValue(CORNER, !state.getValue(CORNER)).setValue(FACING, side.getAxis().isHorizontal() ?
            side : state.getValue(FACING)), Block.UPDATE_ALL);
        level.playSound(null, pos, ModSoundEvents.HAMMER_STONE.get(), SoundSource.BLOCKS, 1, 1);
    }

    static {
        SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 3, 13),
            Block.box(3, 13, 3, 13, 16, 13),
            Block.box(4, 3, 4, 12, 13, 12)
        ).reduce(Shapes::or).get();
        NORTH_SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 3, 13),
            Block.box(3, 3, 13, 13, 13, 16),
            Block.box(4, 3, 4, 12, 12, 12),
            Block.box(4, 4, 12, 12, 12, 13)
        ).reduce(Shapes::or).get();
        EAST_SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 3, 13),
            Block.box(0, 3, 3, 3, 13, 13),
            Block.box(4, 3, 4, 12, 12, 12),
            Block.box(3, 4, 4, 4, 12, 12)
        ).reduce(Shapes::or).get();
        SOUTH_SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 3, 13),
            Block.box(3, 3, 0, 13, 13, 3),
            Block.box(4, 3, 4, 12, 12, 12),
            Block.box(4, 4, 3, 12, 12, 4)
        ).reduce(Shapes::or).get();
        WEST_SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 3, 13),
            Block.box(13, 3, 3, 16, 13, 13),
            Block.box(4, 3, 4, 12, 12, 12),
            Block.box(12, 4, 4, 13, 12, 12)
        ).reduce(Shapes::or).get();
    }
}
