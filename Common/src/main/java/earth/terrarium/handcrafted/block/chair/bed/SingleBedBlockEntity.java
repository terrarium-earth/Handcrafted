package earth.terrarium.handcrafted.block.chair.bed;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SingleBedBlockEntity extends CushionBenchBlockEntity {
    private DyeColor color;

    public SingleBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SINGLE_BED.get(), blockPos, blockState);
        this.color = ((BedBlock)blockState.getBlock()).getColor();
        this.setCushion(new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"));
    }

    public SingleBedBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor dyeColor) {
        super(ModBlockEntities.SINGLE_BED.get(), blockPos, blockState);
        this.color = dyeColor;
        this.setCushion(new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"));
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor color) {
        this.color = color;
    }
}
