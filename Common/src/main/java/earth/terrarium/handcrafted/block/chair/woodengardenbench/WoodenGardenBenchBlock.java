package earth.terrarium.handcrafted.block.chair.woodengardenbench;

import earth.terrarium.handcrafted.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.block.chair.ExpandableCouchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class WoodenGardenBenchBlock extends ExpandableCouchBlock {

    public WoodenGardenBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WoodenGardenBenchBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return SimpleEntityBlock.cushionUse(level, pos, player, ItemStack.EMPTY);
    }
}
