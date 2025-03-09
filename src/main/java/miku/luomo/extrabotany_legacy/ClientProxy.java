package miku.luomo.extrabotany_legacy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import miku.luomo.extrabotany_legacy.client.render.itemblock.RenderItemBlockFlyingBoat;
import miku.luomo.extrabotany_legacy.client.render.itemblock.RenderItemBlockTrophy;
import miku.luomo.extrabotany_legacy.common.entity.EntityFlyingBoat;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        new RenderItemBlockTrophy();
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingBoat.class, new RenderItemBlockFlyingBoat());

    }
}
