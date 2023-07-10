package earth.terrarium.handcrafted.common.block.table.nightstand;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class NightstandBlock extends SimpleEntityBlock {
    public static final VoxelShape SHAPE = Stream.of(
        Block.box(0, 12, 0, 16, 16, 16),
        Block.box(12, 0, 12, 15, 12, 15),
        Block.box(12, 0, 1, 15, 12, 4),
        Block.box(1, 0, 1, 4, 12, 4),
        Block.box(1, 0, 12, 4, 12, 15),
        Block.box(2, 0, 2, 14, 12, 14)
    ).reduce(Shapes::or).get();

    public NightstandBlock(Properties properties) {
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
        return new NightstandBlockEntity(pos, state);
    }
}
