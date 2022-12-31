package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.item.HammerItem;
import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class CupboardBlock extends BaseEntityBlock implements Hammerable {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CupboardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        Block block = state.getBlock();
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
        Block replacement = BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", String.valueOf(Integer.parseInt(id.getPath().replaceAll("\\D+", "")) + 1))));
        CompoundTag tag = null;
        if (level.getBlockEntity(pos) instanceof StorageBlockEntity storage) {
            tag = storage.saveWithoutMetadata();
        }
        if (replacement == Blocks.AIR) {
            level.setBlock(pos, BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", "1"))).defaultBlockState().setValue(FACING, state.getValue(FACING)), Block.UPDATE_ALL);
        } else {
            level.setBlock(pos, replacement.defaultBlockState().setValue(FACING, state.getValue(FACING)), Block.UPDATE_ALL);
        }
        if (tag != null) {
            if (level.getBlockEntity(pos) instanceof StorageBlockEntity storage) {
                storage.load(tag);
            }
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(state.getBlock());
        return BuiltInRegistries.ITEM.get(new ResourceLocation(id.getNamespace(), id.getPath().substring(0, id.getPath().length() - 2))).getDefaultInstance();
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem() instanceof HammerItem) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof StorageBlockEntity storage) {
                player.openMenu(storage);
            }

            return InteractionResult.CONSUME;
        }
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock()) && !(newState.getBlock() instanceof CupboardBlock)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(level, pos, (Container) blockEntity);
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StorageBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}