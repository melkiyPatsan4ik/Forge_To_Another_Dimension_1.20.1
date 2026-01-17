package net.novarayx.toanotherdimension.item;

import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFuels {
    @SubscribeEvent
    public static void registerFuel(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().is(ModItems.NOVARITE.get())) {
            event.setBurnTime(3800);
        }
    }
}
