package noobanidus.mods.w2w;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import xaero.common.minimap.waypoints.Waypoint;
import xaero.common.minimap.waypoints.WaypointsManager;
import xaero.common.settings.ModSettings;
import xaero.minimap.XaeroMinimap;

import java.io.IOException;

public class WaypointHandler {
  @OnlyIn(Dist.CLIENT)
  public static void makeWaypoint(BlockPos pos, String name) {
    WaypointsManager wm = XaeroMinimap.instance.getWaypointsManager();
    Waypoint instant = new Waypoint(pos.getX(), pos.getY() + 2, pos.getZ(), name, name.substring(0, 1), (int) (Math.random() * (double) ModSettings.ENCHANT_COLORS.length), 0, false);
    wm.getWaypoints().getList().add(instant);
    try {
      XaeroMinimap.instance.getSettings().saveWaypoints(wm.getCurrentWorld());
    } catch (IOException error) {
      Waystones2Waypoints.LOG.error("Unable to save automatically generated Xaero's Minimap waypoint.", error);
    }
  }
}
