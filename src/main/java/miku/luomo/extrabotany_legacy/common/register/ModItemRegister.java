package miku.luomo.extrabotany_legacy.common.register;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import miku.luomo.extrabotany_legacy.common.item.ItemFlyingBoat;
import miku.luomo.extrabotany_legacy.common.item.food.ItemFriedChicken;
import miku.luomo.extrabotany_legacy.common.item.food.ItemGildedMashedPotato;
import miku.luomo.extrabotany_legacy.common.item.food.ItemHalloweenCandy;
import miku.luomo.extrabotany_legacy.common.item.food.ItemManaDrink;
import miku.luomo.extrabotany_legacy.common.item.food.ItemNightmareFuel;
import miku.luomo.extrabotany_legacy.common.item.food.ItemSpiritFuel;
import miku.luomo.extrabotany_legacy.common.item.material.MaterialItem;

@SuppressWarnings("unused")
public class ModItemRegister {

    private static final List<Item> ITEMS = new ArrayList<>();

    public static final Item friedChicken = register(new ItemFriedChicken());
    public static final Item gildedMashedPotato = register(new ItemGildedMashedPotato());
    public static final Item halloweenCandy = register(new ItemHalloweenCandy());
    public static final Item manaDrink = register(new ItemManaDrink());
    public static final Item nightmareFuel = register(new ItemNightmareFuel());
    public static final Item spiritFuel = register(new ItemSpiritFuel());
    public static final Item material = register(new MaterialItem());
    public static final Item flyingBoat = register(new ItemFlyingBoat());

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
