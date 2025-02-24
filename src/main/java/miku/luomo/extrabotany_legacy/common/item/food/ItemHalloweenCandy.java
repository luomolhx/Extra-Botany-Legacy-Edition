package miku.luomo.extrabotany_legacy.common.item.food;

import static miku.luomo.extrabotany_legacy.CommonProxy.christmas;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

public class ItemHalloweenCandy extends ItemModFood {

    private final int SUBTYPES = 3;
    @SideOnly(Side.CLIENT)
    private final IIcon[] icons = new IIcon[SUBTYPES];

    public ItemHalloweenCandy() {
        super(2, 0.15F, false, "candy");
        setHasSubtypes(true);
        setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < SUBTYPES; i++) {
            if (christmas) {
                icons[i] = reg.registerIcon(ExtraBotanyLegacy.MODID + ":" + "candychris" + i);
            } else {
                icons[i] = reg.registerIcon(ExtraBotanyLegacy.MODID + ":" + "candy" + i);
            }
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List<ItemStack> list) {
        for (int i = 0; i < SUBTYPES; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icons[meta % SUBTYPES];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (christmas) {
            return "item." + "candychris" + stack.getItemDamage();
        }
        return "item." + "candy" + stack.getItemDamage();
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (player.shouldHeal()) {
            player.heal(4F);
            switch (itemStack.getItemDamage()) {
                case 0:
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
                    break;
                case 1:
                    player.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
                    break;
                case 2:
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 200, 1));
                    break;
            }
        }
    }
}
