package miku.luomo.extrabotany_legacy.client.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrophy extends TileEntity {

    private float rotationAngle = 0.0f;

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) {
            rotationAngle = (rotationAngle + 0.6f) % 360.0f; // 每tick增加0.6度
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setFloat("rotationAngle", rotationAngle);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        rotationAngle = pkt.func_148857_g()
            .getFloat("rotationAngle");
    }

    public float getRotationAngle() {
        return rotationAngle;
    }
}
