package earth.terrarium.handcrafted.common.block.chair.woodenbench;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class WoodenBenchBlock extends ExpandableCouchBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 10, 16);

    public WoodenBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                level.addFreshEntity(itemEntity);
                level.updateNeighbourForOutputSignal(pos, this);
                entity.clear();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WoodenBenchBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult interactionResult = ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> f.is(ModTags.CUSHIONS));
        if (!interactionResult.consumesAction()) {
            return super.use(state, level, pos, player, hand, hit);
        }
        return interactionResult;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return SHAPE.move(offset.x(), offset.y(), offset.z());
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return new AABB(0, 0, 0, 1, 0.5, 1);
    }
}
