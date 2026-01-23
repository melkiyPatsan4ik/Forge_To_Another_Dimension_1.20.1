package net.novarayx.toanotherdimension.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.entity.ModEntities;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;

@Mod.EventBusSubscriber(modid = ToAnotherDimension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.CROCO.get(), CrocoEntity.createAttributes().build());
        event.put(ModEntities.DRAWOOL.get(), CrocoEntity.createAttributes().build());
    }
}
