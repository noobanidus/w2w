package com.noobanidus.w2w.compat.xaerostones;

import com.noobanidus.w2w.WaypointsToWaystones;
import net.blay09.mods.waystones.util.WaystoneActivatedEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xaero.common.minimap.waypoints.Waypoint;
import xaero.common.minimap.waypoints.WaypointsManager;
import xaero.common.settings.ModSettings;
import xaero.minimap.XaeroMinimap;

@Mod.EventBusSubscriber(modid = WaypointsToWaystones.MODID)
public class Handler {
    private static boolean enabled = WaypointsToWaystones.CONFIG.get("General", "Enable", true, "Set to false to disable the creation of waypoints.").getBoolean();

    @SubscribeEvent
    public static void onWaystoneActivated(WaystoneActivatedEvent event) {
        if (enabled) {
            WaypointsManager wm = XaeroMinimap.instance.getWaypointsManager();
            BlockPos pos = event.getPos();
            Waypoint instant = new Waypoint(pos.getX(), pos.getY(), pos.getZ(), event.getWaystoneName(), "W", (int) (Math.random() * (double) ModSettings.ENCHANT_COLORS.length), 0, true);
            wm.getWaypoints().getList().add(instant);
        }
    }
}
