package net.dshbwlto.createbionics.item;

import com.simibubi.create.Create;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BionicsPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, CreateBionics.MOD_ID);

    public static final RegistryObject<PaintingVariant> ARES = PAINTINGS.register("ares", () -> new PaintingVariant(32, 32 ));
    public static final RegistryObject<PaintingVariant> ANOLE = PAINTINGS.register("anole", () -> new PaintingVariant(32, 80));
    public static final RegistryObject<PaintingVariant> ORGAN = PAINTINGS.register("organ", () -> new PaintingVariant(240, 128));
    public static final RegistryObject<PaintingVariant> OXHAULER = PAINTINGS.register("oxhauler", () -> new PaintingVariant(64, 48));
    public static final RegistryObject<PaintingVariant> REPLETE = PAINTINGS.register("replete", () -> new PaintingVariant(80, 80));

}