package miku.luomo.extrabotany_legacy.common.item.food;

import static miku.luomo.extrabotany_legacy.util.Util.i18n;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class ItemGildedMashedPotato extends ItemModFood {

    public ItemGildedMashedPotato() {
        super(4, 0.2f, false, "gildedMashedPotato");
        setTextureName(ExtraBotanyLegacy.MODID + ":" + "gildedMashedPotato");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean flag) {
        list.add(
            EnumChatFormatting.BLUE.toString() + EnumChatFormatting.BOLD + i18n("item.gildedMashedPotato.tooltip"));
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 600, 3));
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 3));
        player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 600, 1));
    }
}
