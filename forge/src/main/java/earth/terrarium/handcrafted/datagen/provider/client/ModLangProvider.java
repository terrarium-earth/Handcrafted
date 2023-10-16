package earth.terrarium.handcrafted.datagen.provider.client;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, Handcrafted.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ModBlocks.BLOCKS.stream()
            .forEach(entry -> addBlock(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModItems.ITEMS.stream()
            .filter(i -> !(i.get() instanceof BlockItem))
            .forEach(entry -> addItem(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModEntityTypes.ENTITY_TYPES.stream()
            .forEach(entry -> addEntityType(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModItems.CUSHIONS.stream()
            .forEach(entry -> add("item.handcrafted.%s".formatted(entry.getId().getPath()), StringUtils.capitaliseAllWords(entry
                .getId()
                .getPath()
                .replace("_", " "))));

        add("itemGroup.handcrafted.main", "Handcrafted");

        add(ConstantComponents.HAMMER.getString(), "Changes the look of blocks.");
        add(ConstantComponents.HAMMER_USE_LOOK.getString(), "Right-click with a hammer to change the block's look.");
        add(ConstantComponents.HAMMER_USE_SHAPE.getString(), "Right-click with a hammer to change the block's shape.");
        add(ConstantComponents.HAMMER_USE_LOOK_SHIFT.getString(), "Shift-right-click with a hammer to change the block's look.");

        add(ConstantComponents.COUNTER.getString(), "Right-click with wood or stone to change the counter surface.");
        add(ConstantComponents.CROCKERY_COMBO.getString(), "Right-click with any item to place it on the plate.");

        add(ConstantComponents.PLACE_ON_FURNITURE.getString(), "Can be placed on furniture.");
        add(ConstantComponents.CUSHION.getString(), "Right-click with a cushion to change the block's look.");
        add(ConstantComponents.SHEET.getString(), "Right-click with a sheet to change the block's look.");
        add(ConstantComponents.BED_PILLOW.getString(), "Right-click with a cushion to change the bed's pillow color.");
        add(ConstantComponents.BED_SHEET.getString(), "Right-click with a sheet to change the bedsheets.");

        add("subtitles.handcrafted.block.hammer_wood", "Wood is Hammered");
        add("subtitles.handcrafted.block.hammer_stone", "Stone is Hammered");

        add("tag.item.handcrafted.cushions", "Cushions");
        add("tag.item.handcrafted.sheets", "Sheets");
        add("tag.item.handcrafted.couches", "Couches");
        add("tag.item.handcrafted.chairs", "Chairs");
        add("tag.item.handcrafted.dining_benches", "Dining Benches");
        add("tag.item.handcrafted.side_tables", "Side Tables");
        add("tag.item.handcrafted.desks", "Desks");
        add("tag.item.handcrafted.nightstands", "Nightstands");
        add("tag.item.handcrafted.tables", "Tables");
        add("tag.item.handcrafted.fancy_beds", "Fancy Beds");
        add("tag.item.handcrafted.counters", "Counters");
        add("tag.item.handcrafted.cupboards", "Cupboards");
        add("tag.item.handcrafted.drawers", "Drawers");
        add("tag.item.handcrafted.shelves", "Shelves");
        add("tag.item.handcrafted.pots", "Pots");
        add("tag.item.handcrafted.trims", "Trims");
        add("tag.item.handcrafted.trophies", "Trophies");
        add("tag.item.handcrafted.crockery", "Crockery");
        add("tag.item.handcrafted.cups", "Cups");
        add("tag.item.handcrafted.plates", "Plates");
        add("tag.item.handcrafted.bowls", "Bowls");
        add("tag.item.handcrafted.crockery_combos", "Crockery Combos");

        add("painting.handcrafted.pride_steve.author", "Kekie6");
        add("painting.handcrafted.pride_steve.title", "Pride Steve");
        add("painting.handcrafted.beach_sunrise_mid.author", "Kekie6");
        add("painting.handcrafted.beach_sunrise_mid.title", "Beach Sunrise");
        add("painting.handcrafted.apple.author", "Kekie6");
        add("painting.handcrafted.apple.title", "Apple");
        add("painting.handcrafted.small_safari_sunset.author", "Kekie6");
        add("painting.handcrafted.small_safari_sunset.title", "Safari Sunset");
        add("painting.handcrafted.marigold_meadows.author", "Kekie6");
        add("painting.handcrafted.marigold_meadows.title", "Marigold Meadows");
        add("painting.handcrafted.ad_astra.author", "Kekie6");
        add("painting.handcrafted.ad_astra.title", "Ad Astra");

        add("painting.handcrafted.misty_mountains.author", "Kekie6");
        add("painting.handcrafted.misty_mountains.title", "Misty Mountains");
        add("painting.handcrafted.coral_depths.author", "Kekie6");
        add("painting.handcrafted.coral_depths.title", "Coral Depths");
        add("painting.handcrafted.broken_birches.author", "Kekie6");
        add("painting.handcrafted.broken_birches.title", "Broken Birches");
        add("painting.handcrafted.mysterious_mangroves.author", "Kekie6");
        add("painting.handcrafted.mysterious_mangroves.title", "Mysterious Mangroves");
        add("painting.handcrafted.my_man_diorite.author", "Kekie6");
        add("painting.handcrafted.my_man_diorite", "My Man Diorite");
        add("painting.handcrafted.cookies_on_a_plate.author", "Kekie6");
        add("painting.handcrafted.cookies_on_a_plate.title", "Cookies on a Plate");
        add("painting.handcrafted.lava_puddles.author", "Kekie6");
        add("painting.handcrafted.lava_puddles.title", "Lava Puddles");
        add("painting.handcrafted.the_cat_and_the_cup.author", "Kekie6");
        add("painting.handcrafted.the_cat_and_the_cup.title", "The Cat and the Cup");
        add("painting.handcrafted.terrarium.author", "Kekie6");
        add("painting.handcrafted.terrarium.title", "Terrarium");

        add("painting.handcrafted.green_woods.author", "Kekie6");
        add("painting.handcrafted.green_woods.title", "Green Woods");
        add("painting.handcrafted.safari_sunset.author", "Kekie6");
        add("painting.handcrafted.safari_sunset.title", "Safari Sunset");
        add("painting.handcrafted.rocky_beach.author", "Kekie6");
        add("painting.handcrafted.rocky_beach.title", "Rocky Beach");

        add("painting.handcrafted.misty_mountain_left_sidepanel.author", "Kekie6");
        add("painting.handcrafted.misty_mountain_left_sidepanel.title", "Misty Mountain Left Sidepanel");
        add("painting.handcrafted.misty_mountain_right_sidepanel.author", "Kekie6");
        add("painting.handcrafted.misty_mountain_right_sidepanel.title", "Misty Mountain Right Sidepanel");
        add("painting.handcrafted.broken_birches_left_sidepanel.author", "Kekie6");
        add("painting.handcrafted.broken_birches_left_sidepanel.title", "Broken Birches Left Sidepanel");
        add("painting.handcrafted.broken_birches_right_sidepanel.author", "Kekie6");
        add("painting.handcrafted.broken_birches_right_sidepanel.title", "Broken Birches Right Sidepanel");

        add("painting.handcrafted.desert_plateau.author", "Kekie6");
        add("painting.handcrafted.desert_plateau.title", "Desert Plateau");
        add("painting.handcrafted.beach_sunrise_right.author", "Kekie6");
        add("painting.handcrafted.beach_sunrise_right.title", "Beach Sunrise Right");
        add("painting.handcrafted.beach_sunrise_left.author", "Kekie6");
        add("painting.handcrafted.beach_sunrise_left.title", "Beach Sunrise Left");
        add("painting.handcrafted.nian_cat.author", "Kekie6");
        add("painting.handcrafted.nian_cat.title", "Nian Cat");
    }
}
