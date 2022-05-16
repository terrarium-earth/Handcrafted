package earth.terrarium.handcrafted;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Handcrafted.MOD_ID)
public class Handcrafted {
    public static final String MOD_ID = "handcrafted";

    public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID + ".tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HandcraftedBlocks.NORDIC_PLANKS.get());
        }
    };

    static final DeferredRegister<Block> BLOCK_REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    static final DeferredRegister<Item> ITEM_REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static final RegistryObject<EntityType<ChairSeatEntity>> SEAT_ENTITY = ENTITY_REGISTRAR.register("chair_seat", () -> EntityType.Builder.<ChairSeatEntity>of(ChairSeatEntity::new, MobCategory.MISC).sized(0.001F, 0.001F).build("chair_seat"));

    public Handcrafted() {
        final var bus = FMLJavaModLoadingContext.get().getModEventBus();
        HandcraftedBlocks.resolveClass();
        BLOCK_REGISTRAR.register(bus);
        ITEM_REGISTRAR.register(bus);
        ENTITY_REGISTRAR.register(bus);
        bus.addListener(Handcrafted::clientSetup);
    }

    private static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(SEAT_ENTITY.get(), HandcraftedClient.MountableEntityRenderer::new);
        HandcraftedClient.initialize();
    }
}
