package noobanidus.mods.w2w;

import net.blay09.mods.waystones.api.IWaystone;
import net.blay09.mods.waystones.api.WaystoneActivatedEvent;
import net.minecraft.entity.player.ServerPlayerEntity;

public class WaystonesHandler {
  public static void onWaystoneActivated(WaystoneActivatedEvent event) {
    if (!event.getPlayer().world.isRemote()) {
      IWaystone waystone = event.getWaystone();
      WaystonePacket packet = new WaystonePacket(waystone.getPos(), waystone.getName());
      Networking.sendTo(packet, (ServerPlayerEntity) event.getPlayer());
    }
  }
}