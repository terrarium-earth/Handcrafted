package earth.terrarium.handcrafted.block.chair;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CushionBenchBlockEntity extends BlockEntity {
    private ResourceLocation cushion = new ResourceLocation("air");

    public CushionBenchBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }


    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.putString("Cushion", cushion.toString());
    }

    @Override
    public void load(CompoundTag tag) {
        this.cushion = new ResourceLocation(tag.getString("Cushion"));
    }

    public ResourceLocation getCushion() {
        return this.cushion;
    }

    public void setCushion(ResourceLocation cushion) {
        this.cushion = cushion;
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
