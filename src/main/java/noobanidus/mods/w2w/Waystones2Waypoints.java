package noobanidus.mods.w2w;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("w2w")
@SuppressWarnings("WeakerAccess")
public class Waystones2Waypoints {
  public static final String MODID = "w2w";

  public final static Logger LOG = LogManager.getLogger(MODID);

  public Waystones2Waypoints() {
    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> MinecraftForge.EVENT_BUS.addListener(WaystonesHandler::onWaystoneActivated));
  }
}
