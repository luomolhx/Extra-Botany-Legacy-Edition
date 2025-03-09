package miku.luomo.extrabotany_legacy.common.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;
import miku.luomo.extrabotany_legacy.common.entity.EntityFlyingBoat;

public class ModEntityRegister {

    public static void registerModEntity() {
        int id = 0;

        EntityRegistry
            .registerModEntity(EntityFlyingBoat.class, "flyingboat", id++, ExtraBotanyLegacy.instance, 64, 10, true);
    }
}
