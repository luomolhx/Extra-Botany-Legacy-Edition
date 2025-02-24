package miku.luomo.extrabotany_legacy.common;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;
import miku.luomo.extrabotany_legacy.common.register.ModItemRegister;

public class ModFuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == ModItemRegister.spiritFuel) {
            return 1400;
        } else if (fuel.getItem() == ModItemRegister.nightmareFuel) {
            return 1000;
        } else {
            return 0;
        }
    }
}
