package miku.luomo.extrabotany_legacy.common.core.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class ConfigHandler {

    public static final ConfigHandler INSTANCE = new ConfigHandler();
    public static Configuration CONFIG;

    public static int CRAFTING_STRIKES;

    public static int EFF_OMNIVIOLET;
    public static int BOOK_BURNTIME;
    public static int WRITTENBOOK_BURNTIME;

    public static int EFF_BELLFLOWER;
    public static int BASEY;

    public static int EFF_BLOODYENCHANTRESS;
    public static int BLOOD_BURNTIME;

    public static int EFF_MOONBLESS;
    public static int EFF_SUNBLESS;
    public static int EFF_TINKLE;
    public static int EFF_STONESIA;

    public static double EFF_GEMINIORCHID;
    public static double EFF_ELDELWEISS;

    public static int ANNOYINGFLOWER_COST;
    public static int TICKS;
    public static int TIMES;

    public static int BASECOST;
    public static int PERCOST;
    public static int CONSUMESPEED;

    public static int SPEED;

    public static boolean LP_STONESIA;
    public static boolean LP_BELLFLOWER;
    public static boolean LP_OMNIVIOLET;
    public static boolean LP_TINKLE;

    public static int RL_BASEGEN;
    public static int RL_BURNTIME;
    public static int RL_EFF;
    public static int RL_COOLDOWN;
    public static int RL_CD;
    public static int RL_BASEY;

    public static int EO_RANGE;
    public static int EO_COST;
    public static int EO_SPEED;

    public static int MB_SPEED;

    public static boolean GAIA_ENABLE = true;
    public static boolean GAIA_DISARM = true;
    public static boolean GAIA_SMASH = false;
    public static boolean GAIA_DIVINEJUDGE = true;

    public static boolean ENABLE_AF;
    public static boolean ENABLE_EO;
    public static boolean ENABLE_ML;
    public static boolean ENABLE_SL;
    public static boolean ENABLE_BF;
    public static boolean ENABLE_BE;
    public static boolean ENABLE_MB;
    public static boolean ENABLE_OV;
    public static boolean ENABLE_RL;
    public static boolean ENABLE_SS;
    public static boolean ENABLE_SB;
    public static boolean ENABLE_TK;
    public static boolean ENABLE_EW;
    public static boolean ENABLE_MT;
    public static boolean ENABLE_GO;
    public static boolean ENABLE_NF;

    public static boolean ENABLE_TOOLTIP;
    public static boolean ENABLE_SHIELD;

    public static int MG_MAXENERGY;
    public static int MG_CONVERT;
    public static int MG_TRANSFERSPEED;

    public static boolean DISABLE_MANAGENERATOR = false;
    public static boolean DISABLE_MANALIQUEFICATION = false;

    public static boolean ENABLE_WAILAPOOL = false;
    public static boolean ENABLE_WAILAMANAGEN = false;
    public static boolean ENABLE_WAILAMANABUFFER = false;
    public static boolean ENABLE_WAILAMANALIQUE = false;

    public static boolean ENABLE_CASUPPORT = false;

    public static boolean ENABLE_TOP = false;

    public static boolean ENABLE_FEATURES = true;
    public static boolean ENABLE_HERRSCHER = true;
    public static boolean ENABLE_ADS = true;

    public static boolean ENABLE_CANDYBAGDROP = true;
    public static boolean DISABLE_ADVANCEMENTREQUIREMENT = false;
    public static double CANDYBAG_DROPCHANCE = 0.02F;
    public static double PARTICLE = 1F;
    public static String[] WHITELIST = new String[] {};
    public static String[] REWARDBAG1 = new String[] {};
    public static String[] REWARDBAG2 = new String[] {};
    public static String[] REWARDBAG3 = new String[] {};
    public static String[] REWARDBAG4 = new String[] {};
    public static String[] REWARDBAG5 = new String[] {};
    public static String[] REWARDBAG6 = new String[] {};
    public static boolean ENABLE_TRUEDAMAGE = true;
    public static boolean ENABLE_ILLEGALACTION = false;

    public static int INITIAL_LIQUEFACTION_ENERGY = 0;
    public static int MAX_LIQUEFACTION_MANA = 1000000;
    public static int LIQUEFACTION_STORAGE_DRAIN = 1;
    public static int LIQUEFACTION_STORAGE_DRAIN_CONTAINER = 1;
    public static int LIQUEFACTION_STORAGE_PUMP = 25;
    public static int LIQUEFACTION_STORAGE_PUMP_CONTAINER = 25;
    public static int LIQUEFACTION_MANA_RECEIVE = 2000;
    public static int LIQUEFACTION_ENERGY_LOSS = 2;
    public static int LIQUEFACTION_MANA_GIVE = 2000;
    public static int LIQUEFACTION_ENERGY_GAIN = 2;

    public void loadConfig(FMLPreInitializationEvent event) {
        CONFIG = new Configuration(event.getSuggestedConfigurationFile());
        CONFIG.load();
        syncConfigs();
    }

    private void syncConfigs() {
        String desc;

        desc = "Whether to enable Waila Support for Mana Pool. Default is true. Require MC restart.";
        ENABLE_WAILAPOOL = loadPropBool("waila.pool", desc, ENABLE_WAILAPOOL);
        desc = "Whether to enable Waila Support for Flux Manafield. Default is true. Require MC restart.";
        ENABLE_WAILAMANAGEN = loadPropBool("waila.managenerator", desc, ENABLE_WAILAMANAGEN);
        desc = "Whether to enable Waila Support for Mana Buffer. Default is true. Require MC restart.";
        ENABLE_WAILAMANABUFFER = loadPropBool("waila.manabuffer", desc, ENABLE_WAILAMANABUFFER);
        desc = "Whether to enable Waila Support for Mana Liquefaction Device. Default is true. Require MC restart.";
        ENABLE_WAILAMANALIQUE = loadPropBool("waila.manaliquefaction", desc, ENABLE_WAILAMANALIQUE);

        desc = "Whether to enable The One Probe Support. Default is true. Require MC restart.";
        ENABLE_TOP = loadPropBool("enable.topsupport", desc, ENABLE_TOP);

        desc = "Whether to enable Flux Manafield. Default is true.";
        DISABLE_MANAGENERATOR = loadPropBool("enable.managenerator", desc, DISABLE_MANAGENERATOR);
        desc = "Whether to enable Mana Liquefaction Device. Default is true.";
        DISABLE_MANALIQUEFICATION = loadPropBool("enable.manaliquefaction", desc, DISABLE_MANALIQUEFICATION);
        desc = "Whether to enable the Summoning of Gaia Guardian III. Default is true.";
        GAIA_ENABLE = loadPropBool("enable.gaiaspawning", desc, GAIA_ENABLE);
        desc = "Whether Gaia Guardian III will disarm or not. Default is true.";
        GAIA_DISARM = loadPropBool("enable.gaiadisarm", desc, GAIA_DISARM);
        desc = "Whether Gaia Guardian III will destroy other mod's blocks. Default is false.";
        GAIA_SMASH = loadPropBool("enable.gaiasmash", desc, GAIA_SMASH);
        desc = "Whether Gaia Guardian III will release Divine Judge. Default is true.";
        GAIA_DIVINEJUDGE = loadPropBool("enable.divinejudge", desc, GAIA_DIVINEJUDGE);
        desc = "Amount of Particles during Gaia Guardian III fight. Default is 100%.";
        PARTICLE = loadPropDouble("gaia.particle", desc, PARTICLE);
        desc = "Whether Monster will have the chance to hold a Halloween Candy Night when spawning. Default is true.";
        ENABLE_CANDYBAGDROP = loadPropBool("enable.candybag", desc, ENABLE_CANDYBAGDROP);
        desc = "The Chance a monster will hold a Halloween Candy Night. Default is 2%.";
        CANDYBAG_DROPCHANCE = loadPropDouble("chance.candybag", desc, CANDYBAG_DROPCHANCE);
        desc = "Whether to enable Construct's Armory Compat. Default is false.";
        ENABLE_CASUPPORT = loadPropBool("enable.ca", desc, ENABLE_CASUPPORT);
        desc = "Whether to enable Herrscher of The Void. Default is true.";
        ENABLE_HERRSCHER = loadPropBool("enable.herrscher", desc, ENABLE_HERRSCHER);
        desc = "Whether to enable Advertisement Message. Default is true.";
        ENABLE_ADS = loadPropBool("enable.advertisement", desc, ENABLE_ADS);
        desc = "Whether to enable True Damage. Set false to make all true damage become normal one.Default is true.";
        ENABLE_TRUEDAMAGE = loadPropBool("enable.truedamage", desc, ENABLE_TRUEDAMAGE);
        desc = "Whether to disable advancement requirement for relics. Set true to make all relics no longer require advancements.Default is false.";
        DISABLE_ADVANCEMENTREQUIREMENT = loadPropBool(
            "disable.advancementrequirement",
            desc,
            DISABLE_ADVANCEMENTREQUIREMENT);
        desc = "Whether to disable spam in logs. Set false to disable it.";
        ENABLE_FEATURES = loadPropBool("enable.features", desc, ENABLE_FEATURES);
        desc = "Whether to enable that there can be more people than when the boss is summoned. Set true to enable it";
        ENABLE_ILLEGALACTION = loadPropBool("enable.illegalpeople", desc, ENABLE_ILLEGALACTION);

        WHITELIST = CONFIG.getStringList(
            "GaiaIII Disarm Whitelist",
            Configuration.CATEGORY_GENERAL,
            new String[] {},
            "syntax: modid:name or modid:name:meta");
        String descReward = "syntax: modid:name:weight or modid:name:weight:meta or modid:name:weight:meta:stacksize";
        REWARDBAG1 = CONFIG.getStringList(
            "Reward Bag A list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "botania:petal:6:0:6", "botania:petal:6:1:6", "botania:petal:6:2:6", "botania:petal:6:3:6",
                "botania:petal:6:4:6", "botania:petal:6:5:6", "botania:petal:6:6:6", "botania:petal:6:7:6",
                "botania:petal:6:8:6", "botania:petal:6:9:6", "botania:petal:6:10:6", "botania:petal:6:11:6",
                "botania:petal:6:12:6", "botania:petal:6:13:6", "botania:petal:6:14:6", "botania:petal:6:15:6" },
            descReward);
        REWARDBAG2 = CONFIG.getStringList(
            "Reward Bag B list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "botania:rune:8:0:2", "botania:rune:8:1:2", "botania:rune:8:2:2", "botania:rune:8:3:2",
                "botania:rune:5:4", "botania:rune:5:5", "botania:rune:5:6", "botania:rune:5:7", "botania:rune:3:8",
                "botania:rune:3:9", "botania:rune:3:10", "botania:rune:3:11", "botania:rune:3:12", "botania:rune:3:13",
                "botania:rune:3:14", "botania:rune:3:15" },
            descReward);
        REWARDBAG3 = CONFIG.getStringList(
            "Reward Bag C list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "botania:manaresource:15:0:4", "botania:manaresource:15:1:4", "botania:manaresource:15:2:4",
                "botania:manaresource:9:4", "botania:manaresource:10:23:8", "botania:manaresource:7:14",
                "botania:manaresource:8:5:3", "botania:manaresource:11:7:3", "botania:manaresource:11:8:3",
                "botania:manaresource:11:9:3", "extrabotany:material:1:3" },
            descReward);
        REWARDBAG4 = CONFIG.getStringList(
            "Reward Bag D list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "minecraft:iron_ingot:36:0:4", "minecraft:diamond:18:0:1", "minecraft:coal:40:0:6",
                "minecraft:gold_ingot:24:0:4", "minecraft:ender_pearl:20:0:4", "minecraft:redstone:22:0:8",
                "botania:blacklotus:16:0:2", "botania:overgrowthseed:12:0:1", "extrabotany:buddhistrelics:1" },
            descReward);
        REWARDBAG5 = CONFIG.getStringList(
            "Reward Bag E list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "extrabotany:rewardbag:33:0:16", "extrabotany:rewardbag:23:1:10",
                "extrabotany:rewardbag:13:2:6", "extrabotany:rewardbag:13:3:6", "botania:manaresource:23:14",
                "botania:manaresource:20:4:5", "extrabotany:material:45:6", "extrabotany:material:1:3" },
            descReward);

        REWARDBAG6 = CONFIG.getStringList(
            "Candy Bag list",
            Configuration.CATEGORY_GENERAL,
            new String[] { "extrabotany:candy:25:0:3", "extrabotany:candy:25:1:3", "extrabotany:candy:25:2:3",
                "minecraft:pumpkin_pie:15", "minecraft:gold_ingot:10", "minecraft:golden_apple:1:1" },
            descReward);

        ENABLE_AF = CONFIG.get("enable flowers", "annoying flower", true)
            .getBoolean(true);
        ENABLE_EO = CONFIG.get("enable flowers", "enchanted orchid", true)
            .getBoolean(true);
        ENABLE_ML = CONFIG.get("enable flowers", "manalinkium", true)
            .getBoolean(true);
        ENABLE_SL = CONFIG.get("enable flowers", "stardust lotus", true)
            .getBoolean(true);
        ENABLE_BF = CONFIG.get("enable flowers", "bell flower", true)
            .getBoolean(true);
        ENABLE_BE = CONFIG.get("enable flowers", "bloody enchantress", true)
            .getBoolean(true);
        ENABLE_MB = CONFIG.get("enable flowers", "moonlight lily", true)
            .getBoolean(true);
        ENABLE_OV = CONFIG.get("enable flowers", "omniviolet", true)
            .getBoolean(true);
        ENABLE_RL = CONFIG.get("enable flowers", "reikar lily", true)
            .getBoolean(true);
        ENABLE_SS = CONFIG.get("enable flowers", "stonesia", true)
            .getBoolean(true);
        ENABLE_SB = CONFIG.get("enable flowers", "sunshine lily", true)
            .getBoolean(true);
        ENABLE_TK = CONFIG.get("enable flowers", "tinkle flower", true)
            .getBoolean(true);
        ENABLE_EW = CONFIG.get("enable flowers", "edelweiss", true)
            .getBoolean(true);
        ENABLE_MT = CONFIG.get("enable flowers", "mirrowtunia", true)
            .getBoolean(true);
        ENABLE_GO = CONFIG.get("enable flowers", "geminiorchid", true)
            .getBoolean(true);
        ENABLE_NF = CONFIG.get("enable flowers", "necrofleur", true)
            .getBoolean(true);

        ENABLE_SHIELD = CONFIG.get("enable shields", "enable non-relic shields", true)
            .getBoolean(true);

        MG_MAXENERGY = CONFIG.getInt("max energy stored", "flux manafield", 40000, 1, Integer.MAX_VALUE, "");
        MG_CONVERT = CONFIG
            .getInt("1000 FE converts to how much. Default is 99", "flux manafield", 99, 1, Integer.MAX_VALUE, "");
        MG_TRANSFERSPEED = CONFIG
            .getInt("the speed it transfer mana to spreader", "flux manafield", 200, 1, Integer.MAX_VALUE, "");

        CRAFTING_STRIKES = CONFIG.getInt("pedestal", "strike times", 5, 1, Integer.MAX_VALUE, "");

        EFF_OMNIVIOLET = CONFIG.getInt("mana per tick", "omniviolet", 8, 1, Integer.MAX_VALUE, "");
        BOOK_BURNTIME = CONFIG.getInt("book burn time", "omniviolet", 50, 1, Integer.MAX_VALUE, "");
        WRITTENBOOK_BURNTIME = CONFIG.getInt("written book burn time", "omniviolet", 65, 1, Integer.MAX_VALUE, "");
        LP_OMNIVIOLET = CONFIG.get("omniviolet", "enable catalysis", true)
            .getBoolean(true);

        EFF_BELLFLOWER = CONFIG.getInt("efficiency", "bell flower", 11, 1, Integer.MAX_VALUE, "");
        BASEY = CONFIG.getInt("base Y to work", "bell flower", 100, 1, Integer.MAX_VALUE, "");
        LP_BELLFLOWER = CONFIG.get("bell flower", "enable catalysis", true)
            .getBoolean(true);

        EFF_BLOODYENCHANTRESS = CONFIG.getInt("mana per tick", "bloodyenchantress", 22, 1, Integer.MAX_VALUE, "");
        BLOOD_BURNTIME = CONFIG.getInt("blood burn time", "bloodyenchantress", 20, 1, Integer.MAX_VALUE, "");

        EFF_MOONBLESS = CONFIG.getInt("mana per tick", "moonbless", 1, 1, Integer.MAX_VALUE, "");

        EFF_SUNBLESS = CONFIG.getInt("mana per tick", "sunbless", 1, 1, Integer.MAX_VALUE, "");

        EFF_TINKLE = CONFIG.getInt("efficiency", "tinkle flower", 30, 1, Integer.MAX_VALUE, "");
        LP_TINKLE = CONFIG.get("tinkle flower", "enable catalysis", true)
            .getBoolean(true);

        EFF_STONESIA = CONFIG.getInt("mana per tick", "stonesia", 5, 1, Integer.MAX_VALUE, "");
        LP_STONESIA = CONFIG.get("stonesia", "enable catalysis", true)
            .getBoolean(true);

        ANNOYINGFLOWER_COST = CONFIG.getInt("mana cost for fishing", "annoying flower", 150, 1, Integer.MAX_VALUE, "");
        TICKS = CONFIG.getInt("interval bewteen fishing", "annoying flower", 600, 1, Integer.MAX_VALUE, "");
        TIMES = CONFIG.getInt("times fried chicken leg add", "annoying flower", 3, 1, Integer.MAX_VALUE, "");

        BASECOST = CONFIG.getInt("mana cost at least", "stardust lotus", 20000, 1, Integer.MAX_VALUE, "");
        PERCOST = CONFIG.getInt("mana cost per meter", "stardust lotus", 150, 1, Integer.MAX_VALUE, "");
        CONSUMESPEED = CONFIG.getInt("mana consumed per tick", "stardust lotus", 800, 1, 100000, "");

        SPEED = CONFIG.getInt("mana transfered per tick", "manalinkium", 400, 1, Integer.MAX_VALUE, "");

        RL_BASEGEN = CONFIG.getInt("mana based generated per lightning", "reikarlily", 12000, 1, Integer.MAX_VALUE, "");
        RL_BURNTIME = CONFIG.getInt("burntime for each lightning", "reikarlily", 1500, 1, Integer.MAX_VALUE, "");
        RL_EFF = CONFIG.getInt("mana pertick", "reikarlily", 45, 1, Integer.MAX_VALUE, "");
        RL_COOLDOWN = CONFIG.getInt("cooldown after consuming lightning", "reikarlily", 3600, 1, Integer.MAX_VALUE, "");
        RL_CD = CONFIG
            .getInt("cooldown after a lightning summoned by itself", "reikarlily", 3600, 1, Integer.MAX_VALUE, "");
        RL_BASEY = CONFIG.getInt(
            "the lower base y, the higher chance it will summon lightning",
            "reikarlily",
            64,
            1,
            Integer.MAX_VALUE,
            "");

        EO_COST = CONFIG
            .getInt("mana cost for each enchanted soil", "enchantedorchid", 200000, 1, Integer.MAX_VALUE, "");
        EO_SPEED = CONFIG.getInt("the speed of mana consuming", "enchantedorchid", 400, 1, 10000, "");
        EO_RANGE = CONFIG.getInt("transform range", "enchantedorchid", 4, 1, Integer.MAX_VALUE, "");

        MB_SPEED = CONFIG.getInt("mana transfer speed", "mana buffer", 400, 1, Integer.MAX_VALUE, "");

        ENABLE_TOOLTIP = CONFIG.get("Tooltips", "enable mana visualization", true)
            .getBoolean(true);

        EFF_GEMINIORCHID = CONFIG.getFloat("efficiency", "geminiorchid", 1F, 0, Integer.MAX_VALUE, "");
        EFF_ELDELWEISS = CONFIG.getFloat("efficiency", "edelweiss", 1F, 0, Integer.MAX_VALUE, "");

        INITIAL_LIQUEFACTION_ENERGY = CONFIG.getInt(
            "How much mana the device contains upon creation. Default is 0",
            "mana liquefaction",
            0,
            0,
            Integer.MAX_VALUE,
            "");
        MAX_LIQUEFACTION_MANA = CONFIG.getInt(
            "How much mana can the Mana Liquefaction Device store. Default is 1000000",
            "mana liquefaction",
            1000000,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_STORAGE_DRAIN = CONFIG.getInt(
            "How much mana the Mana Liquefaction Device drains from containers on update. Default is 1",
            "mana liquefaction",
            1,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_STORAGE_DRAIN_CONTAINER = CONFIG.getInt(
            "How much energy the Mana Liquefaction Device gets from \"one drain\". Default is 1",
            "mana liquefaction",
            1,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_STORAGE_PUMP = CONFIG.getInt(
            "How much mana the Mana Liquefaction Device pumps at a time into a container. Default is 25",
            "mana liquefaction",
            25,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_STORAGE_PUMP_CONTAINER = CONFIG.getInt(
            "How much a container gets mana from one transfer from Mana Liquefaction Device. Default is 25",
            "mana liquefaction",
            25,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_MANA_RECEIVE = CONFIG.getInt(
            "How much a Mana Liquefaction Device receives mana on update. Default is 2000",
            "mana liquefaction",
            2000,
            0,
            Integer.MAX_VALUE,
            "");

        LIQUEFACTION_ENERGY_LOSS = CONFIG.getInt(
            "How much energy a Mana Liquefaction Device loses on update. Default is 2",
            "mana liquefaction",
            2,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_MANA_GIVE = CONFIG.getInt(
            "How much a Mana Liquefaction Device gives mana on update. Default is 2000",
            "mana liquefaction",
            2000,
            0,
            Integer.MAX_VALUE,
            "");
        LIQUEFACTION_ENERGY_GAIN = CONFIG.getInt(
            "How much energy a Mana Liquefaction Device receives on update. Default is 2",
            "mana liquefaction",
            2,
            0,
            Integer.MAX_VALUE,
            "");

        if (CONFIG.hasChanged()) CONFIG.save();
    }

    public static int loadPropInt(String propName, String desc, int default_) {
        Property prop = CONFIG.get(Configuration.CATEGORY_GENERAL, "extrabotany.config." + propName, default_);
        prop.comment = desc;

        return prop.getInt(default_);
    }

    public static double loadPropDouble(String propName, String desc, double default_) {
        Property prop = CONFIG.get(Configuration.CATEGORY_GENERAL, "extrabotany.config." + propName, default_);
        prop.comment = desc;

        return prop.getDouble(default_);
    }

    public static boolean loadPropBool(String propName, String desc, boolean default_) {
        Property prop = CONFIG.get(Configuration.CATEGORY_GENERAL, "extrabotany.config." + propName, default_);
        prop.comment = desc;

        return prop.getBoolean(default_);
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(ExtraBotanyLegacy.MODID)) syncConfigs();
    }

}
