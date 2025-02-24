package miku.luomo.extrabotany_legacy.util;

import net.minecraft.potion.Potion;

public class PotionIDUtil {

    public static int findAvailablePotionID() {
        for (int i = 32; i < Potion.potionTypes.length; i++) {
            if (Potion.potionTypes[i] == null) {
                return i;
            }

        }
        return -1;
    }
}
