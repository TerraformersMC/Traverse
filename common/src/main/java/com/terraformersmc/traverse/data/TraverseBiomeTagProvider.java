package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class TraverseBiomeTagProvider extends FabricTagProvider<Biome> {
	protected TraverseBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BIOME, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Vanilla biome categories
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS.id()))
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_FOREST.id()))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_TAIGA.id()))
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SPAWNS_COLD_VARIANT_FROGS.id()))
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SPAWNS_WARM_VARIANT_FROGS.id()))
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.WATER_ON_MAP_OUTLINES.id()))
			.addOptional(TraverseBiomes.LUSH_SWAMP);


		/*
		 * Conventional biome categories
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.CLIMATE_TEMPERATE.id()))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.DESERT.id()))
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.PLAINS.id()))
			.addOptional(TraverseBiomes.FLATLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.IN_OVERWORLD.id()))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.SNOWY.id()))
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.SWAMP.id()))
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.TREE_CONIFEROUS.id()))
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.TREE_DECIDUOUS.id()))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IGLOO_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.MINESHAFT_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.STRONGHOLD_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.SWAMP_HUT_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE.id()))
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.WOODLANDS);
	}
}
