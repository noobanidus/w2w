package com.noobanidus.w2w;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod.EventBusSubscriber
@Mod(modid = WaypointsToWaystones.MODID, name = WaypointsToWaystones.MODNAME, version = WaypointsToWaystones.VERSION, dependencies = WaypointsToWaystones.DEPENDS)
@SuppressWarnings("WeakerAccess")
public class WaypointsToWaystones {
    public static final String MODID = "w2w";
    public static final String MODNAME = "WaypointsToWaystones";
    public static final String VERSION = "GRADLE:VERSION";
    public static final String DEPENDS = "required-after:waystones;required-after:xaerominimap;";

    @SuppressWarnings("unused")
    public final static Logger LOG = LogManager.getLogger(MODID);
    public final static Configuration CONFIG = new Configuration(new File("config", "waystones2waypoints.cfg"), true);

    @Mod.Instance(WaypointsToWaystones.MODID)
    public static WaypointsToWaystones instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
    }
}
