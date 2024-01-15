package earth.terrarium.handcrafted.common.blocks;

import com.mojang.serialization.MapCodec;
import earth.terrarium.handcrafted.common.blockentities.ContainerBlockEntity;
import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.blocks.base.properties.CounterProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.registry.ModItems;
import earth.terrarium.handcrafted.common.registry.ModSoundEvents;
import earth.terrarium.handcrafted.common.utils.InteractionUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
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
    public static final MapCodec<CounterBlock> CODEC = simpleCodec(CounterBlock::new);
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
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && state.getBlock() != newState.getBlock() && !state.getValue(COUNTER).toBlock().is(Items.CALCITE)) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), state.getValue(COUNTER).toBlock());
        }
        if (state.getBlock() != newState.getBlock()) {
            if (level.getBlockEntity(pos) instanceof ContainerBlockEntity container) {
                if (container.getContainerSize() > 0) {
                    Containers.dropContents(level, pos, container);
                    level.updateNeighbourForOutputSignal(pos, this);
                }
            }
            super.onRemove(state, level, pos, newState, moved);
        }
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        var result = InteractionUtils.interactCounter(state, level, pos, player, hand, COUNTER);
        if (result != InteractionResult.PASS || !(level.getBlockEntity(pos) instanceof ContainerBlockEntity container)) {
            return result;
        } else if (player.getItemInHand(hand).is(ModItems.HAMMER.get())) {
            return InteractionResult.PASS;
        }
        player.openMenu(container);
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
        tooltip.add(ConstantComponents.HAMMER_USE_LOOK);
    }
}
