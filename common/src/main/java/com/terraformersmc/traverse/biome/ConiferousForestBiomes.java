package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class ConiferousForestBiomes {
	public static Biome create(Registerable<Biome> registerable, boolean snowy) {
		return new Biome.Builder()
				.generationSettings(createGenerationSettings(registerable, snowy))
				.spawnSettings(createSpawnSettings())
				.precipitation(true)
				.temperature(snowy ? -0.5F : 0.6F)
				.downfall(0.9F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(snowy ? 0x338251 : 0x338235)
						.foliageColor(snowy ? 0x338251 : 0x338235)
						.build()
				)
				.build();
	}

	private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable, boolean snowy) {
		RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
		RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addLargeFerns(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.CONIFEROUS_TREES));
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addTaigaGrass(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		if (snowy) {
			DefaultBiomeFeatures.addSweetBerryBushesSnowy(builder);
		} else {
			DefaultBiomeFeatures.addSweetBerryBushes(builder);
		}
		return builder.build();
	}

	private static SpawnSettings createSpawnSettings() {
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
