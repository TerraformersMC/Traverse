package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class TraverseItemTags {
	public static final TagKey<Item> FIR_LOGS = TraverseItemTags.of("fir_logs");
	public static final TagKey<Item> PLANKS_THAT_BURN = TraverseItemTags.of(Identifier.fromNamespaceAndPath("c", "planks_that_burn"));

	@SuppressWarnings("UnnecessaryReturnStatement")
	private TraverseItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		return TraverseItemTags.of(Identifier.fromNamespaceAndPath(Traverse.MOD_ID, path));
	}

	private static TagKey<Item> of(Identifier id) {
		return TagKey.create(Registries.ITEM, id);
	}
}
