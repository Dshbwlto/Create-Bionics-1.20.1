
package net.dshbwlto.createbionics.screen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.screen.custom.OxhaulerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BionicsMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CreateBionics.MOD_ID);

    public static final RegistryObject<MenuType<OxhaulerMenu>> OXHAULER_MENU =
            registerMenuType("oxhauler_menu", OxhaulerMenu::create);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
