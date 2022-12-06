package earth.terrarium.handcrafted.block.specialbed;

import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import earth.terrarium.handcrafted.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class SpecialBedBlockEntity extends CushionBenchBlockEntity {
    private ItemStack sheet = ModItems.WHITE_SHEET.get().getDefaultInstance();

    public SpecialBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SPECIAL_BED.get(), blockPos, blockState);
        this.setCushion(ModItems.WHITE_CUSHION.get().getDefaultInstance());
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Sheet", this.getSheet().save(new CompoundTag()));
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setSheet(ItemStack.of(tag.getCompound("Sheet")));
    }

    public ItemStack getSheet() {
        return this.sheet;
    }

    public void setSheet(ItemStack sheet) {
        this.sheet = sheet;
        this.update();
    }
}
