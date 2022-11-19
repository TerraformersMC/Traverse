package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class TraverseBlockTags {
	public static final TagKey<Block> FIR_LOGS = TraverseBlockTags.of("fir_logs");

	private TraverseBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		return TraverseBlockTags.of(new Identifier(Traverse.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.of(RegistryKeys.BLOCK, id);
	}
}
