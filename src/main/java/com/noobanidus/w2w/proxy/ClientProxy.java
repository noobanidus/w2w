package com.noobanidus.w2w.proxy;

import com.noobanidus.w2w.Waystones2Waypoints;
import com.noobanidus.w2w.compat.xaerostones.Handler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {
    @Override
    public void postInit(FMLPostInitializationEvent event) {
         if (!Loader.isModLoaded("xaerominimap")) {
            Waystones2Waypoints.LOG.error("[W2W] Fatal error: this mod extends Xaero's Minimap. Functionality is disabled as it is not installed.");
        } else {
            MinecraftForge.EVENT_BUS.register(Handler.class);
        }
    }
}
