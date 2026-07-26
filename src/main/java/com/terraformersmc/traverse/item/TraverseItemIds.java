package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class TraverseItemIds {
	public static final ResourceKey<Item> FIR_BOAT = create("fir_boat");
	public static final ResourceKey<Item> FIR_CHEST_BOAT = create("fir_chest_boat");


	private static ResourceKey<Item> create(final String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, name));
	}
}
