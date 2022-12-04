package earth.terrarium.handcrafted.block.chair.couch;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class CouchBlockEntity extends CushionBenchBlockEntity {
    public CouchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COUCH.get(), blockPos, blockState);
        this.setCushion(new ResourceLocation(Handcrafted.MOD_ID + ":white_cushion"));
    }
}