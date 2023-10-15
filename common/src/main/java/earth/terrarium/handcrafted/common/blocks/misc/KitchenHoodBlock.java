package earth.terrarium.handcrafted.common.blocks.misc;

import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
import net.minecraft.MethodsReturnNonnullByDefault;
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
@MethodsReturnNonnullByDefault
public class KitchenHoodBlock extends SimpleBlock {
    public static final VoxelShape SHAPE = Stream.of(
        Block.box(3, 13, 3, 13, 16, 13),
        Block.box(0, 0, 0, 16, 6, 16),
        Block.box(3, 6, 3, 13, 9, 13),
        Block.box(4, 5, 4, 12, 15, 12)
    ).reduce(Shapes::or).get();

    public KitchenHoodBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
