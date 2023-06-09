package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class TraverseItemTags {
	public static final TagKey<Item> FIR_LOGS = TraverseItemTags.of("fir_logs");
	public static final TagKey<Item> PLANKS_THAT_BURN = TraverseItemTags.of(new Identifier("c", "planks_that_burn"));
	public static final TagKey<Item> STRIPPED_LOGS = TraverseItemTags.of(new Identifier("c", "stripped_logs"));
	public static final TagKey<Item> STRIPPED_WOOD = TraverseItemTags.of(new Identifier("c", "stripped_wood"));

	private TraverseItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		return TraverseItemTags.of(new Identifier(Traverse.MOD_ID, path));
	}

	private static TagKey<Item> of(Identifier id) {
		return TagKey.of(Registry.ITEM_KEY, id);
	}
}
