package com.noobanidus.w2w.compat.xaerostones;

import com.noobanidus.w2w.Waystones2Waypoints;
import net.blay09.mods.waystones.util.WaystoneActivatedEvent;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WaystonesHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    @Optional.Method(modid = "waystones")
    public static void onWaystoneActivated(WaystoneActivatedEvent event) {
        if (Waystones2Waypoints.enabled) {
            WaypointHandler.makeWaypoint(event.getPos(), event.getWaystoneName());
        }
    }
}
