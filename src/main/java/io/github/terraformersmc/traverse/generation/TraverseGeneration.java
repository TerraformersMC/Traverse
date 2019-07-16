package io.github.terraformersmc.traverse.generation;

import io.github.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biomes;

public class TraverseGeneration extends TraverseBiomes {

	public static void register() {
		// Arid Highlands
		OverworldBiomes.addContinentalBiome(ARID_HIGHLANDS, OverworldClimate.DRY, 2);

		// Autumnal Wooded Hills
		OverworldBiomes.addHillsBiome(AUTUMNAL_WOODS, AUTUMNAL_WOODED_HILLS, 1);

		// Autumnal Woods
		OverworldBiomes.addContinentalBiome(AUTUMNAL_WOODS, OverworldClimate.TEMPERATE, 1);
		OverworldBiomes.addContinentalBiome(AUTUMNAL_WOODS, OverworldClimate.COOL, 0.25);

		// Cliffs
		OverworldBiomes.addContinentalBiome(CLIFFS, OverworldClimate.TEMPERATE, 0.4);
		OverworldBiomes.addContinentalBiome(CLIFFS, OverworldClimate.COOL, 0.6);
		OverworldBiomes.addContinentalBiome(CLIFFS, OverworldClimate.SNOWY, 0.8);

		// Coniferous Forest
		OverworldBiomes.addContinentalBiome(CONIFEROUS_FOREST, OverworldClimate.TEMPERATE, 0.8);
		OverworldBiomes.addContinentalBiome(CONIFEROUS_FOREST, OverworldClimate.COOL, 0.3);

		// Coniferous Wooded Hills
		OverworldBiomes.addHillsBiome(CONIFEROUS_FOREST, CONIFEROUS_WOODED_HILLS, 1);

		// Desert Shrubland
		OverworldBiomes.addContinentalBiome(DESERT_SHRUBLAND, OverworldClimate.DRY, 0.8);

		// Forest Island
		OverworldBiomes.addBiomeVariant(Biomes.DEEP_OCEAN, FOREST_ISLAND, 0.10);
		OverworldBiomes.addShoreBiome(FOREST_ISLAND, FOREST_ISLAND, 1.0);

		// High Coniferous Forest
		OverworldBiomes.addContinentalBiome(HIGH_CONIFEROUS_FOREST, OverworldClimate.TEMPERATE, 0.2);
		OverworldBiomes.addContinentalBiome(HIGH_CONIFEROUS_FOREST, OverworldClimate.COOL, 0.075);

		// Rolling Hills
		OverworldBiomes.addContinentalBiome(ROLLING_HILLS, OverworldClimate.COOL, 0.7);

		// Lush Swamp
		OverworldBiomes.addBiomeVariant(Biomes.SWAMP, LUSH_SWAMP, 0.2);

		// Meadow
		OverworldBiomes.addContinentalBiome(MEADOW, OverworldClimate.TEMPERATE, 0.9);
		OverworldBiomes.addContinentalBiome(MEADOW, OverworldClimate.COOL, 0.9);
		OverworldBiomes.addBiomeVariant(Biomes.PLAINS, MEADOW, 0.2, OverworldClimate.COOL, OverworldClimate.TEMPERATE);

		// Mini Jungle
		OverworldBiomes.addContinentalBiome(MINI_JUNGLE, OverworldClimate.TEMPERATE, 0.2);
		OverworldBiomes.addBiomeVariant(Biomes.JUNGLE, MINI_JUNGLE, 0.15);

		// Rocky Plateau
		OverworldBiomes.addContinentalBiome(ROCKY_PLATEAU, OverworldClimate.DRY, 0.1);
		OverworldBiomes.addContinentalBiome(ROCKY_PLATEAU, OverworldClimate.COOL, 0.5);
		OverworldBiomes.addContinentalBiome(ROCKY_PLATEAU, OverworldClimate.TEMPERATE, 0.4);

		// Snowy Coniferous Forest
		OverworldBiomes.addContinentalBiome(SNOWY_CONIFEROUS_FOREST, OverworldClimate.SNOWY, 0.5);

		// Snowy Coniferous Wooded Hills
		OverworldBiomes.addHillsBiome(SNOWY_CONIFEROUS_FOREST, SNOWY_CONIFEROUS_WOODED_HILLS, 1);

		// Snowy High Coniferous Forest
		OverworldBiomes.addContinentalBiome(SNOWY_HIGH_CONIFEROUS_FOREST, OverworldClimate.SNOWY, 0.125);

		// Woodlands
		OverworldBiomes.addContinentalBiome(WOODLANDS, OverworldClimate.COOL, 1);
		OverworldBiomes.addContinentalBiome(WOODLANDS, OverworldClimate.TEMPERATE, 1);

		// Spawn Biomes
		FabricBiomes.addSpawnBiome(ARID_HIGHLANDS);
		FabricBiomes.addSpawnBiome(CONIFEROUS_FOREST);
		FabricBiomes.addSpawnBiome(MEADOW);
		FabricBiomes.addSpawnBiome(WOODLANDS);
	}

}
