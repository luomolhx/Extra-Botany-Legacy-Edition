package miku.luomo.extrabotany_legacy.common.item.food;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.extraBotanyTap;

import net.minecraft.item.ItemFood;

import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class ItemModFood extends ItemFood {

    public ItemModFood(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat, String name) {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat);
        setUnlocalizedName(name);
        setCreativeTab(extraBotanyTap);
        setTextureName(ExtraBotanyLegacy.MODID + ":" + name);
    }
}
