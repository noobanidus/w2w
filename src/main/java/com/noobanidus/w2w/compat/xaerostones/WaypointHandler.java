package com.noobanidus.w2w.compat.xaerostones;

import com.noobanidus.w2w.Waystones2Waypoints;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xaero.common.minimap.waypoints.Waypoint;
import xaero.common.minimap.waypoints.WaypointsManager;
import xaero.common.settings.ModSettings;
import xaero.minimap.XaeroMinimap;

import java.io.IOException;

public class WaypointHandler {
    @SideOnly(Side.CLIENT)
    public static void makeWaypoint(BlockPos pos, String name) {
        WaypointsManager wm = XaeroMinimap.instance.getWaypointsManager();
        Waypoint instant = new Waypoint(pos.getX(), pos.getY(), pos.getZ(), name, "W", (int) (Math.random() * (double) ModSettings.ENCHANT_COLORS.length), 0, false);
        wm.getWaypoints().getList().add(instant);
        try {
            XaeroMinimap.instance.getSettings().saveWaypoints(wm.getCurrentWorld());
        } catch (IOException error) {
            Waystones2Waypoints.LOG.error("Unable to save automatically generated Xaero's Minimap waypoint.", error);
        }
    }
}
