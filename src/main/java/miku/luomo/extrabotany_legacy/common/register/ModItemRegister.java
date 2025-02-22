package miku.luomo.extrabotany_legacy.common.register;

import java.util.ArrayList;
import java.util.List;

import miku.luomo.extrabotany_legacy.common.item.food.ItemHalloweenCandy;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import miku.luomo.extrabotany_legacy.common.item.food.ItemFriedChicken;
import miku.luomo.extrabotany_legacy.common.item.food.ItemGildedMashedPotato;

@SuppressWarnings("unused")
public class ModItemRegister {

    private static final List<Item> ITEMS = new ArrayList<>();

    public static final Item friedChicken = register(new ItemFriedChicken());
    public static final Item gildedMashedPotato = register(new ItemGildedMashedPotato());
    public static final Item halloweenCandy = register(new ItemHalloweenCandy());

    private static <T extends Item> T register(final T item) {
        ITEMS.add(item);
        return item;
    }

    private static void registerItem(final Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public static void registerItems() {
        ITEMS.forEach(ModItemRegister::registerItem);
    }
}
