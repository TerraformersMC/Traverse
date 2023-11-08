package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
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
		getOrCreateTagBuilder(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(BiomeTags.IS_FOREST)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(BiomeTags.IS_TAIGA)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(BiomeTags.WATER_ON_MAP_OUTLINES)
			.addOptional(TraverseBiomes.LUSH_SWAMP);


		/*
		 * Conventional biome categories
		 */
		getOrCreateTagBuilder(ConventionalBiomeTags.CLIMATE_TEMPERATE)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(ConventionalBiomeTags.DESERT)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(ConventionalBiomeTags.PLAINS)
			.addOptional(TraverseBiomes.FLATLANDS);

		getOrCreateTagBuilder(ConventionalBiomeTags.IN_OVERWORLD)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(ConventionalBiomeTags.SNOWY)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(ConventionalBiomeTags.SWAMP)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(ConventionalBiomeTags.TREE_CONIFEROUS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST);

		getOrCreateTagBuilder(ConventionalBiomeTags.TREE_DECIDUOUS)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(BiomeTags.IGLOO_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		getOrCreateTagBuilder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(BiomeTags.STRONGHOLD_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.LUSH_SWAMP)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		getOrCreateTagBuilder(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.FLATLANDS)
			.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Compatibility tags for Wilder Wild
		 */
		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "forest_grass")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "has_carnation")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "has_seeding_dandelion")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
			.addOptional(TraverseBiomes.WOODLANDS);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "has_rare_seeding_dandelion")))
			.addOptional(TraverseBiomes.FLATLANDS);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "has_milkweed")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "has_cattail_common")))
			.addOptional(TraverseBiomes.LUSH_SWAMP);

		getOrCreateTagBuilder(TagKey.of(registryRef, new Identifier("wilderwild", "firefly_spawnable_during_day")))
			.addOptional(TraverseBiomes.LUSH_SWAMP);
	}
}
