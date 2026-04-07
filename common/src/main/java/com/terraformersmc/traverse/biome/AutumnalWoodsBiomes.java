package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class AutumnalWoodsBiomes {
	public static Biome create(BootstrapContext<Biome> registerable) {
		return new Biome.BiomeBuilder()
				.generationSettings(createGenerationSettings(registerable))
				.mobSpawnSettings(createSpawnSettings())
				.hasPrecipitation(true)
				.temperature(0.8F)
				.downfall(0.4F)
				.specialEffects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColorOverride(0xD6C23D)
						.foliageColorOverride(0xD2D31F)
						.build()
				)
				.putAttributes(TraverseBiomes.createDefaultEnvironmentAttributes()
						.set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FOREST))
						.build()
				)
				.build();
	}

	private static BiomeGenerationSettings createGenerationSettings(BootstrapContext<Biome> registerable) {
		HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = registerable.lookup(Registries.CONFIGURED_CARVER);
		HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

		BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers);
		addBasicFeatures(builder);
		BiomeDefaultFeatures.addDefaultOres(builder);
		BiomeDefaultFeatures.addDefaultSoftDisks(builder);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.AUTUMNAL_TREES));
		BiomeDefaultFeatures.addForestFlowers(builder);
		BiomeDefaultFeatures.addDefaultFlowers(builder);
		BiomeDefaultFeatures.addForestGrass(builder);
		BiomeDefaultFeatures.addDefaultMushrooms(builder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(builder, true);
		return builder.build();
	}

	private static MobSpawnSettings createSpawnSettings() {
		net.minecraft.world.level.biome.MobSpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.addSpawn(MobCategory.CREATURE, 5, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));
		return builder.build();
	}
}
