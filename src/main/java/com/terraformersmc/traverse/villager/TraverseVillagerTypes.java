package com.terraformersmc.traverse.villager;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerTypeHelper;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;

public class TraverseVillagerTypes extends TraverseBiomes {
	public static void register() {
		register(VillagerType.SAVANNA, ARID_HIGHLANDS);
		register(VillagerType.PLAINS, AUTUMNAL_WOODS/*, AUTUMNAL_WOODED_HILLS*/);
		register(VillagerType.PLAINS, CLIFFS);
		register(VillagerType.PLAINS, CONIFEROUS_FOREST/*, CONIFEROUS_WOODED_HILLS, HIGH_CONIFEROUS_FOREST*/);
		register(VillagerType.DESERT, DESERT_SHRUBLAND);
		register(VillagerType.SWAMP, LUSH_SWAMP);
		register(VillagerType.PLAINS, FLATLANDS);
		register(VillagerType.JUNGLE, MINI_JUNGLE);
		register(VillagerType.PLAINS, PLAINS_PLATEAU/*, ROCKY_EDGE*/, WOODED_PLATEAU);
		register(VillagerType.PLAINS, ROLLING_HILLS);
		register(VillagerType.SNOW, SNOWY_CLIFFS);
		register(VillagerType.TAIGA, SNOWY_CONIFEROUS_FOREST/*, SNOWY_CONIFEROUS_WOODED_HILLS, SNOWY_HIGH_CONIFEROUS_FOREST*/);
		register(VillagerType.PLAINS, WOODED_ISLAND);
		register(VillagerType.PLAINS, WOODLANDS);
	}

	@SafeVarargs
	private static void register(VillagerType type, RegistryKey<Biome>... biomes) {
		for (RegistryKey<Biome> biome : biomes) {
			VillagerTypeHelper.addVillagerTypeToBiome(biome, type);
		}
	}
}
