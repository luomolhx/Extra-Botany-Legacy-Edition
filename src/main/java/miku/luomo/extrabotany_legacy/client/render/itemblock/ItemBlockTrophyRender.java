package miku.luomo.extrabotany_legacy.client.render.itemblock;

import static miku.luomo.extrabotany_legacy.common.register.ModBlockRegister.TROPHY;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ClientRegistry;
import miku.luomo.extrabotany_legacy.client.entity.TileEntityTrophy;
import miku.luomo.extrabotany_legacy.client.render.tile.RenderTileTrophy;

public class ItemBlockTrophyRender implements IItemRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(
        "extrabotany_legacy",
        "textures/blocks/trophy/trophy.png");

    public ItemBlockTrophyRender() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrophy.class, new RenderTileTrophy());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TROPHY), this);
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    public static IModelCustom trophyModel = AdvancedModelLoader
        .loadModel(new ResourceLocation("extrabotany_legacy", "models/block/trophy.obj"));

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glScalef(1F, 1F, 1F);
        GL11.glRotated(0, 1, 0, 0);
        GL11.glTranslatef(0.5F, 0F, 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        trophyModel.renderAll();
        GL11.glPopMatrix();
    }
}
