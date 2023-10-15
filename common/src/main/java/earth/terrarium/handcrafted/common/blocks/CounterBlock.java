package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blockentities.ContainerBlockEntity;
import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.blocks.base.properties.CounterProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.registry.ModSoundEvents;
import earth.terrarium.handcrafted.common.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class CounterBlock extends HorizontalDirectionalBlock implements Hammerable, EntityBlock {
    public static final IntegerProperty TYPE = IntegerProperty.create("type", 1, 3);
    public static final EnumProperty<CounterProperty> COUNTER = EnumProperty.create("counter", CounterProperty.class);

    public CounterBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(TYPE, 1)
            .setValue(COUNTER, CounterProperty.CALCITE)
        );
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && state.getBlock() != newState.getBlock() && !state.getValue(COUNTER).toBlock().is(Items.CALCITE)) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), state.getValue(COUNTER).toBlock());
        }
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) return InteractionResult.CONSUME_PARTIAL;

        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(ModItems.HAMMER.get())) return InteractionResult.PASS;

        if (stack.is(ModItemTags.COUNTER_MATERIALS) && state.getValue(COUNTER) == CounterProperty.CALCITE) {
            BlockState newState = state.setValue(COUNTER, CounterProperty.fromBlock(stack.getItem()));
            level.setBlockAndUpdate(pos, newState);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            SoundEvent event = player.getMainHandItem().is(ItemTags.PLANKS) ? SoundEvents.WOOD_PLACE : SoundEvents.STONE_PLACE;
            level.playSound(null, pos, event, player.getSoundSource(), 1, 1);
        } else if (stack.isEmpty() && player.isShiftKeyDown() && state.getValue(COUNTER) != CounterProperty.CALCITE) {
            ItemStack block = state.getValue(COUNTER).toBlock();
            BlockState newState = state.setValue(COUNTER, CounterProperty.CALCITE);
            level.setBlockAndUpdate(pos, newState);
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), block);
            SoundEvent event = block.is(ItemTags.PLANKS) ? SoundEvents.WOOD_BREAK : SoundEvents.STONE_BREAK;
            level.playSound(null, pos, event, player.getSoundSource(), 1, 1);
        } else if (level.getBlockEntity(pos) instanceof ContainerBlockEntity container) {
            player.openMenu(container);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, COUNTER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        if (level.isClientSide()) return;
        level.setBlockAndUpdate(pos, state.cycle(TYPE));
        level.playSound(null, pos, ModSoundEvents.HAMMER_WOOD.get(), SoundSource.BLOCKS, 1, 1);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ContainerBlockEntity(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(ConstantComponents.COUNTER);
    }
}
