package earth.terrarium.handcrafted.blocks.couch;

import earth.terrarium.handcrafted.blocks.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CouchBlockEntity extends CushionBenchBlockEntity {
    public CouchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COUCH.get(), blockPos, blockState);
    }
}