package com.noobanidus.w2w.compat.xaerostones;

import com.noobanidus.w2w.Waystones2Waypoints;
import net.blay09.mods.waystones.util.WaystoneActivatedEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xaero.common.minimap.waypoints.Waypoint;
import xaero.common.minimap.waypoints.WaypointsManager;
import xaero.common.settings.ModSettings;
import xaero.minimap.XaeroMinimap;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = Waystones2Waypoints.MODID)
public class Handler {


    @SubscribeEvent
    public static void onWaystoneActivated(WaystoneActivatedEvent event) {
        if (Waystones2Waypoints.enabled) {
            WaypointsManager wm = XaeroMinimap.instance.getWaypointsManager();
            BlockPos pos = event.getPos();
            Waypoint instant = new Waypoint(pos.getX(), pos.getY(), pos.getZ(), event.getWaystoneName(), "W", (int) (Math.random() * (double) ModSettings.ENCHANT_COLORS.length), 0, false);
            wm.getWaypoints().getList().add(instant);
            try {
                XaeroMinimap.instance.getSettings().saveWaypoints(wm.getCurrentWorld());
            }
            catch (IOException error) {
                Waystones2Waypoints.LOG.error("Unable to save automatically generated Xaero's Minimap waypoint.", error);
            }
        }
    }
}
