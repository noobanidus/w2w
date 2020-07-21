package noobanidus.mods.w2w;

import net.blay09.mods.waystones.api.IWaystone;
import net.blay09.mods.waystones.api.WaystoneActivatedEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

public class WaystonesHandler {
  public static void onWaystoneActivated(WaystoneActivatedEvent event) {
    if (event.getPlayer().world.isRemote()) {
      PlayerEntity player = Minecraft.getInstance().player;
      if (event.getPlayer().equals(player)) {
        IWaystone waystone = event.getWaystone();
        WaypointHandler.makeWaypoint(waystone.getPos(), waystone.getName());
      }
    }
  }
}