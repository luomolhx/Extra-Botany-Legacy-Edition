package miku.luomo.extrabotany_legacy.common.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSpiritFuel extends ItemModFood {

    public ItemSpiritFuel() {
        super(0, 0, false, "spiritfuel");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500, 1));
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 500, 1));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 500, 1));
        // TODO
        // player.addPotionEffect(new PotionEffect(Potion. 500,1)); // 1.7.10 无幸运效果 暂时留空 等待后续自行实现类似效果
    }

}
