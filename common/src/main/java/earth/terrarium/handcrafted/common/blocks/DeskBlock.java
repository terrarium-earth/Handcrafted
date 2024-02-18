package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blockentities.ContainerBlockEntity;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class DeskBlock extends SimpleTableBlock implements EntityBlock {
    public static final VoxelShape SHAPE = Stream.of(
        Block.box(0, 12, 0, 16, 16, 16),
        Block.box(2, 3, 2, 14, 12, 14),
        Block.box(12, 0, 12, 15, 12, 15),
        Block.box(12, 0, 1, 15, 12, 4),
        Block.box(1, 0, 1, 4, 12, 4),
        Block.box(1, 0, 12, 4, 12, 15)
    ).reduce(Shapes::or).get();

    public DeskBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ContainerBlockEntity(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.HAMMER);
    }
}
