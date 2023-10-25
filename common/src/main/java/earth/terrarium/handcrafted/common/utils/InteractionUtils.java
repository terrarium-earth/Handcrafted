package earth.terrarium.handcrafted.common.utils;

import earth.terrarium.handcrafted.common.blocks.base.properties.ColorProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.CounterProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.OptionalColorProperty;
import earth.terrarium.handcrafted.common.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public final class InteractionUtils {

    public static InteractionResult interactOptionalCushion(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, EnumProperty<OptionalColorProperty> colorProperty) {
        ItemStack stack = player.getItemInHand(hand);
        var colorState = state.getValue(colorProperty);

        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (stack.is(ModItemTags.CUSHIONS) && colorState == OptionalColorProperty.NONE) {
            level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.fromCushion(stack.getItem())));
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        } else if (colorState != OptionalColorProperty.NONE) {
            ItemStack cushion = colorState.toCushion();
            if (stack.is(ModItemTags.CUSHIONS) && !stack.is(cushion.getItem())) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.fromCushion(stack.getItem())));
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
                if (!player.getAbilities().instabuild) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), cushion);
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.NONE));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), cushion);
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult interactCushion(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, EnumProperty<ColorProperty> colorProperty) {
        ItemStack stack = player.getItemInHand(hand);
        var colorState = state.getValue(colorProperty);

        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (stack.is(ModItemTags.CUSHIONS) && colorState == ColorProperty.WHITE) {
            level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.fromCushion(stack.getItem())));
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        } else if (colorState != ColorProperty.WHITE) {
            ItemStack cushion = colorState.toCushion();
            if (stack.is(ModItemTags.CUSHIONS) && !stack.is(cushion.getItem())) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.fromCushion(stack.getItem())));
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
                if (!player.getAbilities().instabuild) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), cushion);
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.WHITE));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), cushion);
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult interactOptionalSheet(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, EnumProperty<OptionalColorProperty> colorProperty) {
        ItemStack stack = player.getItemInHand(hand);
        var colorState = state.getValue(colorProperty);

        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (stack.is(ModItemTags.SHEETS) && colorState == OptionalColorProperty.NONE) {
            level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.fromSheet(stack.getItem())));
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        } else if (colorState != OptionalColorProperty.NONE) {
            ItemStack sheet = colorState.toSheet();
            if (stack.is(ModItemTags.SHEETS) && !stack.is(sheet.getItem())) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.fromSheet(stack.getItem())));
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
                if (!player.getAbilities().instabuild) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), sheet);
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, OptionalColorProperty.NONE));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), sheet);
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult interactSheet(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, EnumProperty<ColorProperty> colorProperty) {
        ItemStack stack = player.getItemInHand(hand);
        var colorState = state.getValue(colorProperty);

        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (stack.is(ModItemTags.SHEETS) && colorState == ColorProperty.WHITE) {
            level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.fromSheet(stack.getItem())));
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        } else if (colorState != ColorProperty.WHITE) {
            ItemStack sheet = colorState.toSheet();
            if (stack.is(ModItemTags.SHEETS) && !stack.is(sheet.getItem())) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.fromSheet(stack.getItem())));
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
                if (!player.getAbilities().instabuild) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), sheet);
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.setValue(colorProperty, ColorProperty.WHITE));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), sheet);
                level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult interactCounter(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, EnumProperty<CounterProperty> counterProperty) {
        ItemStack stack = player.getItemInHand(hand);
        var counterState = state.getValue(counterProperty);

        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (stack.is(ModItemTags.COUNTER_MATERIALS) && counterState == CounterProperty.CALCITE) {
            level.setBlockAndUpdate(pos, state.setValue(counterProperty, CounterProperty.fromBlock(stack.getItem())));
            SoundEvent event = player.getMainHandItem().is(ItemTags.PLANKS) ? SoundEvents.WOOD_PLACE : SoundEvents.STONE_PLACE;
            level.playSound(null, pos, event, player.getSoundSource(), 1, 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        } else if (counterState != CounterProperty.CALCITE) {
            ItemStack countertop = counterState.toBlock();
            if (stack.is(ModItemTags.COUNTER_MATERIALS) && !stack.is(countertop.getItem())) {
                level.setBlockAndUpdate(pos, state.setValue(counterProperty, CounterProperty.fromBlock(stack.getItem())));

                SoundEvent event = countertop.is(ItemTags.PLANKS) ? SoundEvents.WOOD_BREAK : SoundEvents.STONE_BREAK;
                level.playSound(null, pos, event, player.getSoundSource(), 1, 1);
                event = player.getMainHandItem().is(ItemTags.PLANKS) ? SoundEvents.WOOD_PLACE : SoundEvents.STONE_PLACE;
                level.playSound(null, pos, event, player.getSoundSource(), 1, 1);

                if (!player.getAbilities().instabuild) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), countertop);
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.setValue(counterProperty, CounterProperty.CALCITE));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), countertop);
                SoundEvent event = countertop.is(ItemTags.PLANKS) ? SoundEvents.WOOD_BREAK : SoundEvents.STONE_BREAK;
                level.playSound(null, pos, event, player.getSoundSource(), 1, 1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
