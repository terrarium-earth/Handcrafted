package earth.terrarium.handcrafted.common.block.table.sidetable;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.common.block.table.table.TableBlock;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class SideTableBlock extends SimpleEntityBlock {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(2, 12, 2, 14, 16, 14),
            Block.box(4, 8, 4, 12, 12, 12),
            Block.box(3, 0, 10, 6, 12, 13),
            Block.box(10, 0, 3, 13, 12, 6),
            Block.box(3, 0, 3, 6, 12, 6),
            Block.box(10, 0, 10, 13, 12, 13)
    ).reduce(Shapes::or).get();

    public SideTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> f.is(ModTags.SHEETS), SoundEvents.WOOL_PLACE);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SideTableBlockEntity(pos, state);
    }
}
