// RenderTileTrophy.java
package miku.luomo.extrabotany_legacy.client.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import miku.luomo.extrabotany_legacy.client.entity.TileEntityTrophy;

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
        bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);

        GL11.glScalef(1F, 1F, 1F);
        GL11.glPushMatrix();

        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
