package miku.luomo.extrabotany_legacy.common.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import miku.luomo.extrabotany_legacy.common.register.ModItemRegister;

public class ItemNightmareFuel extends ItemModFood {

    public ItemNightmareFuel() {
        super(0, 0, false, "nightmarefuel");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.inventory.addItemStackToInventory(new ItemStack(ModItemRegister.spiritFuel));
    }
}
