package earth.terrarium.handcrafted.common.block.trophy;

import dev.architectury.injectables.annotations.PlatformOnly;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class StatueBlockEntity extends BlockEntity {
    public StatueBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public static StatueBlockEntity ofEntity(BlockPos blockPos, BlockState blockState) {
        return new StatueBlockEntity(ModBlockEntityTypes.STATUE_ENTITY.get(), blockPos, blockState);
    }

    public static StatueBlockEntity ofBlock(BlockPos blockPos, BlockState blockState) {
        return new StatueBlockEntity(ModBlockEntityTypes.STATUE_BLOCK.get(), blockPos, blockState);
    }

    @PlatformOnly("forge")
    public AABB getRenderBoundingBox() {
        return new AABB(this.getBlockPos()).inflate(2);
    }
}