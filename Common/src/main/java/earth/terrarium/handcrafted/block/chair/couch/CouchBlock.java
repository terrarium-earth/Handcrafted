package earth.terrarium.handcrafted.block.chair.couch;

import earth.terrarium.handcrafted.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.block.chair.ExpandableCouchBlock;
import earth.terrarium.handcrafted.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class CouchBlock extends ExpandableCouchBlock {

    public CouchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CouchBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return SimpleEntityBlock.cushionUse(level, pos, player, ModItems.WHITE_CUSHION.get().getDefaultInstance());
    }
}
