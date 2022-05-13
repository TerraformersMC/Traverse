package com.terraformersmc.traverse.generation;

import com.mojang.datafixers.util.Pair;
import com.terraformersmc.terraform.config.BiomeConfig;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class TraverseGeneration extends Region {

	private static BiomeConfig config;

	public TraverseGeneration(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
		this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
			builder.replaceBiome(BiomeKeys.FOREST, TraverseBiomes.AUTUMNAL_WOODS);
			builder.replaceBiome(BiomeKeys.TAIGA, TraverseBiomes.CONIFEROUS_FOREST);
			builder.replaceBiome(BiomeKeys.BIRCH_FOREST, TraverseBiomes.WOODLANDS);
			builder.replaceBiome(BiomeKeys.DESERT, TraverseBiomes.DESERT_SHRUBLAND);
			builder.replaceBiome(BiomeKeys.SWAMP, TraverseBiomes.LUSH_SWAMP);
			builder.replaceBiome(BiomeKeys.PLAINS, TraverseBiomes.FLATLANDS);
			builder.replaceBiome(BiomeKeys.SNOWY_TAIGA, TraverseBiomes.SNOWY_CONIFEROUS_FOREST);
			//builder.replaceBiome(BiomeKeys.DEEP_OCEAN, TraverseBiomes.WOODED_ISLAND);
		});
	}

	public static void register() {
		config = Traverse.BIOME_CONFIG_HANDLER.getBiomeConfig();

		/*
		// Arid Highlands
		addContinentalBiome(ARID_HIGHLANDS, OverworldClimate.DRY, 2);

		// Autumnal Wooded Hills
		OverworldBiomes.addHillsBiome(AUTUMNAL_WOODS, AUTUMNAL_WOODED_HILLS, 1);

		// Autumnal Woods
		addContinentalBiome(AUTUMNAL_WOODS, OverworldClimate.TEMPERATE, 1);
		addContinentalBiome(AUTUMNAL_WOODS, OverworldClimate.COOL, 0.25);

		// Cliffs
		addContinentalBiome(CLIFFS, OverworldClimate.TEMPERATE, 0.4);
		addContinentalBiome(CLIFFS, OverworldClimate.COOL, 0.6);

		// Coniferous Forest
		addContinentalBiome(CONIFEROUS_FOREST, OverworldClimate.TEMPERATE, 0.8);
		addContinentalBiome(CONIFEROUS_FOREST, OverworldClimate.COOL, 0.3);

		// Coniferous Wooded Hills
		OverworldBiomes.addHillsBiome(CONIFEROUS_FOREST, CONIFEROUS_WOODED_HILLS, 1);

		// Desert Shrubland
		addContinentalBiome(DESERT_SHRUBLAND, OverworldClimate.DRY, 0.8);

		// High Coniferous Forest
		addContinentalBiome(HIGH_CONIFEROUS_FOREST, OverworldClimate.TEMPERATE, 0.2);
		addContinentalBiome(HIGH_CONIFEROUS_FOREST, OverworldClimate.COOL, 0.075);

		// Lush Swamp
		addBiomeVariant(BiomeKeys.SWAMP, LUSH_SWAMP, 0.2);

		// Meadow
		addContinentalBiome(MEADOW, OverworldClimate.TEMPERATE, 0.9);
		addContinentalBiome(MEADOW, OverworldClimate.COOL, 0.9);
		addBiomeVariant(BiomeKeys.PLAINS, MEADOW, 0.2, OverworldClimate.COOL, OverworldClimate.TEMPERATE);

		// Mini Jungle
		addContinentalBiome(MINI_JUNGLE, OverworldClimate.TEMPERATE, 0.2);
		addBiomeVariant(BiomeKeys.JUNGLE, MINI_JUNGLE, 0.15);

		// Plains Plateau
		addContinentalBiome(PLAINS_PLATEAU, OverworldClimate.DRY, 0.1);
		addContinentalBiome(PLAINS_PLATEAU, OverworldClimate.COOL, 0.5);
		addContinentalBiome(PLAINS_PLATEAU, OverworldClimate.TEMPERATE, 0.4);
		OverworldBiomes.setRiverBiome(PLAINS_PLATEAU, PLAINS_PLATEAU);

		// Rocky Edge
		OverworldBiomes.addEdgeBiome(PLAINS_PLATEAU, ROCKY_EDGE, 1.0);

		// Rolling Hills
		addContinentalBiome(ROLLING_HILLS, OverworldClimate.COOL, 0.7);
		OverworldBiomesExt.addCenterBiome(CLIFFS, ROLLING_HILLS);

		// Snowy Cliffs
		addContinentalBiome(SNOWY_CLIFFS, OverworldClimate.SNOWY, 0.8);
		OverworldBiomesExt.addCenterBiome(SNOWY_CLIFFS, BiomeKeys.SNOWY_TAIGA_HILLS);

		// Snowy Coniferous Forest
		addContinentalBiome(SNOWY_CONIFEROUS_FOREST, OverworldClimate.SNOWY, 0.5);

		// Snowy Coniferous Wooded Hills
		OverworldBiomes.addHillsBiome(SNOWY_CONIFEROUS_FOREST, SNOWY_CONIFEROUS_WOODED_HILLS, 1);

		// Snowy High Coniferous Forest
		addContinentalBiome(SNOWY_HIGH_CONIFEROUS_FOREST, OverworldClimate.SNOWY, 0.125);

		// Wooded Island
		addBiomeVariant(BiomeKeys.DEEP_OCEAN, WOODED_ISLAND, 0.10);
		OverworldBiomes.addShoreBiome(WOODED_ISLAND, WOODED_ISLAND, 1.0);

		// Wooded Plateau
		OverworldBiomes.addHillsBiome(PLAINS_PLATEAU, WOODED_PLATEAU, 1.0);

		// Woodlands
		addContinentalBiome(WOODLANDS, OverworldClimate.DRY, 1);
		addContinentalBiome(WOODLANDS, OverworldClimate.COOL, 1);
		addContinentalBiome(WOODLANDS, OverworldClimate.TEMPERATE, 1);
		*/

		Traverse.BIOME_CONFIG_HANDLER.save();
	}

	/*private static void addBiomeVariant(RegistryKey<Biome> parent, RegistryKey<Biome> biome, double defaultChance, OverworldClimate... climates) {
		boolean enable = !config.isFrozen();

		if (biome != null) {
			BiomeConfigNode.Variant variant = config.variant(biome.getValue().getPath(), new BiomeConfigNode.Variant(enable, defaultChance));
			enable = variant.isEnabled();

			double chance = variant.getVariantChance();
			if (enable && chance > 0.0) {
				OverworldBiomes.addBiomeVariant(parent, biome, chance, climates);
			}
		}
	}

	private static void addContinentalBiome(RegistryKey<Biome> biome, OverworldClimate climate, double defaultWeight) {
		boolean enable = !config.isFrozen();

		BiomeConfigNode.Continental continental = config.continental(biome.getValue().getPath(), new BiomeConfigNode.Continental(enable, defaultWeight));
		enable = continental.isEnabled();

		double weight = continental.getWeight();
		if (enable && weight > 0.0) {
			OverworldBiomes.addContinentalBiome(biome, climate, weight);
		}
	}*/

}
