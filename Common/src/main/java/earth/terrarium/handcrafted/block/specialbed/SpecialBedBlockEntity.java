package earth.terrarium.handcrafted.block.specialbed;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class SpecialBedBlockEntity extends CushionBenchBlockEntity {
    private ResourceLocation sheet = new ResourceLocation(Handcrafted.MOD_ID, "white_sheet");

    public SpecialBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SPECIAL_BED.get(), blockPos, blockState);
        this.setCushion(new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Sheet", sheet.toString());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.sheet = new ResourceLocation(tag.getString("Sheet"));
    }

    public ResourceLocation getSheet() {
        return this.sheet;
    }

    public void setSheet(ResourceLocation sheet) {
        this.sheet = sheet;
        this.update();
    }
}
