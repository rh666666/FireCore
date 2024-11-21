package com.adole.firecore.item.Materials;

import com.adole.firecore.item.ModItems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MSTools implements ToolMaterial {

    public static final MSTools INSTANCE = new MSTools();

    public static final float INFINITY = 1.0f/0.0f;

    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return INFINITY;
    }

    @Override
    public float getAttackDamage() {
        return INFINITY;
    }

    @Override
    public int getMiningLevel() {
        return 9;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.FIRE_CORE);
    }

}