package com.noobanidus.w2w.compat.xaerostones;

import com.noobanidus.w2w.Waystones2Waypoints;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xaero.common.XaeroMinimapSession;
import xaero.common.core.IXaeroMinimapClientPlayNetHandler;
import xaero.common.minimap.waypoints.Waypoint;
import xaero.common.minimap.waypoints.WaypointsManager;
import xaero.common.settings.ModSettings;
import xaero.minimap.XaeroMinimap;

import java.io.IOException;

public class WaypointHandler {
  public static String invalid = "invalid";

  @SideOnly(Side.CLIENT)
  public static void makeWaypoint(BlockPos pos, String name) {
    if (name.equals(invalid)) {
      return;
    }
    XaeroMinimapSession session = ((IXaeroMinimapClientPlayNetHandler) Minecraft.getMinecraft().player.connection).getXaero_minimapSession();
    WaypointsManager wm = session.getWaypointsManager();
    Waypoint instant = new Waypoint(pos.getX(), pos.getY() + 2, pos.getZ(), name, name.substring(0, 1), (int) (Math.random() * (double) ModSettings.ENCHANT_COLORS.length), 0, false);
    wm.getWaypoints().getList().add(instant);
    try {
      XaeroMinimap.instance.getSettings().saveWaypoints(wm.getCurrentWorld());
    } catch (IOException error) {
      Waystones2Waypoints.LOG.error("Unable to save automatically generated Xaero's Minimap waypoint.", error);
    }
  }
}
