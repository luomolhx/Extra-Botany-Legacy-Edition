package miku.luomo.extrabotany_legacy.util;

import static miku.luomo.extrabotany_legacy.common.item.ItemFlyingBoat.FLYING_BOAT_NAMES;

import net.minecraft.util.ResourceLocation;

import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class FlyingBoatTextureLoader {

    private static final LazyLoader<ResourceLocation[]> TEXTURES = new LazyLoader<>(() -> {
        ResourceLocation[] locations = new ResourceLocation[3];
        for (int i = 0; i < 3; i++) {
            locations[i] = new ResourceLocation(
                ExtraBotanyLegacy.MODID,
                "textures/entity/boat/" + FLYING_BOAT_NAMES[i] + ".png");
        }
        return locations;
    });

    public static ResourceLocation[] getTextures() {
        return TEXTURES.get();
    }
}
