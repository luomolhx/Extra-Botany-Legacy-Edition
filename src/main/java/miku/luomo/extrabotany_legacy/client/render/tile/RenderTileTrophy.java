// RenderTileTrophy.java
package miku.luomo.extrabotany_legacy.client.render.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import miku.luomo.extrabotany_legacy.client.entity.TileEntityTrophy;

@SideOnly(Side.CLIENT)
public class RenderTileTrophy extends TileEntitySpecialRenderer {

    private final IModelCustom model;
    private final ResourceLocation texture;

    public RenderTileTrophy() {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("extrabotany_legacy", "models/block/trophy.obj"));
        texture = new ResourceLocation("extrabotany_legacy", "textures/blocks/trophy/trophy.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
        TileEntityTrophy trophy = (TileEntityTrophy) te;
        float angle = (trophy.getRotationAngle() + partialTicks * 0.6F) % 360.0f;

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        GL11.glRotatef(angle, 0, 1, 0);
        bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }

}
