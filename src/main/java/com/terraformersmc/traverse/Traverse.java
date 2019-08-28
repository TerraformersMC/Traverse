package com.terraformersmc.traverse;

import com.terraformersmc.terraform.config.BiomeConfigHandler;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.entity.TraverseEntities;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import com.terraformersmc.traverse.generation.TraverseGeneration;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.fabricmc.api.ModInitializer;

public class Traverse implements ModInitializer {

	public static final String MOD_ID = "traverse";
	public static final BiomeConfigHandler BIOME_CONFIG_HANDLER = new BiomeConfigHandler(MOD_ID);

	@Override
	public void onInitialize() {
		register();
	}

	public static void register() {
		TraverseBlocks.register();
		TraverseEntities.register();
		TraverseSurfaceBuilders.register();
		TraverseFeatures.register();
		TraverseBiomes.register();
		TraverseGeneration.register();
	}

}
