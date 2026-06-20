package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.anole.AnoleModel;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateBionics.MOD_ID)
public class BionicsEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BionicsModelLayers.ANOLE, AnoleModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.ANOLE_MARKINGS, AnoleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BionicsEntities.ANOLE.get(), AnoleEntity.createAttributes().build());
        //event.put(BionicsEntities.OXHAULER.get(), OxhaulerEntity.createAttributes().build());
        //event.put(BionicsEntities.REPLETE.get(), RepleteEntity.createAttributes().build());
    }
}
