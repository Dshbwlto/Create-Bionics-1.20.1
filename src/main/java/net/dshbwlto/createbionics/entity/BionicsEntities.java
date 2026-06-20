
package net.dshbwlto.createbionics.entity;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, CreateBionics.MOD_ID);

    public static final Supplier<EntityType<AnoleEntity>> ANOLE =
            ENTITIES.register("anole", () -> EntityType.Builder.of(AnoleEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.25f).build("anole"));

    /*
    public static final Supplier<EntityType<OxhaulerEntity>> OXHAULER =
            ENTITIES.register("oxhauler", () -> EntityType.Builder.of(OxhaulerEntity::new, MobCategory.CREATURE)
                    .sized(2f, 2f).build("oxhauler"));
    public static final Supplier<EntityType<RepleteEntity>> REPLETE =
            ENTITIES.register("replete", () -> EntityType.Builder.of(RepleteEntity::new, MobCategory.CREATURE)
                    .sized(4f, 5f).build("replete"));
*/
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}