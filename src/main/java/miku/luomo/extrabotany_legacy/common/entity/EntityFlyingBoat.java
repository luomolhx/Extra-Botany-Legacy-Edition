package miku.luomo.extrabotany_legacy.common.entity;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.LOG;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miku.luomo.extrabotany_legacy.common.register.ModItemRegister;

public class EntityFlyingBoat extends Entity {

    private int boatType;

    public EntityFlyingBoat(World worldIn) {
        super(worldIn);
        this.boatType = 0;
        setSize(1.5F, 0.6F);
    }

    public EntityFlyingBoat(World worldIn, int boatType) {

        super(worldIn);
        this.boatType = MathHelper.clamp_int(boatType, 0, 2);
        this.dataWatcher.updateObject(23, this.boatType);

    }

    public void entityInit() {
        this.dataWatcher.addObject(23, this.boatType);
        this.dataWatcher.updateObject(23, this.boatType);
    }

    public int getBoatType() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        this.boatType = tagCompund.getInteger("boatType");
        this.dataWatcher.updateObject(23, this.boatType);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {

        tagCompound.setInteger("boatType", this.boatType);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else if (!this.worldObj.isRemote && !this.isDead) {

            this.setBeenAttacked();
            boolean isCreativePlayer = source.getEntity() instanceof EntityPlayer
                && ((EntityPlayer) source.getEntity()).capabilities.isCreativeMode;

            if (isCreativePlayer) {
                if (this.riddenByEntity != null) {
                    this.riddenByEntity.mountEntity(this);
                }
                this.setDead();
            }
            return true;
        } else {
            return true;
        }
    }

    @Override
    protected void updateFallState(double distanceFallenThisTick, boolean isOnGround) {
        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.posY);
        int z = MathHelper.floor_double(this.posZ);

        if (isOnGround) {
            if (this.fallDistance > 3.0F) {
                this.fall(this.fallDistance);

                if (!this.worldObj.isRemote && !this.isDead) {
                    this.setDead();
                    ItemStack drop = new ItemStack(ModItemRegister.flyingBoat, 1, this.boatType);
                    this.entityDropItem(drop, 0.0F);
                }
                this.fallDistance = 0.0F;
            }
        } else if (this.worldObj.getBlock(x, y - 1, z)
            .getMaterial() != Material.water && distanceFallenThisTick < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - distanceFallenThisTick);
            }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int rotationIncrements) {
        super.setPositionAndRotation2(x, y, z, yaw, pitch, rotationIncrements);
        this.dataWatcher.updateObject(23, this.boatType);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            this.dataWatcher.updateObject(23, this.boatType);
        }
    }
}
