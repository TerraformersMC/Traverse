package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class TraverseBlockTags {
	public static final TagKey<Block> FIR_LOGS = TraverseBlockTags.of("fir_logs");
	public static final TagKey<Block> PLANKS_THAT_BURN = TraverseBlockTags.of(Identifier.of("c", "planks_that_burn"));

	@SuppressWarnings("UnnecessaryReturnStatement")
	private TraverseBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		return TraverseBlockTags.of(Identifier.of(Traverse.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.of(RegistryKeys.BLOCK, id);
	}
}
