package earth.terrarium.handcrafted.common.blocks.crockery;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrockeryBlockEntity extends BlockEntity {
    private ItemStack item = ItemStack.EMPTY;

    public CrockeryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CROCKERY.get(), pos, state);
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

    public void update() {
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
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
}
