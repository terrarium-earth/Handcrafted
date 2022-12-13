package earth.terrarium.handcrafted.common.block.table.nightstand;

import earth.terrarium.handcrafted.common.block.table.table.TableBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NightstandBlockEntity extends TableBlockEntity {
    public NightstandBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.NIGHTSTAND.get(), blockPos, blockState);
    }
}
