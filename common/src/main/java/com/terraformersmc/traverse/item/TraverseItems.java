package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class TraverseItems {
	private static final Map<Identifier, Item> ITEMS = new HashMap<>();

	public static Item add(String name, Item item) {
		ITEMS.put(Identifier.of(Traverse.MOD_ID, name), item);
		return item;
	}

	public static <I extends BlockItem> I add(String name, I item) {
		item.appendBlocks(Item.BLOCK_ITEMS, item);
		ITEMS.put(Identifier.of(Traverse.MOD_ID, name), item);
		return item;
	}

	public static void register() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registries.ITEM, id, ITEMS.get(id));
		}
	}
}
