package miku.luomo.extrabotany_legacy.util;

import net.minecraft.util.StatCollector;

public class Util {

    public static String i18n(String info) {
        return StatCollector.translateToLocal(info)
            .replace("&", "§");
    }

}
