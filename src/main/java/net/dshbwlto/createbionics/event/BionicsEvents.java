package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BionicsEvents {

    @SubscribeEvent
    public static void scareEntity(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Spider spider) {
            spider.goalSelector.addGoal(1, new AvoidEntityGoal(spider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
            spider.goalSelector.addGoal(1, new AvoidEntityGoal(spider, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof CaveSpider caveSpider) {
            caveSpider.goalSelector.addGoal(1, new AvoidEntityGoal(caveSpider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
            caveSpider.goalSelector.addGoal(1, new AvoidEntityGoal(caveSpider, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof Silverfish silverfish) {
            silverfish.goalSelector.addGoal(1, new AvoidEntityGoal(silverfish, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
            silverfish.goalSelector.addGoal(1, new AvoidEntityGoal(silverfish, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof Bee bee) {
            bee.goalSelector.addGoal(1, new AvoidEntityGoal(bee, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
            bee.goalSelector.addGoal(1, new AvoidEntityGoal(bee, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
    }
}
