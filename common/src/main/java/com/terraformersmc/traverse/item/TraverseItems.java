package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TraverseItems {
	public static <I extends Item> I add(String name, I item) {
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}

		return Registry.register(Registries.ITEM, Identifier.of(Traverse.MOD_ID, name), item);
	}

	public static void register() {	}
}
