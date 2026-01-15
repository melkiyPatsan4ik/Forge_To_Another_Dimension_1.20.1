package net.novarayx.toanotherdimension.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ToAnotherDimension.MOD_ID);

    public static final RegistryObject<SoundEvent> NOVARITE_DETECTOR_FOUND_ORE
            = registerSoundEvents("novarite_detector_found_ore");


    public static final RegistryObject<SoundEvent> SPACE_NULLIFIER = registerSoundEvents("space_nullifier");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
         SOUND_EVENTS.register(eventBus);
    }
}
