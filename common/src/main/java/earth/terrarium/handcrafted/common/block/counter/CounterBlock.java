package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.property.DirectionalBlockSide;
import earth.terrarium.handcrafted.common.item.Hammerable;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@MethodsReturnNonnullByDefault
public class CounterBlock extends ShelfBlock implements Hammerable {
    public static final EnumProperty<DirectionalBlockSide> COUNTER_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);

    public CounterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(COUNTER_SHAPE, DirectionalBlockSide.SINGLE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock()) && !(newState.getBlock() instanceof CounterBlock)) {
            if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
                if (entity.getStack().getItem() != Items.CALCITE) {
                    ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
                    itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                    level.addFreshEntity(itemEntity);
                    level.updateNeighbourForOutputSignal(pos, this);
                }
                entity.clear();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CounterBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        SoundEvent event = player.getMainHandItem().is(ItemTags.PLANKS) ? SoundEvents.WOOD_PLACE : SoundEvents.STONE_PLACE;
        return ItemHoldingBlockEntity.placeItem(level, pos, player, Items.CALCITE.getDefaultInstance(), f -> f.is(ModTags.COUNTER_SURFACE), event);
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        Block block = state.getBlock();
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
        Block replacement = BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", String.valueOf(Integer.parseInt(id.getPath().replaceAll("\\D+", "")) + 1))));
        ItemStack item = ((ItemHoldingBlockEntity) level.getBlockEntity(pos)).getStack();
        if (replacement.equals(Blocks.AIR)) {
            level.setBlock(pos, BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", "1"))).defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(COUNTER_SHAPE, state.getValue(COUNTER_SHAPE)), Block.UPDATE_ALL);
        } else {
            level.setBlock(pos, replacement.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(COUNTER_SHAPE, state.getValue(COUNTER_SHAPE)), Block.UPDATE_ALL);
        }
        if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
            entity.setStack(item);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(state.getBlock());
        return BuiltInRegistries.ITEM.get(new ResourceLocation(id.getNamespace(), id.getPath().substring(0, id.getPath().length() - 2))).getDefaultInstance();
    }
}