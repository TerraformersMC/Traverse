package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.BoulderFeatureConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class PlainsPlateauBiomes {
	private static final TerraformBiome.Template PLATEAU_TEMPLATE = new TerraformBiome.Template(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.EMERALD_ORE)
			.addDefaultSpawnEntries()
			.depth(1.6F)
			.scale(0F)
			.temperature(0.8F)
			.downfall(0.2F)
	);

	static final Biome PLAINS_PLATEAU = PLATEAU_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS, DefaultFeature.PLAINS_FEATURES)
			.addStructureFeature(DefaultBiomeFeatures.PLAINS_VILLAGE)
			.category(Biome.Category.PLAINS)
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.RABBIT, 3, 2, 3))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.HORSE, 5, 2, 6))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.DONKEY, 1, 1, 3))
			.build();

	static final Biome ROCKY_EDGE = PLATEAU_TEMPLATE.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS)
			.addCustomFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))))
			.category(Biome.Category.PLAINS)
			.depth(0.9F)
			.build();

	static final Biome WOODED_PLATEAU = PLATEAU_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.FOREST_TREES, DefaultFeature.FOREST_GRASS, DefaultFeature.FOREST_FLOWERS)
			.category(Biome.Category.FOREST)
			.build();
}
