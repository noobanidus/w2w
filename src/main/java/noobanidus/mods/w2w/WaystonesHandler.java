package noobanidus.mods.w2w;

import net.blay09.mods.waystones.api.IWaystone;
import net.blay09.mods.waystones.api.WaystoneActivatedEvent;

public class WaystonesHandler {
  public static void onWaystoneActivated(WaystoneActivatedEvent event) {
    if (event.getPlayer().world.isRemote()) {
      IWaystone waystone = event.getWaystone();
      WaypointHandler.makeWaypoint(waystone.getPos(), waystone.getName());
    }
  }
}
