package com.terraformersmc.traverse;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import com.terraformersmc.traverse.generation.TraverseGeneration;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.fabricmc.api.ModInitializer;

public class Traverse implements ModInitializer {

	public static final String MOD_ID = "traverse";
	private static boolean registered = false;

	@Override
	public void onInitialize() {
		register();
	}

	public static void register() {
		if (!registered) {
			TraverseBlocks.register();
			TraverseSurfaceBuilders.register();
			TraverseFeatures.register();
			TraverseBiomes.register();
			TraverseGeneration.register();
			registered = true;
		}
	}

}
