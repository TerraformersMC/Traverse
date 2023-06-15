package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TraverseItems {
	public static <I extends Item> I add(String name, I item) {
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}

		return Registry.register(Registry.ITEM, Identifier.of(Traverse.MOD_ID, name), item);
	}

	public static void register() {	}
}
