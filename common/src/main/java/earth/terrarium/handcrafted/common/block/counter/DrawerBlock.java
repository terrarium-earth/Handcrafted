package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.block.property.DirectionalBlockSide;
import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
public class DrawerBlock extends CupboardBlock implements Hammerable {
    public static final EnumProperty<DirectionalBlockSide> DRAWER_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);

    public DrawerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(DRAWER_SHAPE, DirectionalBlockSide.SINGLE).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DRAWER_SHAPE);
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
        if (replacement.equals(Blocks.AIR)) {
            level.setBlock(pos, BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", "1"))).defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(DRAWER_SHAPE, state.getValue(DRAWER_SHAPE)), Block.UPDATE_ALL);
        } else {
            level.setBlock(pos, replacement.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(DRAWER_SHAPE, state.getValue(DRAWER_SHAPE)), Block.UPDATE_ALL);
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
}