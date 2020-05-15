package com.terraformersmc.traverse.biome;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_MUSHROOMS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_VEGETATION;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DISKS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DUNGEONS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.FROZEN_TOP_LAYER;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.LAND_CARVERS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.MINEABLES;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.ORES;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.SPRINGS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.STRUCTURES;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.traverse.Traverse;

public class TraverseBiomes {

	private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

	static final TerraformBiome.Template BIOME_TEMPLATE = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.precipitation(Biome.Precipitation.RAIN)
			.waterColor(0x3F76E4)
			.waterFogColor(0x50533)
	);

	protected static final Biome ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
	protected static final Biome AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
	protected static final Biome AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", AutumnalWoodsBiomes.AUTUMNAL_WOODED_HILLS);
	protected static final Biome CLIFFS = add("cliffs", CliffsBiomes.CLIFFS);
	protected static final Biome CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
	protected static final Biome CONIFEROUS_WOODED_HILLS = add("coniferous_wooded_hills", ConiferousForestBiomes.CONIFEROUS_WOOODED_HILLS);
	protected static final Biome DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
	protected static final Biome HIGH_CONIFEROUS_FOREST = add("high_coniferous_forest", ConiferousForestBiomes.HIGH_CONIFEROUS_FOREST);
	protected static final Biome LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
	protected static final Biome MEADOW = add("meadow", MeadowBiomes.MEADOW);
	protected static final Biome MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
	protected static final Biome PLAINS_PLATEAU = add("plains_plateau", PlainsPlateauBiomes.PLAINS_PLATEAU);
	protected static final Biome ROCKY_EDGE = add("rocky_edge", PlainsPlateauBiomes.ROCKY_EDGE);
	protected static final Biome ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
	protected static final Biome SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
	protected static final Biome SNOWY_CONIFEROUS_WOODED_HILLS = add("snowy_coniferous_wooded_hills", ConiferousForestBiomes.SNOWY_CONIFEROUS_WOOODED_HILLS);
	protected static final Biome SNOWY_HIGH_CONIFEROUS_FOREST = add("snowy_high_coniferous_forest", ConiferousForestBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
	protected static final Biome WOODED_ISLAND = add("wooded_island", WoodedIslandBiomes.WOODED_ISLAND);
	protected static final Biome WOODED_PLATEAU = add("wooded_plateau", PlainsPlateauBiomes.WOODED_PLATEAU);
	protected static final Biome WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

	static <B extends Biome> B add(String name, B biome) {
		BIOMES.put(new Identifier(Traverse.MOD_ID, name), biome);
		return biome;
	}

	public static void register() {
		for (Identifier id : BIOMES.keySet()) {
			Registry.register(Registry.BIOME, id, BIOMES.get(id));
		}
	}

}
