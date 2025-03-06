package miku.luomo.extrabotany_legacy.common.item.material;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;
import miku.luomo.extrabotany_legacy.common.core.config.ConfigHandler;
import miku.luomo.extrabotany_legacy.common.item.ItemMod;
import miku.luomo.extrabotany_legacy.common.register.ModBlockRegister;
import vazkii.botania.api.recipe.IFlowerComponent;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class ItemMaterial extends ItemMod implements IFlowerComponent {

    public static final String TAG_UUID = "uuid";

    public static final String[] MANA_RESOURCE_NAMES = new String[] { "spirit", "ingotorichalcos", "goldpotato",
        "heromedal", "emptybottle", "shadowium", "ticket", "godcloth", "photonium", "voidcaller", "tribloodstone" };

    @SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[MANA_RESOURCE_NAMES.length];

    public ItemMaterial() {
        super("material");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + MANA_RESOURCE_NAMES[stack.getItemDamage()];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        for (int i = 0; i < MANA_RESOURCE_NAMES.length; i++) {
            icons[i] = register.registerIcon(ExtraBotanyLegacy.MODID + ":" + MANA_RESOURCE_NAMES[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int metadata) {
        return icons[metadata];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (int i = 0; i < MANA_RESOURCE_NAMES.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target) {
        if (stack.getItemDamage() == 7 && target instanceof EntityPlayer) {
            ItemNBTHelper.setString(
                stack,
                TAG_UUID,
                target.getUniqueID()
                    .toString());
        }
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int facing,
        float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (player.getHeldItem()
            .getItemDamage() == 6 && player.isSneaking()) {
            if (ConfigHandler.GAIA_ENABLE) {
                if (!world.isRemote) {
                    return true;
                }
                return false;
            }
        } else {
            if (world.getBlock(x, y, z) == ModBlockRegister.TROPHY) {
                for (int i = 0; i < 9; i++) {
                    ChatComponentTranslation text = new ChatComponentTranslation("extrabotany_legacymisc.noveline" + i);
                    text.getChatStyle()
                        .setColor(EnumChatFormatting.WHITE);
                    player.addChatComponentMessage(text);
                }
            }
        }
        return true;
    }

    @Override
    public boolean canFit(ItemStack stack, IInventory apothecary) {
        return true;
    }

    @Override
    public int getParticleColor(ItemStack stack) {
        return 0x9b0000;
    }
}
