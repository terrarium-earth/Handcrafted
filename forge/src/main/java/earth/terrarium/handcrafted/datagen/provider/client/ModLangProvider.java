package earth.terrarium.handcrafted.datagen.provider.client;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.codehaus.plexus.util.StringUtils;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator pGenerator) {
        super(pGenerator, Handcrafted.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.handcrafted.main", "Handcrafted");
        add("tooltip.handcrafted.board_help", "Obtained by throwing planks on a Stone Cutter");
        add("tooltip.handcrafted.counter_help", "Place a wood or stone material to change the counter surface");
        add("tooltip.handcrafted.cushion_help", "Place on furniture to change the color");
        add("tooltip.handcrafted.hammer_help", "Changes the look of blocks");
        add("tooltip.handcrafted.hammerable_help", "Hammer to change the look of this block");
        add("tooltip.handcrafted.hold_shift", "Hold shift for more info");
        add("tooltip.handcrafted.kitchen_hood_pipe_hammer", "Hammer to change the direction");
        add("tooltip.handcrafted.sheet_help", "Place on furniture to change the color");
        add("tooltip.handcrafted.shelf_help", "Holds: Potions, Books, Crockery, and Cobwebs");

        ForgeRegistries.BLOCKS.getValues().forEach(block -> {
            ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(block);
            if (blockId.getNamespace().equals(Handcrafted.MOD_ID)) {
                if (blockId.getNamespace().equals(Handcrafted.MOD_ID)) {
                    addBlock(() -> block, StringUtils.capitaliseAllWords(blockId.getPath()
                            .replace("_1", "")
                            .replace("_2", "")
                            .replace("_3", "")
                            .replace("_4", "")
                            .replace("_", " ")
                    ));
                }
            }
        });

        ForgeRegistries.ITEMS.getValues().forEach(item -> {
            if (!(item instanceof BlockItem)) {
                ResourceLocation blockId = ForgeRegistries.ITEMS.getKey(item);
                if (blockId.getNamespace().equals(Handcrafted.MOD_ID)) {
                    addItem(() -> item, StringUtils.capitaliseAllWords(blockId.getPath().replace("_", " ")));
                }
            }
        });
    }
}
