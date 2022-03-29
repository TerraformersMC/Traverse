package com.terraformersmc.traverse.biome;


import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;


public class CliffsBiomes {
	static final Biome.Builder CLIFFS_TEMPLATE = new Biome.Builder()
			//.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			//.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			//.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			//.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.precipitation(Biome.Precipitation.RAIN)
			.generationSettings(generationSettings())
			.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
			.category(Biome.Category.PLAINS)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.waterColor(0x3F76E4)
					.waterFogColor(0x50533).build())
			//.depth(3.6F)
			//.scale(0.2F)
			.downfall(0.4F);

	static final Biome CLIFFS = CLIFFS_TEMPLATE.temperature(0.3F).build();

	static final Biome SNOWY_CLIFFS = CLIFFS_TEMPLATE.temperature(0.22F).build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addLandCarvers(builder);
		DefaultBiomeFeatures.addDungeons(builder);
		//DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addEmeraldOre(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		DefaultBiomeFeatures.addSprings(builder);
		DefaultBiomeFeatures.addFrozenTopLayer(builder);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, TraversePlacedFeatures.LOW_DIRT);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, TraversePlacedFeatures.LOW_GRAVEL);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, TraversePlacedFeatures.LOW_GRANITE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, TraversePlacedFeatures.LOW_DIORITE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, TraversePlacedFeatures.LOW_ANDESITE);
		return builder.build();
	}
}
