package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseBiomeTagProvider extends FabricTagProvider<Biome> {
	protected TraverseBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, Registries.BIOME, registriesFuture);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Vanilla biome tags
		 */
		builder(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

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
		builder(BiomeTags.HAS_IGLOO)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		builder(BiomeTags.HAS_MINESHAFT)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.HAS_PILLAGER_OUTPOST)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.HAS_RUINED_PORTAL_DESERT)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.HAS_RUINED_PORTAL_STANDARD)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.HAS_RUINED_PORTAL_SWAMP)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.HAS_SWAMP_HUT)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(BiomeTags.HAS_TRAIL_RUINS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.HAS_TRIAL_CHAMBERS)
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.LUSH_SWAMP)
				.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(BiomeTags.HAS_VILLAGE_DESERT)
				.addOptional(TraverseBiomes.DESERT_SHRUBLAND);

		builder(BiomeTags.HAS_VILLAGE_PLAINS)
				.addOptional(TraverseBiomes.FLATLANDS)
				.addOptional(TraverseBiomes.WOODLANDS);


		/*
		 * Compatibility tags for Wilder Wild
		 */
		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "forest_grass")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "has_carnation")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "has_seeding_dandelion")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.CONIFEROUS_FOREST)
				.addOptional(TraverseBiomes.WOODLANDS);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "has_rare_seeding_dandelion")))
				.addOptional(TraverseBiomes.FLATLANDS);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "has_milkweed")))
				.addOptional(TraverseBiomes.AUTUMNAL_WOODS)
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "has_cattail_common")))
				.addOptional(TraverseBiomes.LUSH_SWAMP);

		builder(TagKey.create(registryKey, Identifier.fromNamespaceAndPath("wilderwild", "firefly_spawnable_during_day")))
				.addOptional(TraverseBiomes.LUSH_SWAMP);
	}

	@Override
	public String getName() {
		return "Traverse Biome Tags";
	}
}
