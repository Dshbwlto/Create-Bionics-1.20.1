package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.anole.AnoleModel;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateBionics.MOD_ID)
public class BionicsEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BionicsEntities.ANOLE.get(), AnoleEntity.createAttributes().build());
        //event.put(BionicsEntities.OXHAULER.get(), OxhaulerEntity.createAttributes().build());
        //event.put(BionicsEntities.REPLETE.get(), RepleteEntity.createAttributes().build());
    }


    @SubscribeEvent
    public static void scareEntity(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Spider spider) {
            spider.goalSelector.addGoal(1, new AvoidEntityGoal(spider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
        }
        if (event.getEntity() instanceof CaveSpider caveSpider) {
            caveSpider.goalSelector.addGoal(1, new AvoidEntityGoal(caveSpider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
        }
        if (event.getEntity() instanceof Silverfish silverfish) {
            silverfish.goalSelector.addGoal(1, new AvoidEntityGoal(silverfish, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
        }
        if (event.getEntity() instanceof Bee bee) {
            bee.goalSelector.addGoal(1, new AvoidEntityGoal(bee, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE.asItem()) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE.asItem()));
                }
            });
        }
    }
}
