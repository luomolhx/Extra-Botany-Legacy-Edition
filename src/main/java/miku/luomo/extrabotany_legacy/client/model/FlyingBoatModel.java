package miku.luomo.extrabotany_legacy.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FlyingBoatModel extends ModelBase {

    public ModelRenderer[] flying_boats = new ModelRenderer[5];

    public FlyingBoatModel() {
        this.flying_boats[0] = new ModelRenderer(this, 0, 8);
        this.flying_boats[1] = new ModelRenderer(this, 0, 0);
        this.flying_boats[2] = new ModelRenderer(this, 0, 0);
        this.flying_boats[3] = new ModelRenderer(this, 0, 0);
        this.flying_boats[4] = new ModelRenderer(this, 0, 0);
        byte b0 = 24;
        byte b1 = 6;
        byte b2 = 20;
        byte b3 = 4;
        this.flying_boats[0].addBox((float) (-b0 / 2), (float) (-b2 / 2 + 2), -3.0F, b0, b2 - 4, 4, 0.0F);
        this.flying_boats[0].setRotationPoint(0.0F, (float) b3, 0.0F);
        this.flying_boats[1].addBox((float) (-b0 / 2 + 2), (float) (-b1 - 1), -1.0F, b0 - 4, b1, 2, 0.0F);
        this.flying_boats[1].setRotationPoint((float) (-b0 / 2 + 1), (float) b3, 0.0F);
        this.flying_boats[2].addBox((float) (-b0 / 2 + 2), (float) (-b1 - 1), -1.0F, b0 - 4, b1, 2, 0.0F);
        this.flying_boats[2].setRotationPoint((float) (b0 / 2 - 1), (float) b3, 0.0F);
        this.flying_boats[3].addBox((float) (-b0 / 2 + 2), (float) (-b1 - 1), -1.0F, b0 - 4, b1, 2, 0.0F);
        this.flying_boats[3].setRotationPoint(0.0F, (float) b3, (float) (-b2 / 2 + 1));
        this.flying_boats[4].addBox((float) (-b0 / 2 + 2), (float) (-b1 - 1), -1.0F, b0 - 4, b1, 2, 0.0F);
        this.flying_boats[4].setRotationPoint(0.0F, (float) b3, (float) (b2 / 2 - 1));
        this.flying_boats[0].rotateAngleX = ((float) Math.PI / 2F);
        this.flying_boats[1].rotateAngleY = ((float) Math.PI * 3F / 2F);
        this.flying_boats[2].rotateAngleY = ((float) Math.PI / 2F);
        this.flying_boats[3].rotateAngleY = (float) Math.PI;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        for (ModelRenderer flyingBoat : flying_boats) {
            flyingBoat.render(f5);
        }
    }

}
