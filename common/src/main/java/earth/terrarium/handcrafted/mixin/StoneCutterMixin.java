package earth.terrarium.handcrafted.mixin;

import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

// Convert planks into boards by throwing them onto the Stone Cutter.
@Mixin(StonecutterBlock.class)
public abstract class StoneCutterMixin extends Block {
    public StoneCutterMixin(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (entity instanceof ItemEntity item) {
            ItemStack stack = item.getItem();
            if (!stack.is(ModTags.BOARDS)) {
                return;
            }
            ItemStack newStack = ItemStack.EMPTY;

            if (stack.is(Items.ACACIA_PLANKS)) newStack = ModItems.ACACIA_BOARD.get().getDefaultInstance();
            if (stack.is(Items.BIRCH_PLANKS)) newStack = ModItems.BIRCH_BOARD.get().getDefaultInstance();
            if (stack.is(Items.DARK_OAK_PLANKS)) newStack = ModItems.DARK_OAK_BOARD.get().getDefaultInstance();
            if (stack.is(Items.JUNGLE_PLANKS)) newStack = ModItems.JUNGLE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.MANGROVE_PLANKS)) newStack = ModItems.MANGROVE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.OAK_PLANKS)) newStack = ModItems.OAK_BOARD.get().getDefaultInstance();
            if (stack.is(Items.SPRUCE_PLANKS)) newStack = ModItems.SPRUCE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.CRIMSON_PLANKS)) newStack = ModItems.CRIMSON_BOARD.get().getDefaultInstance();
            if (stack.is(Items.WARPED_PLANKS)) newStack = ModItems.WARPED_BOARD.get().getDefaultInstance();

            // Give 4 boards per plank.
            newStack.setCount(stack.getCount() * 4);
            if (!newStack.isEmpty()) {
                entity.discard();
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, newStack);
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                level.addFreshEntity(itemEntity);
            }
        }
    }
}
