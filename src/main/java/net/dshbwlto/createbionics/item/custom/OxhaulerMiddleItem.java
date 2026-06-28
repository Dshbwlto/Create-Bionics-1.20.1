
package net.dshbwlto.createbionics.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.context.UseOnContext;

public class OxhaulerMiddleItem extends SpawnEggItem {

    public OxhaulerMiddleItem(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor, Properties properties) {
        super(defaultType, backgroundColor, highlightColor, properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        context.getPlayer().displayClientMessage(Component.translatable("entity.createbionics.all.assembly",
                Component.translatable("item.createbionics.oxhauler_rear_item")), true);
        return super.useOn(context);
    }
}
