package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.attribute.FloatModifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class LushSwampBiomes {
	public static Biome create(Registerable<Biome> registerable) {
		return new Biome.Builder()
				.generationSettings(createGenerationSettings(registerable))
				.spawnSettings(createSpawnSettings())
				.precipitation(true)
				.temperature(0.8F)
				.downfall(0.9F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(0x7FE03E)
						.foliageColor(0x58EA33)
						.waterColor(0x617B64)
						.build()
				)
				.addEnvironmentAttributes(TraverseBiomes.createDefaultEnvironmentAttributes()
						.with(EnvironmentAttributes.BACKGROUND_MUSIC_AUDIO, new BackgroundMusic(SoundEvents.MUSIC_OVERWORLD_SWAMP))
						.with(EnvironmentAttributes.INCREASED_FIRE_BURNOUT_GAMEPLAY, true)
						.with(EnvironmentAttributes.WATER_FOG_COLOR_VISUAL, 0x232317)
						.with(EnvironmentAttributes.WATER_FOG_RADIUS_VISUAL, FloatModifier.MULTIPLY, 0.85f)
						.build()
				)
				.build();
	}

	public static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
		RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
		RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
		DefaultBiomeFeatures.addFossils(builder);
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addClayDisk(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.SWAMP_FUNGUS));
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.LUSH_SWAMP_TREES));
		DefaultBiomeFeatures.addSwampFeatures(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addSwampVegetation(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
		return builder.build();
	}

	private static SpawnSettings createSpawnSettings() {
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.MONSTER,   1, new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1));
		builder.spawn(SpawnGroup.MONSTER,  50, new SpawnSettings.SpawnEntry(EntityType.BOGGED, 4, 4));
		builder.spawn(SpawnGroup.CREATURE, 10, new SpawnSettings.SpawnEntry(EntityType.FROG, 2, 5));
		return builder.build();
	}
}
