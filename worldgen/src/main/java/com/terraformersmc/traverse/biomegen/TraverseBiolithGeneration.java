package com.terraformersmc.traverse.biomegen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.compat.BiolithCompats;
import com.terraformersmc.biolith.api.compat.ModernBetaBiomeKeys;
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

		// Target some Modern Beta biomes for replacement by ours.
		if (BiolithCompats.isCompatEnabled(BiolithCompats.MODERN_BETA)) {
			if (BIOME_CONFIG.isBiomeEnabled(AUTUMNAL_WOODS)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_420, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_611, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.ALPHA, AUTUMNAL_WOODS, 0.4D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_SKY, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_SEASONAL_FOREST, AUTUMNAL_WOODS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_SEASONAL_FOREST, AUTUMNAL_WOODS, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(CONIFEROUS_FOREST)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_611, CONIFEROUS_FOREST, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.ALPHA, CONIFEROUS_FOREST, 0.4D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_TAIGA, CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_TAIGA, CONIFEROUS_FOREST, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(DESERT_SHRUBLAND)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_DESERT, DESERT_SHRUBLAND, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_DESERT, DESERT_SHRUBLAND, 0.3D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(FLATLANDS)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_227, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_415, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_420, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_611, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.ALPHA, FLATLANDS, 0.4D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_SKY, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_PLAINS, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_PLAINS, FLATLANDS, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(LUSH_SWAMP)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_SWAMPLAND, LUSH_SWAMP, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_SWAMPLAND, LUSH_SWAMP, 0.3D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(SNOWY_CONIFEROUS_FOREST)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.ALPHA_WINTER, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_TUNDRA, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_TUNDRA, SNOWY_CONIFEROUS_FOREST, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(WOODLANDS)) {
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_415, WOODLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_420, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.INFDEV_611, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.ALPHA, WOODLANDS, 0.4D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_SKY, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.BETA_FOREST, WOODLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernBetaBiomeKeys.PE_FOREST, WOODLANDS, 0.2D);
			}
		}
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
