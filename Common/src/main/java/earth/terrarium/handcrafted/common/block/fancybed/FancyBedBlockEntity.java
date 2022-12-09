package earth.terrarium.handcrafted.common.block.fancybed;

import earth.terrarium.handcrafted.common.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class FancyBedBlockEntity extends CushionBenchBlockEntity {
    private ItemStack sheet = ModItems.WHITE_SHEET.get().getDefaultInstance();

    public FancyBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FANCY_BED.get(), blockPos, blockState);
        this.setCushion(ModItems.WHITE_CUSHION.get().getDefaultInstance());
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
}
