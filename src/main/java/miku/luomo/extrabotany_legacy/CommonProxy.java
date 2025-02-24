package miku.luomo.extrabotany_legacy;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.LOG;

import java.time.LocalDateTime;
import java.time.Month;

import net.minecraft.potion.Potion;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import miku.luomo.extrabotany_legacy.common.core.config.ConfigHandler;
import miku.luomo.extrabotany_legacy.common.handler.ModFuelHandler;
import miku.luomo.extrabotany_legacy.common.register.ModItemRegister;

public class CommonProxy {

    public static boolean christmas = false;
    public static boolean halloween = false;

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {

        ConfigHandler.INSTANCE.loadConfig(event);
        GameRegistry.registerFuelHandler(new ModFuelHandler());
        LocalDateTime now = LocalDateTime.now();

        if ((now.getMonth() == Month.DECEMBER && now.getDayOfMonth() >= 16
            || (now.getMonth() == Month.JANUARY && now.getDayOfMonth() <= 2))) {
            christmas = true;
        } else if (now.getMonth() == Month.OCTOBER) {
            halloween = true;
        }
        if (halloween) LOG.info("Trick or treat?");
        if (christmas) LOG.info("Happy Christmas!");

        ModItemRegister.registerItems();

        LOG.info("药水ID范围:{}", Potion.potionTypes.length);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {}

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
