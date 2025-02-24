package miku.luomo.extrabotany_legacy.client.gui;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.ExtraBotanyLegacy;

@SideOnly(Side.CLIENT)
public class ModGuiHandler extends GuiInventory {

    private static final ResourceLocation LUCK_ICON = new ResourceLocation(
        ExtraBotanyLegacy.MODID,
        "textures/gui/luck_effect.png");

    public ModGuiHandler(EntityPlayer p_i1094_1_) {
        super(p_i1094_1_);
    }

    @SubscribeEvent
    public void onRenderHUD(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.ALL) {}
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
