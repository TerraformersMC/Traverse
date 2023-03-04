package com.terraformersmc.traverse.biomegen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.config.TraverseBiomeConfig;
import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;

import static com.terraformersmc.traverse.biome.TraverseBiomes.*;

public class TraverseBiolithGeneration implements Runnable {
	TraverseBiomeConfig BIOME_CONFIG;

	public void addBiomes() {
		if (BIOME_CONFIG.isBiomeEnabled(AUTUMNAL_WOODS))           { BiomePlacement.replaceOverworld(BiomeKeys.FOREST, AUTUMNAL_WOODS, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(CONIFEROUS_FOREST))        { BiomePlacement.replaceOverworld(BiomeKeys.TAIGA, CONIFEROUS_FOREST, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(DESERT_SHRUBLAND))         { BiomePlacement.replaceOverworld(BiomeKeys.DESERT, DESERT_SHRUBLAND, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(FLATLANDS))                { BiomePlacement.replaceOverworld(BiomeKeys.PLAINS, FLATLANDS, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(LUSH_SWAMP))               { BiomePlacement.replaceOverworld(BiomeKeys.SWAMP, LUSH_SWAMP, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(SNOWY_CONIFEROUS_FOREST))  { BiomePlacement.replaceOverworld(BiomeKeys.SNOWY_TAIGA, SNOWY_CONIFEROUS_FOREST, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(WOODLANDS))                { BiomePlacement.replaceOverworld(BiomeKeys.BIRCH_FOREST, WOODLANDS, 0.2D); }
	}

	// Use Biolith to register our Biome placements.
	// We can't do registration stuff until Traverse's common module is ready.
	// This method will be called when Traverse is done initializing.
	@Override
	public void run() {
		// Register the Traverse surface rules.
		SurfaceGeneration.addOverworldSurfaceRules(
				Identifier.of(Traverse.MOD_ID, "surface_rules"),
				TraverseSurfaceRules.createRules());

		// Register the Traverse surface builders.
		//TraverseSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

		// Add the biomes to Overworld generation via Biolith.
		BIOME_CONFIG = Traverse.getConfigManager().getBiomeConfig();
		this.addBiomes();
	}
}
