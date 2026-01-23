package net.novarayx.toanotherdimension.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;
import net.novarayx.toanotherdimension.entity.custom.DrawoolEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ToAnotherDimension.MOD_ID);

    public static final RegistryObject<EntityType<CrocoEntity>> CROCO =
            ENTITY_TYPES.register("croco", () -> EntityType.Builder.of(CrocoEntity::new, MobCategory.CREATURE).sized(0.5f, 0.5f).build("croco"));
    public static final RegistryObject<EntityType<DrawoolEntity>> DRAWOOL =
            ENTITY_TYPES.register("drawool", () -> EntityType.Builder.of(DrawoolEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("drawool"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
