package noobanidus.mods.w2w;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class WaystonePacket {
  private BlockPos pos;
  private String name;

  public WaystonePacket(PacketBuffer buffer) {
    pos = buffer.readBlockPos();
    name = buffer.readString(32767);
  }

  public WaystonePacket(BlockPos pos, String name) {
    this.pos = pos;
    this.name = name;
  }

  public BlockPos getPos() {
    return pos;
  }

  public String getName() {
    return name;
  }

  public void encode(PacketBuffer buf) {
    buf.writeBlockPos(pos);
    buf.writeString(name);
  }

  public void handle(Supplier<NetworkEvent.Context> context) {
    context.get().enqueueWork(() -> handle(this, context));
  }

  @OnlyIn(Dist.CLIENT)
  private static void handle(WaystonePacket message, Supplier<NetworkEvent.Context> context) {
    WaypointHandler.makeWaypoint(message.getPos(), message.getName());

    context.get().setPacketHandled(true);
  }
}

