package miku.luomo.extrabotany_legacy.common.block;

import static miku.luomo.extrabotany_legacy.ExtraBotanyLegacy.extraBotanyTap;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class ModBlock extends BlockContainer {

    protected ModBlock(Material material, String name) {
        super(material);
        setBlockName(name);
        if (registerInCreative()) {
            setCreativeTab(extraBotanyTap);
        }
    }

    protected boolean registerInCreative() {
        return true;
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, int x, int y, int z, int eventId, int eventData) {
        TileEntity tileentity = worldIn.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(eventId, eventData);
    }

}
