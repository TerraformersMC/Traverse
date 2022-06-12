package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.impl.biome.modification.BiomeSelectionContextImpl;
import net.fabricmc.fabric.impl.registry.sync.FabricRegistry;
import net.fabricmc.fabric.impl.resource.loader.FabricModResourcePack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import java.util.HashMap;
import java.util.Map;

public class TraverseBiomes {

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	public static final Map<RegistryKey<Biome>, Biome> BIOMES = new HashMap<>();

	static final Biome.Builder BIOME_TEMPLATE = new Biome.Builder()
			//.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN)
			.effects(createDefaultBiomeEffects().build());

	public static GenerationSettings.Builder createDefaultGenerationSettings() {
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

	static void addBasicFeatures(GenerationSettings.Builder generationSettings) {
		DefaultBiomeFeatures.addLandCarvers(generationSettings);
		DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
		DefaultBiomeFeatures.addDungeons(generationSettings);
		DefaultBiomeFeatures.addMineables(generationSettings);
		DefaultBiomeFeatures.addSprings(generationSettings);
		DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
	}

	public static SpawnSettings.Builder createDefaultSpawnSettings() {
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

//	public static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
	public static final RegistryKey<Biome> AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
	public static final RegistryKey<Biome> CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
	public static final RegistryKey<Biome> DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
	public static final RegistryKey<Biome> LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
	public static final RegistryKey<Biome> FLATLANDS = add("flatlands", FlatlandsBiomes.FLATLANDS);
//	public static final RegistryKey<Biome> MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
//	public static final RegistryKey<Biome> ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
	public static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
	public static final RegistryKey<Biome> WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

	static RegistryKey<Biome> add(String name) {
		Identifier id = new Identifier(Traverse.MOD_ID, name);

		return RegistryKey.of(Registry.BIOME_KEY, id);
	}

	static RegistryKey<Biome> add(String name, Biome biome) {
		RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Traverse.MOD_ID, name));
		BIOMES.put(key, biome);
		return key;
	}

	public static void register() {
		for (RegistryKey<Biome> key : BIOMES.keySet()) {
			BuiltinRegistries.add(BuiltinRegistries.BIOME, key, BIOMES.get(key));
			Traverse.LOGGER.debug("TraverseBiomes.register: '" + key.getValue() + "' received ID: " + BuiltinRegistries.BIOME.getRawId(BIOMES.get(key)));
		}
	}

}
