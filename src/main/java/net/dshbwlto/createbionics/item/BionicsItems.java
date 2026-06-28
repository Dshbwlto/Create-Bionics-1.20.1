
package net.dshbwlto.createbionics.item;

import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.createmod.catnip.lang.FontHelper;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.item.custom.*;
import net.dshbwlto.createbionics.registry.custom.BionicsRegistrate;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.tags.ItemTags;

import net.minecraft.world.item.*;

public class BionicsItems {
    public static final BionicsRegistrate REGISTRATE = CreateBionics.registrate();
    static {
        REGISTRATE.setTooltipModifierFactory(item ->
                new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                        .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
        );
    }

    public static final ItemEntry<RobotBuilderItem> ROBOT_BUILDER = REGISTRATE.item("robot_builder", RobotBuilderItem::new)
            .properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<AnoleItem> ANOLE = REGISTRATE.item("anole_item",
            properties -> new AnoleItem(BionicsEntities.ANOLE,
                    0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();

    public static final ItemEntry<Item> ANOLE_BODY = REGISTRATE.item("anole_body_item",
            Item::new).properties(properties -> properties.stacksTo(1)) .register();
    public static final ItemEntry<Item> ANOLE_HEAD = REGISTRATE.item("anole_head_item",
            Item::new).properties(properties -> properties.stacksTo(1)) .register();
    public static final ItemEntry<Item> ANOLE_LEG = REGISTRATE.item("anole_leg_item",
            Item::new).properties(properties -> properties.stacksTo(1)) .register();
    public static final ItemEntry<Item> ANOLE_TAIL = REGISTRATE.item("anole_tail_item",
            Item::new).properties(properties -> properties.stacksTo(1)) .register();
    public static final ItemEntry<Item> SIMPLE_ENGINE = REGISTRATE.item("simple_engine",
            Item::new).properties(properties -> properties.stacksTo(1)) .register();
    public static final ItemEntry<Item> OXHAULER_ENGINE = REGISTRATE.item("oxhauler_engine_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<OxhaulerMiddleItem> OXHAULER_MIDDLE = REGISTRATE.item("oxhauler_middle_item",
            properties -> new OxhaulerMiddleItem(BionicsEntities.OXHAULER.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> OXHAULER_FRONT = REGISTRATE.item("oxhauler_front_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> OXHAULER_REAR = REGISTRATE.item("oxhauler_rear_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<OxhaulerHeadItem> OXHAULER_HEAD = REGISTRATE.item("oxhauler_head_item",
            OxhaulerHeadItem::new).properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<RecordItem> WALTZ_2_MUSIC_DISC =
            REGISTRATE.item("waltz_2_music_disc", properties -> new RecordItem(15, BionicsSounds.WALTZ_2, properties, 227 * 20))
                    .properties(properties -> properties.stacksTo(1).rarity(Rarity.RARE))
                    .tag(ItemTags.MUSIC_DISCS)
                    .lang("Music Disc")
                    .register();

    public static void register() {}
}