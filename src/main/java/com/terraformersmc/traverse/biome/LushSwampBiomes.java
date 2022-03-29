package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class LushSwampBiomes {

	static final Biome LUSH_SWAMP = new Biome.Builder()
			//.configureSurfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_CONFIG)
			.generationSettings(generationSettings())
			.spawnSettings(spawnSettings())
			.precipitation(Biome.Precipitation.RAIN)
			.category(Biome.Category.SWAMP)
			//.depth(-0.2F)
			//.scale(0.1F)
			.temperature(0.8F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x7FE03E)
					.foliageColor(0x58EA33)
					.waterColor(0x617B64)
					.waterFogColor(0x232317).build())
			.build();

	public static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addLandCarvers(builder);
		DefaultBiomeFeatures.addDungeons(builder);
		DefaultBiomeFeatures.addMineables(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		DefaultBiomeFeatures.addSprings(builder);
		DefaultBiomeFeatures.addFrozenTopLayer(builder);
		//DefaultBiomeFeatures.addLakes();
		DefaultBiomeFeatures.addSwampVegetation(builder);
		DefaultBiomeFeatures.addFossils(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.LUSH_SWAMP_TREES);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_SWAMP);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_WATERLILY);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_SWAMP);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_SWAMP);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1));
		return builder.build();
	}
}
