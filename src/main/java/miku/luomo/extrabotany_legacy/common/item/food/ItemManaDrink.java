package miku.luomo.extrabotany_legacy.common.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;
import miku.luomo.extrabotany_legacy.common.register.ModItemRegister;
import vazkii.botania.api.mana.IManaGivingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemManaDrink extends ItemModFood implements IManaGivingItem {

    public ItemManaDrink() {
        super(1, 0.1F, false, "manadrink");
        setTextureName(ExtraBotanyLegacy.MODID + ":manadrink");
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (player.shouldHeal()) {
            player.heal(5F);
        }

        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200, 0));
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200, 0));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 0));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 0));

        ManaItemHandler.dispatchMana(itemStack, player, 10000, true);

        player.inventory.addItemStackToInventory(new ItemStack(ModItemRegister.material, 1, 4));

    }
}
