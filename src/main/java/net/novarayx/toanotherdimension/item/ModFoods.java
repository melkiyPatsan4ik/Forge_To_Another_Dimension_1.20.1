package net.novarayx.toanotherdimension.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties NOVARITE_FRUIT = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(5)
            .saturationMod(0.5f)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 100),0.9f)
            .build();
    public static final FoodProperties NOVARITE_VEGETABLE = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(5)
            .saturationMod(0.5f)
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 100),1f)
            .build();
}
