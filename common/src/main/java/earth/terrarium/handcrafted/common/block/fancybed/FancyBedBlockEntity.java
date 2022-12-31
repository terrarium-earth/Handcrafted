package earth.terrarium.handcrafted.common.block.fancybed;

import dev.architectury.injectables.annotations.PlatformOnly;
import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class FancyBedBlockEntity extends ItemHoldingBlockEntity {
    private ItemStack sheet = ModItems.WHITE_SHEET.get().getDefaultInstance();

    public FancyBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.FANCY_BED.get(), blockPos, blockState);
        this.setStack(ModItems.WHITE_CUSHION.get().getDefaultInstance());
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

    @Override
    public void clear() {
        super.clear();
        this.setSheet(ItemStack.EMPTY);
    }

    public ItemStack getSheet() {
        return this.sheet;
    }

    public void setSheet(ItemStack sheet) {
        this.sheet = sheet;
        this.update();
    }

    @PlatformOnly("forge")
    public AABB getRenderBoundingBox() {
        return new AABB(this.getBlockPos()).inflate(2);
    }
}
