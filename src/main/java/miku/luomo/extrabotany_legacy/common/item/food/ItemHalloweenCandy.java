package miku.luomo.extrabotany_legacy.common.item.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemHalloweenCandy extends ItemModFood {
    private final int SUBTYPES = 3;
    private IIcon[] icons = new IIcon[SUBTYPES];

    public ItemHalloweenCandy() {
        super(2, 0.15F, false, "candy");
        setHasSubtypes(true);
        setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < SUBTYPES; i++) {
            icons[i] = reg.registerIcon(ExtraBotanyLegacy.MODID+":"+"candy" + i);
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
        return "item." + "candy" + stack.getItemDamage();
    }
}
