package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
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
		 * Vanilla biome tags
		 */
		builder(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.HAS_CLOSER_WATER_FOG)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.INCREASED_FIRE_BURNOUT)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.IS_FOREST)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.IS_OVERWORLD)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.IS_TAIGA)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.SNOW_GOLEM_MELTS)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.SPAWNS_GOLD_RABBITS)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.SPAWNS_SNOW_FOXES)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.STRONGHOLD_BIASED_TO)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.WATER_ON_MAP_OUTLINES)
				.addOptional(TraverseBiomes.LUSH_SWAMP);


		/*
		 * Conventional biome tags
		 */
		builder(ConventionalBiomeTags.IS_COLD_OVERWORLD)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(ConventionalBiomeTags.IS_CONIFEROUS_TREE)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST);

		builder(ConventionalBiomeTags.IS_DECIDUOUS_TREE)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(ConventionalBiomeTags.IS_DESERT)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(ConventionalBiomeTags.IS_HOT_OVERWORLD)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(ConventionalBiomeTags.IS_PLAINS)
				.addOptional(TraverseBiomes.FLATLANDS);

		builder(ConventionalBiomeTags.IS_SNOWY)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(ConventionalBiomeTags.IS_SWAMP)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Biome structure generation tags
		 */
		builder(BiomeTags.IGLOO_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.TRAIL_RUINS_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.TRIAL_CHAMBERS_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Compatibility tags for Wilder Wild
		 */
		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "forest_grass")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "has_carnation")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "has_seeding_dandelion")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "has_rare_seeding_dandelion")))
				.addOptional(TraverseBiomes.FLATLANDS);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "has_milkweed")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "has_cattail_common")))
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(TagKey.of(registryRef, Identifier.of("wilderwild", "firefly_spawnable_during_day")))
				.addOptional(TraverseBiomes.LUSH_SWAMP);
	}

	@Override
	public String getName() {
		return "Traverse Biome Tags";
	}
}
