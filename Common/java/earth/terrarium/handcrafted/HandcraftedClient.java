package earth.terrarium.handcrafted;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class HandcraftedClient {
    public static void initialize() {
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_SMALL_TABLE, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_NIGHTSTAND, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_ALTERNATE_NIGHTSTAND, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_CHAIR, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_CLOCK, RenderType.cutout());
        //CommonUtils.setBlockLayer(WillowsBlocks.NORDIC_LITTLE_LAMP, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_TALL_LAMP, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_LARGE_TABLE, RenderType.cutout());
        CommonUtils.setBlockLayer(HandcraftedBlocks.NORDIC_LARGE_DESK, RenderType.cutout());
    }

    public static class MountableEntityRenderer extends EntityRenderer<ChairSeatEntity> {
        protected MountableEntityRenderer(EntityRendererProvider.Context context) {
            super(context);
        }

        @Override
        public ResourceLocation getTextureLocation(ChairSeatEntity entity) {
            return null;
        }
    }
}
