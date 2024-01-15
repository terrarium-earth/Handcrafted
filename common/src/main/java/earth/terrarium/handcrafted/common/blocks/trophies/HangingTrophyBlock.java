package earth.terrarium.handcrafted.common.blocks.trophies;

import com.mojang.serialization.MapCodec;
import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class HangingTrophyBlock extends SimpleBlock {
    public static final MapCodec<HangingTrophyBlock> CODEC = simpleCodec(HangingTrophyBlock::new);

    public HangingTrophyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
