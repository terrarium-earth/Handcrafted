package earth.terrarium.handcrafted.entity.fancypainting;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.mixin.PaintingInvoker;
import earth.terrarium.handcrafted.registry.ModEntityTypes;
import earth.terrarium.handcrafted.registry.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FancyPainting extends Painting {
    public FancyPainting(EntityType<? extends Painting> entityType, Level level) {
        super(entityType, level);
    }

    protected FancyPainting(Level level, BlockPos pos) {
        this(ModEntityTypes.FANCY_PAINTING.get(), level);
        this.pos = pos;
    }

    public static Optional<FancyPainting> place(Level level, BlockPos pos, Direction facing) {
        FancyPainting paintingEntity = new FancyPainting(level, pos);

        List<Holder<PaintingVariant>> spacePaintings = getFancyPaintings();

        if (spacePaintings.isEmpty()) {
            return Optional.empty();
        }

        paintingEntity.setDirection(facing);
        spacePaintings.removeIf(variant -> {
            ((PaintingInvoker) paintingEntity).invokeSetVariant(variant);
            return !paintingEntity.survives();
        });

        if (spacePaintings.isEmpty()) {
            return Optional.empty();
        }

        int i = spacePaintings.stream().mapToInt(FancyPainting::getSize).max().orElse(0);
        spacePaintings.removeIf(variant -> FancyPainting.getSize(variant) < i);
        Optional<Holder<PaintingVariant>> optional = Util.getRandomSafe(spacePaintings, paintingEntity.random);

        if (optional.isEmpty()) {
            return Optional.empty();
        }

        ((PaintingInvoker) paintingEntity).invokeSetVariant(optional.get());
        paintingEntity.setDirection(facing);
        return Optional.of(paintingEntity);
    }

    protected static int getSize(Holder<PaintingVariant> variant) {
        return variant.value().getWidth() * variant.value().getHeight();
    }

    public static List<Holder<PaintingVariant>> getFancyPaintings() {
        List<Holder<PaintingVariant>> paintings = new ArrayList<>();
        Registry.PAINTING_VARIANT.forEach(painting -> {
            if (Registry.PAINTING_VARIANT.getKey(painting).getNamespace().equals(Handcrafted.MOD_ID)) {
                paintings.add(Holder.direct(painting));
            }
        });

        return paintings;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        ResourceKey<PaintingVariant> registryKey = ResourceKey.create(Registry.PAINTING_VARIANT_REGISTRY, new ResourceLocation(nbt.getString("Variant")));
        ((PaintingInvoker) this).invokeSetVariant(Registry.PAINTING_VARIANT.getHolder(registryKey).get());
        this.direction = Direction.from2DDataValue(nbt.getByte("Facing"));
        this.setDirection(this.direction);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putString("Variant", Registry.PAINTING_VARIANT.getKey(this.getVariant().value()).toString());
        nbt.putByte("Facing", (byte) this.direction.get2DDataValue());
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