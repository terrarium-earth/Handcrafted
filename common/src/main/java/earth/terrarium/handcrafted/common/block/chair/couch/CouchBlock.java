package earth.terrarium.handcrafted.common.block.chair.couch;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class CouchBlock extends ExpandableCouchBlock {
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 5, 16);

    public CouchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CouchBlockEntity(pos, state);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
                if (entity.getStack().getItem() != ModItems.WHITE_CUSHION.get()) {
                    ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
                    itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                    level.addFreshEntity(itemEntity);
                    level.updateNeighbourForOutputSignal(pos, this);
                }
                entity.clear();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult interactionResult = ItemHoldingBlockEntity.placeItem(level, pos, player, ModItems.WHITE_CUSHION.get().getDefaultInstance(), f -> f.is(ModTags.CUSHIONS), SoundEvents.WOOL_PLACE);
        if (!interactionResult.consumesAction()) {
            return super.use(state, level, pos, player, hand, hit);
        }
        return interactionResult;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return new AABB(0, 0, 0, 1, 2f / 16, 1);
    }
}
