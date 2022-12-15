package earth.terrarium.handcrafted.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public abstract class ItemHoldingBlockEntity extends BlockEntity {
    private ItemStack item = ItemStack.EMPTY;

    public ItemHoldingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("Item", item.save(new CompoundTag()));
    }

    @Override
    public void load(CompoundTag tag) {
        this.item = ItemStack.of(tag.getCompound("Item"));
    }

    public ItemStack getStack() {
        return this.item;
    }

    public void setStack(ItemStack item) {
        this.item = item;
        this.update();
    }

    public void clear() {
        this.setStack(ItemStack.EMPTY);
    }

    public void update() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public static InteractionResult placeItem(Level level, BlockPos pos, Player player, ItemStack defaultItem, Predicate<ItemStack> filter, SoundEvent sound) {
        if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
            ItemStack stack = player.getMainHandItem();
            if (!ItemStack.isSameIgnoreDurability(stack, defaultItem) && (entity.getStack().isEmpty() || ItemStack.isSameIgnoreDurability(entity.getStack(), defaultItem)) && filter.test(stack)) {
                if (!level.isClientSide) {
                    ItemStack copy = stack.copy();
                    copy.setCount(1);
                    entity.setStack(copy);
                    if (!player.isCreative()) stack.shrink(1);
                    return InteractionResult.CONSUME;
                } else {
                    player.playSound(sound);
                    return InteractionResult.SUCCESS;
                }
            } else if (player.isCrouching()) {
                if (!ItemStack.isSameIgnoreDurability(entity.getStack(), defaultItem)) {
                    if(!level.isClientSide) {
                        ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
                        entity.setStack(defaultItem);
                        itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                        level.addFreshEntity(itemEntity);
                        return InteractionResult.CONSUME;
                    } else {
                        if (!entity.getStack().isEmpty()) {
                            player.playSound(sound);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.CONSUME;
    }
}
