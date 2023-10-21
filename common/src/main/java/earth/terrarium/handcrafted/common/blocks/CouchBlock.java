package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blocks.base.ModularSeatBlock;
import earth.terrarium.handcrafted.common.blocks.base.properties.ColorProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.ModularSeatProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class CouchBlock extends ModularSeatBlock {
    public static final EnumProperty<ColorProperty> COLOR = EnumProperty.create("color", ColorProperty.class);

    public static final AABB SEAT = new AABB(0, 0, 0, 1, 0.125f, 1);
    public static final VoxelShape VOXEL_SHAPE = box(0, 0, 0, 16, 5, 16);

    public CouchBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(SHAPE, ModularSeatProperty.SINGLE)
            .setValue(COLOR, ColorProperty.WHITE)
            .setValue(FACING, net.minecraft.core.Direction.NORTH)
            .setValue(WATERLOGGED, false)
        );
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && state.getBlock() != newState.getBlock() && state.getValue(COLOR) != ColorProperty.WHITE) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), state.getValue(COLOR).toCushion());
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return SEAT;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && stack.is(ModItemTags.CUSHIONS) && state.getValue(COLOR) == ColorProperty.WHITE) {
            BlockState newState = state.setValue(COLOR, ColorProperty.fromCushion(stack.getItem()));
            level.setBlockAndUpdate(pos, newState);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            level.playSound(null, pos, SoundEvents.WOOL_PLACE, player.getSoundSource(), 1, 1);
            return InteractionResult.SUCCESS;
        } else if (!level.isClientSide() && stack.isEmpty() && player.isShiftKeyDown() && state.getValue(COLOR) != ColorProperty.WHITE) {
            ItemStack cushion = state.getValue(COLOR).toCushion();
            BlockState newState = state.setValue(COLOR, ColorProperty.WHITE);
            level.setBlockAndUpdate(pos, newState);

            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), cushion);
            level.playSound(null, pos, SoundEvents.WOOL_BREAK, player.getSoundSource(), 1, 1);
            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(ConstantComponents.CUSHION);
    }
}
