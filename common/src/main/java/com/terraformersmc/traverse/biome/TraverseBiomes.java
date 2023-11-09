package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import java.util.List;

public class TraverseBiomes {
	public static final RegistryKey<Biome> AUTUMNAL_WOODS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "autumnal_woods"));
	public static final RegistryKey<Biome> CONIFEROUS_FOREST = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "coniferous_forest"));
	public static final RegistryKey<Biome> DESERT_SHRUBLAND = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "desert_shrubland"));
	public static final RegistryKey<Biome> FLATLANDS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "flatlands"));
	public static final RegistryKey<Biome> LUSH_SWAMP = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "lush_swamp"));
	public static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "snowy_coniferous_forest"));
	public static final RegistryKey<Biome> WOODLANDS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Traverse.MOD_ID, "woodlands"));

	public static final List<RegistryKey<Biome>> BIOMES = List.of(
			AUTUMNAL_WOODS,
			CONIFEROUS_FOREST,
			DESERT_SHRUBLAND,
			FLATLANDS,
			LUSH_SWAMP,
			SNOWY_CONIFEROUS_FOREST,
			WOODLANDS
	);

	public static void populate(FabricDynamicRegistryProvider.Entries entries) {
		entries.add(AUTUMNAL_WOODS, AutumnalWoodsBiomes.create(entries));
		entries.add(CONIFEROUS_FOREST, ConiferousForestBiomes.create(entries, false));
		entries.add(DESERT_SHRUBLAND, DesertShrublandBiomes.create(entries));
		entries.add(FLATLANDS, FlatlandsBiomes.create(entries));
		entries.add(LUSH_SWAMP, LushSwampBiomes.create(entries));
		entries.add(SNOWY_CONIFEROUS_FOREST, ConiferousForestBiomes.create(entries, true));
		entries.add(WOODLANDS, WoodlandsBiomes.create(entries));
	}

	static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
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

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	public static void register() {
		// This just creates the registry keys.  Biome objects are requested and consumed by datagen now.
	}
}
