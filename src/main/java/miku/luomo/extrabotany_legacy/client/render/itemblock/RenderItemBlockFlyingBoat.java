package miku.luomo.extrabotany_legacy.client.render.itemblock;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.LOG;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import miku.luomo.extrabotany_legacy.client.model.FlyingBoatModel;
import miku.luomo.extrabotany_legacy.common.entity.EntityFlyingBoat;
import miku.luomo.extrabotany_legacy.util.FlyingBoatTextureLoader;

public class RenderItemBlockFlyingBoat extends Render {

    public static final ResourceLocation[] textures = FlyingBoatTextureLoader.getTextures();
    protected ModelBase modelFlyingBoat;

    public RenderItemBlockFlyingBoat() {
        this.shadowSize = 0.5F;
        this.modelFlyingBoat = new FlyingBoatModel();
    }

    @Override
    public void doRender(Entity item, double x, double y, double z, float entityYaw, float partialTicks) {
        this.doRender((EntityFlyingBoat) item, x, y, z, entityYaw, partialTicks);
    }

    public void doRender(EntityFlyingBoat item, double x, double y, double z, float entityYaw, float partialTicks) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        this.bindEntityTexture(item);
        this.modelFlyingBoat.render(item, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getEntityTexture(Entity item) {
        if (item instanceof EntityFlyingBoat) {
            return textures[((EntityFlyingBoat) item).getBoatType()];
        }
        return textures[0];
    }
}
