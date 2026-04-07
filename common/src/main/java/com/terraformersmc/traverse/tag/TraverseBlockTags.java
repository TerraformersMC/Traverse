package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class TraverseBlockTags {
	public static final TagKey<Block> FIR_LOGS = TraverseBlockTags.of("fir_logs");
	public static final TagKey<Block> PLANKS_THAT_BURN = TraverseBlockTags.of(Identifier.fromNamespaceAndPath("c", "planks_that_burn"));

	@SuppressWarnings("UnnecessaryReturnStatement")
	private TraverseBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		return TraverseBlockTags.of(Identifier.fromNamespaceAndPath(Traverse.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.create(Registries.BLOCK, id);
	}
}
