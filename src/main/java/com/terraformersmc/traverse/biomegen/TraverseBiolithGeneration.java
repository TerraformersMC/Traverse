package com.terraformersmc.traverse.biomegen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.compat.BiolithCompats;
import com.terraformersmc.biolith.api.compat.ModernerBetaBiomeKeys;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.config.TraverseBiomeConfig;
import com.terraformersmc.traverse.surface.rules.TraverseSurfaceRules;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biomes;

import static com.terraformersmc.traverse.biome.TraverseBiomes.*;

public class TraverseBiolithGeneration {
	private static final TraverseBiomeConfig BIOME_CONFIG = Traverse.getConfigManager().getBiomeConfig();

	public static void register() {
		// Register the Traverse surface rules.
		SurfaceGeneration.addOverworldSurfaceRules(
			Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "surface_rules"),
			TraverseSurfaceRules.createRules());

		// Register the Traverse surface builders.
		//TraverseSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

		// Register the Traverse biomes.
		if (BIOME_CONFIG.isBiomeEnabled(AUTUMNAL_WOODS))           { BiomePlacement.replaceOverworld(Biomes.FOREST, AUTUMNAL_WOODS, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(CONIFEROUS_FOREST))        { BiomePlacement.replaceOverworld(Biomes.TAIGA, CONIFEROUS_FOREST, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(DESERT_SHRUBLAND))         { BiomePlacement.replaceOverworld(Biomes.DESERT, DESERT_SHRUBLAND, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(FLATLANDS))                { BiomePlacement.replaceOverworld(Biomes.PLAINS, FLATLANDS, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(LUSH_SWAMP))               { BiomePlacement.replaceOverworld(Biomes.SWAMP, LUSH_SWAMP, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(SNOWY_CONIFEROUS_FOREST))  { BiomePlacement.replaceOverworld(Biomes.SNOWY_TAIGA, SNOWY_CONIFEROUS_FOREST, 0.2D); }
		if (BIOME_CONFIG.isBiomeEnabled(WOODLANDS))                { BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, WOODLANDS, 0.2D); }

		// Target some Moderner Beta biomes for replacement by ours.
		if (BiolithCompats.isCompatEnabled(BiolithCompats.MODERNER_BETA)) {
			if (BIOME_CONFIG.isBiomeEnabled(AUTUMNAL_WOODS)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_420, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_611, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.ALPHA, AUTUMNAL_WOODS, 0.4D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_SKY, AUTUMNAL_WOODS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_FOREST, AUTUMNAL_WOODS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_SEASONAL_FOREST, AUTUMNAL_WOODS, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(CONIFEROUS_FOREST)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_611, CONIFEROUS_FOREST, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.ALPHA, CONIFEROUS_FOREST, 0.4D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_TAIGA, CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.LATE_BETA_TAIGA, CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.EARLY_RELEASE_TAIGA, CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_TAIGA, CONIFEROUS_FOREST, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(DESERT_SHRUBLAND)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_DESERT, DESERT_SHRUBLAND, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_DESERT, DESERT_SHRUBLAND, 0.3D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(FLATLANDS)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_227, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_325, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_415, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_420, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_611, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.ALPHA, FLATLANDS, 0.4D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_SKY, FLATLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_PLAINS, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.LATE_BETA_PLAINS, FLATLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_PLAINS, FLATLANDS, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(LUSH_SWAMP)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_SWAMPLAND, LUSH_SWAMP, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.LATE_BETA_SWAMPLAND, LUSH_SWAMP, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.EARLY_RELEASE_SWAMPLAND, LUSH_SWAMP, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_SWAMPLAND, LUSH_SWAMP, 0.3D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(SNOWY_CONIFEROUS_FOREST)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.ALPHA_WINTER, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_TUNDRA, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.LATE_BETA_ICE_PLAINS, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.EARLY_RELEASE_ICE_PLAINS, SNOWY_CONIFEROUS_FOREST, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_TUNDRA, SNOWY_CONIFEROUS_FOREST, 0.2D);
			}
			if (BIOME_CONFIG.isBiomeEnabled(WOODLANDS)) {
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_415, WOODLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_420, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.INFDEV_611, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.ALPHA, WOODLANDS, 0.4D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_SKY, WOODLANDS, 0.3D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.BETA_FOREST, WOODLANDS, 0.2D);
				BiomePlacement.replaceOverworld(ModernerBetaBiomeKeys.PE_FOREST, WOODLANDS, 0.2D);
			}
		}
	}
}
