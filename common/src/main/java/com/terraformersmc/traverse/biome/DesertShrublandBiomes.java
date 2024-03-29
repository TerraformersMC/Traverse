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

public class DesertShrublandBiomes {
	public static Biome create(Registerable<Biome> registerable) {
		return new Biome.Builder()
				.generationSettings(createGenerationSettings(registerable))
				.spawnSettings(createSpawnSettings())
				.precipitation(false)
				.temperature(2.0F)
				.downfall(0.0F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(0xBFB755)
						.foliageColor(0xAEA42A)
						.build()
				)
				.build();
	}

	private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
		RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
		RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
		DefaultBiomeFeatures.addFossils(builder);
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.DESERT_SHRUBS));
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDesertDeadBushes(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDesertVegetation(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.DESERT_EXTRA_CACTUS));
		DefaultBiomeFeatures.addDesertFeatures(builder);
		return builder.build();
	}

	private static SpawnSettings createSpawnSettings() {
		SpawnSettings.Builder builder = new SpawnSettings.Builder();
		TraverseBiomes.addDefaultAmbientSpawnEntries(builder);
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 38, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 2, 1, 1));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HUSK, 60, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ARMADILLO, 1, 1, 2));
		return builder.build();
	}
}
