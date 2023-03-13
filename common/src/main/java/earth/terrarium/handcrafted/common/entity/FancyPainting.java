package earth.terrarium.handcrafted.common.entity;

import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class FancyPainting extends Painting {
    public FancyPainting(EntityType<? extends Painting> entityType, Level level) {
        super(entityType, level);
    }

    public FancyPainting(Level level, BlockPos blockPos, Direction direction, Holder<PaintingVariant> holder) {
        super(ModEntityTypes.FANCY_PAINTING.get(), level);
        this.setVariant(holder);
        this.setDirection(direction);
        this.pos = blockPos;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemLike item) {
        return super.spawnAtLocation(ModItems.FANCY_PAINTING.get());
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.FANCY_PAINTING.get());
    }
}