package com.terraformersmc.traverse.tag;

import com.terraformersmc.traverse.Traverse;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class TraverseBlockTags {
	public static final TagKey<Block> FIR_LOGS = TraverseBlockTags.of("fir_logs");
	public static final TagKey<Block> PLANKS_THAT_BURN = TraverseBlockTags.of(new Identifier("c", "planks_that_burn"));
	public static final TagKey<Block> STRIPPED_LOGS = TraverseBlockTags.of(new Identifier("c", "stripped_logs"));
	public static final TagKey<Block> STRIPPED_WOOD = TraverseBlockTags.of(new Identifier("c", "stripped_wood"));

	private TraverseBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		return TraverseBlockTags.of(new Identifier(Traverse.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.of(Registry.BLOCK_KEY, id);
	}
}
