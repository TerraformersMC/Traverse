package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.attribute.modifier.FloatModifier;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class LushSwampBiomes {
	public static Biome create(BootstrapContext<Biome> registerable) {
		return new Biome.BiomeBuilder()
				.generationSettings(createGenerationSettings(registerable))
				.mobSpawnSettings(createSpawnSettings())
				.hasPrecipitation(true)
				.temperature(0.8F)
				.downfall(0.9F)
				.specialEffects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColorOverride(0x7FE03E)
						.foliageColorOverride(0x58EA33)
						.waterColor(0x617B64)
						.build()
				)
				.putAttributes(TraverseBiomes.createDefaultEnvironmentAttributes()
						.set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_SWAMP))
						.set(EnvironmentAttributes.INCREASED_FIRE_BURNOUT, true)
						.set(EnvironmentAttributes.WATER_FOG_COLOR, 0x232317)
						.modify(EnvironmentAttributes.WATER_FOG_END_DISTANCE, FloatModifier.MULTIPLY, 0.85F)
						.build()
				)
				.build();
	}

	public static BiomeGenerationSettings createGenerationSettings(BootstrapContext<Biome> registerable) {
		HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = registerable.lookup(Registries.CONFIGURED_CARVER);
		HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

		BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers);
		BiomeDefaultFeatures.addFossilDecoration(builder);
		addBasicFeatures(builder);
		BiomeDefaultFeatures.addDefaultOres(builder);
		BiomeDefaultFeatures.addSwampClayDisk(builder);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.SWAMP_FUNGUS));
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.LUSH_SWAMP_TREES));
		BiomeDefaultFeatures.addSwampVegetation(builder);
		BiomeDefaultFeatures.addDefaultMushrooms(builder);
		BiomeDefaultFeatures.addSwampExtraVegetation(builder);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
		return builder.build();
	}

	private static MobSpawnSettings createSpawnSettings() {
		MobSpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.addSpawn(MobCategory.MONSTER,   1, new MobSpawnSettings.SpawnerData(EntityTypes.SLIME, 1, 1));
		builder.addSpawn(MobCategory.MONSTER,  50, new MobSpawnSettings.SpawnerData(EntityTypes.BOGGED, 4, 4));
		builder.addSpawn(MobCategory.CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityTypes.FROG, 2, 5));
		return builder.build();
	}
}
