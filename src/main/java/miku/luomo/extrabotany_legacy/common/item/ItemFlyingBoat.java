package miku.luomo.extrabotany_legacy.common.item;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.LOG;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;
import miku.luomo.extrabotany_legacy.common.entity.EntityFlyingBoat;

public class ItemFlyingBoat extends ModItem {

    public static final String[] FLYING_BOAT_NAMES = { "boat_manasteel", "boat_elementium", "boat_terrasteel" };
    @SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[FLYING_BOAT_NAMES.length];

    public ItemFlyingBoat() {
        super("flyingboat");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + FLYING_BOAT_NAMES[stack.getItemDamage()];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> itemStacks) {
        for (int i = 0; i < FLYING_BOAT_NAMES.length; i++) {
            itemStacks.add(new ItemStack(this, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        for (int i = 0; i < FLYING_BOAT_NAMES.length; i++) {
            icons[i] = register.registerIcon(ExtraBotanyLegacy.MODID + ":" + FLYING_BOAT_NAMES[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int metadata) {
        return icons[metadata];
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            EntityFlyingBoat entityFlyingBoat = new EntityFlyingBoat(worldIn, itemStackIn.getItemDamage());
            entityFlyingBoat.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
            worldIn.spawnEntityInWorld(entityFlyingBoat);

            if (!player.capabilities.isCreativeMode) {
                itemStackIn.stackSize--;
            }
        }
        return itemStackIn;
    }
}
