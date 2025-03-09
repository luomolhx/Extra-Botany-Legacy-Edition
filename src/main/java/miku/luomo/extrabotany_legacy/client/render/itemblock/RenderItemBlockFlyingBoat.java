package miku.luomo.extrabotany_legacy.client.render.itemblock;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
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
        GL11.glTranslatef((float) x, (float) y , (float) z);
        GL11.glRotatef(90.0F - entityYaw, 0.0F, 1.0F, 0.0F);

//        float scale = 0.75F;
//        GL11.glScalef(scale, scale, scale);
        this.bindEntityTexture(item);
//        GL11.glScalef(1.0F/scale, 1.0F/scale, 1.0F/scale);

        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelFlyingBoat.render(item, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getEntityTexture(Entity item) {
        return getEntityTexture((EntityFlyingBoat) item);
    }

    public ResourceLocation getEntityTexture(EntityFlyingBoat item) {
        int type = MathHelper.clamp_int(item.getBoatType(), 0, textures.length - 1);
        return textures[type];
    }
}
