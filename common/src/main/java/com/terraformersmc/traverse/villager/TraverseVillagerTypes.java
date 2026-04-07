package com.terraformersmc.traverse.villager;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.villager.VillagerType;
import net.minecraft.world.level.biome.Biome;

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
	private static void register(ResourceKey<VillagerType> type, ResourceKey<Biome>... biomes) {
		for (ResourceKey<Biome> biome : biomes) {
			VillagerType.BY_BIOME.put(biome, type);
		}
	}
}
