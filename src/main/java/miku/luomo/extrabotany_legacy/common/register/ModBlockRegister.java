package miku.luomo.extrabotany_legacy.common.register;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import miku.luomo.extrabotany_legacy.common.block.BlockTrophy;

public class ModBlockRegister {

    private static final List<Block> BLOCKS = new ArrayList<>();
    public static Block TROPHY = register(new BlockTrophy());

    private static <T extends Block> T register(final T block) {
        BLOCKS.add(block);
        return block;
    }

    private static void registerBlock(final Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }

    public static void registerBlocks() {
        BLOCKS.forEach(ModBlockRegister::registerBlock);
    }
}
