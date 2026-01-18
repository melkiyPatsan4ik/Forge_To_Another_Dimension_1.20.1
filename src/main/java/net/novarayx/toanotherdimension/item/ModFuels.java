package net.novarayx.toanotherdimension.item;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.novarayx.toanotherdimension.ToAnotherDimension;

@Mod.EventBusSubscriber(modid = ToAnotherDimension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModFuels {

    @SubscribeEvent
    public static void onFuelBurn(FurnaceFuelBurnTimeEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() == ModItems.NOVARITE.get()) {
            event.setBurnTime(3200);
        }
    }
}

