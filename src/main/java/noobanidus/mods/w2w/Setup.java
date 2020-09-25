package noobanidus.mods.w2w;

import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Setup {
  public static void init(FMLCommonSetupEvent event) {
    DeferredWorkQueue.runLater(() -> {
      Networking.INSTANCE.registerMessages();
    });
  }
}
