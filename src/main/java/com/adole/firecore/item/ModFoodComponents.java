package com.adole.firecore.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent FIRE_CORE = new FoodComponent.Builder()
            .hunger(229028)
            .saturationModifier(0.5f)
            .meat()
            .snack()
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5 * 60 * 20, 4), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3 * 60 * 20), 1)
        .build();
}
 