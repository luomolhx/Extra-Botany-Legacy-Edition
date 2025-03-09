package miku.luomo.extrabotany_legacy.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import miku.luomo.extrabotany_legacy.client.render.RenderIDs;
import miku.luomo.extrabotany_legacy.common.entity.TileEntityTrophy;

public class BlockTrophy extends ModBlock {

    public BlockTrophy() {
        super(Material.anvil, "trophy");
        setHardness(2.0F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }

    @Override
    public int getRenderType() {
        return RenderIDs.trophyRenderID;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTrophy();
    }
}
