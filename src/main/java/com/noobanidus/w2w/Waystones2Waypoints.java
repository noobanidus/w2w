package com.noobanidus.w2w;

import com.noobanidus.w2w.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod.EventBusSubscriber
@Mod(modid = Waystones2Waypoints.MODID, name = Waystones2Waypoints.MODNAME, version = Waystones2Waypoints.VERSION, dependencies = Waystones2Waypoints.DEPENDS)
@SuppressWarnings("WeakerAccess")
public class Waystones2Waypoints {
    public static final String MODID = "w2w";
    public static final String MODNAME = "Waystones2Waypoints";
    public static final String VERSION = "GRADLE:VERSION";
    public static final String DEPENDS = "after:waystones;after:xaerominimap;after:signpost;";

    @SuppressWarnings("unused")
    public final static Logger LOG = LogManager.getLogger(MODID);
    public final static Configuration CONFIG = new Configuration(new File("config", "waystones2waypoints.cfg"), true);

    public static boolean enabled = CONFIG.get("General", "Enable", true, "Set to false to disable the creation of waypoints.").getBoolean();

    @SidedProxy(clientSide = "com.noobanidus.w2w.proxy.ClientProxy", serverSide = "com.noobanidus.w2w.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(Waystones2Waypoints.MODID)
    public static Waystones2Waypoints instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        CONFIG.save();
    }
}
