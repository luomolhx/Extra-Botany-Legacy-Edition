package miku.luomo.extrabotany_legacy.common.item;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.extraBotanyTap;

import net.minecraft.item.Item;

import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class ModItem extends Item {

    public ModItem(String name) {
        setCreativeTab(extraBotanyTap);
        setUnlocalizedName(name);
        setTextureName(ExtraBotanyLegacy.MODID + ":" + name);
    }
}
