package com.adole.firecore.item;

import com.adole.firecore.item.custom.FireCore;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModItems {
    public static final String MOD_ID = "firecore";
    private ModItems() {}
 
	// 新物品的实例
	public static final Item COAL_NUGGET = register("coal_nugget", new Item(new Item.Settings()));
	public static final Item FIRE_CORE = register("fire_core", new FireCore(new Item.Settings().food(ModFoodComponents.FIRE_CORE)));
 
	public static <T extends Item> T register(String path, T item) {
		return Registry.register(Registries.ITEM, new Identifier(MOD_ID, path), item);
	}

	public static void registerFuels() {
		FuelRegistry.INSTANCE.add(FIRE_CORE, 2000000000);
	}
 
	public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
		        .register((itemGroup) -> itemGroup.add(ModItems.FIRE_CORE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(ModItems.COAL_NUGGET));
	}
}
