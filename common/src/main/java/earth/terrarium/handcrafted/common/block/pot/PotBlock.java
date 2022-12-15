package earth.terrarium.handcrafted.common.block.pot;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class PotBlock extends Block {
    public static final VoxelShape THIN_SHAPE = Stream.of(
            Block.box(5, 12, 5, 11, 14, 11),
            Block.box(4, 0, 4, 12, 11, 12),
            Block.box(6, 11, 6, 10, 12, 10)
    ).reduce(Shapes::or).get();
    public static final VoxelShape MEDIUM_SHAPE = Stream.of(
            Block.box(3, 10, 3, 13, 12, 13),
            Block.box(2, 0, 2, 14, 9, 14),
            Block.box(4, 9, 4, 12, 10, 12)
    ).reduce(Shapes::or).get();
    public static final VoxelShape WIDE_SHAPE = Stream.of(
            Block.box(2, 6, 2, 14, 8, 14),
            Block.box(1, 0, 1, 15, 5, 15),
            Block.box(3, 5, 3, 13, 6, 13)
    ).reduce(Shapes::or).get();
    public static final VoxelShape THICK_SHAPE = Stream.of(
            Block.box(3, 12, 3, 13, 14, 13),
            Block.box(2, 0, 2, 14, 11, 14),
            Block.box(4, 11, 4, 12, 12, 12)
    ).reduce(Shapes::or).get();
    private final PotSize size;


    public PotBlock(PotSize size, Properties properties) {
        super(properties);
        this.size = size;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (size) {
            case THIN -> THIN_SHAPE;
            case MEDIUM -> MEDIUM_SHAPE;
            case WIDE -> WIDE_SHAPE;
            case THICK -> THICK_SHAPE;
        };
    }

    public enum PotSize {
        THIN,
        MEDIUM,
        WIDE,
        THICK
    }
}
