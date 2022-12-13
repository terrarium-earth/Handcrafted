package earth.terrarium.handcrafted.common.block.table.table;

import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TableBlockEntity extends BlockEntity {
    private ItemStack sheet = ItemStack.EMPTY;

    public TableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.TABLE.get(), blockPos, blockState);
    }

    public TableBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Sheet", sheet.save(new CompoundTag()));
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.sheet = ItemStack.of(tag.getCompound("Sheet"));
    }

    public ItemStack getSheet() {
        return this.sheet;
    }

    public void setSheet(ItemStack sheet) {
        this.sheet = sheet;
        this.update();
    }

    public void update() {
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
}
