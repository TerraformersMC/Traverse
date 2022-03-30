package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.HashMap;
import java.util.Map;

public class TraverseBiomes {

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

	static final Biome.Builder BIOME_TEMPLATE = new Biome.Builder()
			//.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN)
			.effects(createDefaultBiomeEffects().build());

	public static GenerationSettings.Builder createDefaultGenerationSettings(){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addLandCarvers(builder);
		DefaultBiomeFeatures.addDungeons(builder);
		DefaultBiomeFeatures.addMineables(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		DefaultBiomeFeatures.addSprings(builder);
		DefaultBiomeFeatures.addFrozenTopLayer(builder);
		return builder;
	}

	public static SpawnSettings.Builder createDefaultSpawnSettings(){
		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		addDefaultCreatureSpawnEntries(spawnSettings);
		addDefaultAmbientSpawnEntries(spawnSettings);
		addDefaultMonsterSpawnEntries(spawnSettings);
		return spawnSettings;
	}

	public static void addDefaultCreatureSpawnEntries(SpawnSettings.Builder builder) {
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 12, 4, 4));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 4, 4));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 8, 4, 4));
	}

	public static void addDefaultAmbientSpawnEntries(SpawnSettings.Builder builder) {
		builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
	}

	public static void addDefaultMonsterSpawnEntries(SpawnSettings.Builder builder) {
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}

	public static BiomeEffects.Builder createDefaultBiomeEffects() {
		return new BiomeEffects.Builder()
				.waterColor(0x3F76E4)
				.waterFogColor(0x50533)
				.skyColor(getSkyColor(0.2F))
				.fogColor(0xC0D8FF);
	}

	public static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
	public static final RegistryKey<Biome> AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
	//public static final RegistryKey<Biome> AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", AutumnalWoodsBiomes.AUTUMNAL_WOODED_HILLS);
	public static final RegistryKey<Biome> CLIFFS = add("cliffs", CliffsBiomes.CLIFFS);
	public static final RegistryKey<Biome> CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
	//public static final RegistryKey<Biome> CONIFEROUS_WOODED_HILLS = add("coniferous_wooded_hills", ConiferousForestBiomes.CONIFEROUS_WOOODED_HILLS);
	public static final RegistryKey<Biome> DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
	//public static final RegistryKey<Biome> HIGH_CONIFEROUS_FOREST = add("high_coniferous_forest", ConiferousForestBiomes.HIGH_CONIFEROUS_FOREST);
	public static final RegistryKey<Biome> LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
	public static final RegistryKey<Biome> MEADOW = add("meadow", MeadowBiomes.MEADOW);
	public static final RegistryKey<Biome> MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
	public static final RegistryKey<Biome> PLAINS_PLATEAU = add("plains_plateau", PlainsPlateauBiomes.PLAINS_PLATEAU);
	//public static final RegistryKey<Biome> ROCKY_EDGE = add("rocky_edge", PlainsPlateauBiomes.ROCKY_EDGE);
	public static final RegistryKey<Biome> ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
	public static final RegistryKey<Biome> SNOWY_CLIFFS = add("snowy_cliffs", CliffsBiomes.SNOWY_CLIFFS);
	public static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
	//public static final RegistryKey<Biome> SNOWY_CONIFEROUS_WOODED_HILLS = add("snowy_coniferous_wooded_hills", ConiferousForestBiomes.SNOWY_CONIFEROUS_WOOODED_HILLS);
	//public static final RegistryKey<Biome> SNOWY_HIGH_CONIFEROUS_FOREST = add("snowy_high_coniferous_forest", ConiferousForestBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
	public static final RegistryKey<Biome> WOODED_ISLAND = add("wooded_island", WoodedIslandBiomes.WOODED_ISLAND);
	public static final RegistryKey<Biome> WOODED_PLATEAU = add("wooded_plateau", PlainsPlateauBiomes.WOODED_PLATEAU);
	public static final RegistryKey<Biome> WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

	static RegistryKey<Biome> add(String name, Biome biome) {
		Identifier id = new Identifier(Traverse.MOD_ID, name);
		BIOMES.put(id, biome);
		return RegistryKey.of(Registry.BIOME_KEY, id);
	}

	public static void register() {
		for (Identifier id : BIOMES.keySet()) {
			BuiltinRegistries.add(BuiltinRegistries.BIOME, id, BIOMES.get(id));
		}

		//TerraformSlimeSpawnBiomes.addSlimeSpawnBiome(LUSH_SWAMP);
	}

}
