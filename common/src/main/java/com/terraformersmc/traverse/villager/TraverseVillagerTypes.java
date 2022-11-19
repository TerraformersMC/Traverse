package com.terraformersmc.traverse.villager;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerTypeHelper;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;

public class TraverseVillagerTypes extends TraverseBiomes {
	public static void register() {
		register(VillagerType.PLAINS, AUTUMNAL_WOODS);
		register(VillagerType.PLAINS, CONIFEROUS_FOREST);
		register(VillagerType.DESERT, DESERT_SHRUBLAND);
		register(VillagerType.SWAMP, LUSH_SWAMP);
		register(VillagerType.PLAINS, FLATLANDS);
		register(VillagerType.TAIGA, SNOWY_CONIFEROUS_FOREST);
		register(VillagerType.PLAINS, WOODLANDS);
	}

	@SafeVarargs
	private static void register(VillagerType type, RegistryKey<Biome>... biomes) {
		for (RegistryKey<Biome> biome : biomes) {
			VillagerType.BIOME_TO_TYPE.put(biome, type);
		}
	}
}
