package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class TraverseItemTags {
	public static final TagKey<Item> FIR_LOGS = TraverseItemTags.of("fir_logs");
	public static final TagKey<Item> PLANKS_THAT_BURN = TraverseItemTags.of(Identifier.of("c", "planks_that_burn"));
	public static final TagKey<Item> STRIPPED_LOGS = TraverseItemTags.of(Identifier.of("c", "stripped_logs"));
	public static final TagKey<Item> STRIPPED_WOOD = TraverseItemTags.of(Identifier.of("c", "stripped_wood"));

	@SuppressWarnings("UnnecessaryReturnStatement")
	private TraverseItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		return TraverseItemTags.of(Identifier.of(Traverse.MOD_ID, path));
	}

	private static TagKey<Item> of(Identifier id) {
		return TagKey.of(RegistryKeys.ITEM, id);
	}
}
