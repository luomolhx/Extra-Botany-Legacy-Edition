package miku.luomo.extrabotany_legacy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(
    modid = ExtraBotanyLegacy.MODID,
    version = Tags.VERSION,
    name = "Extra Botany: Legacy Edition",
    dependencies = "required-after:Botania",
    acceptedMinecraftVersions = "[1.7.10]")
public class ExtraBotanyLegacy {

    public static final String MODID = "extrabotany_legacy";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "miku.luomo.extrabotany_legacy.ClientProxy",
        serverSide = "miku.luomo.extrabotany_legacy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static ExtraBotanyLegacy instance;

    public static CreativeTabs extraBotanyTap = new CreativeTabs(MODID) {

        @Override
        public Item getTabIconItem() {
            return null;
        }
    };

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
