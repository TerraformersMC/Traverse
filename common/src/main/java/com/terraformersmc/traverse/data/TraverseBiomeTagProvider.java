package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;

public class TraverseBiomeTagProvider extends FabricTagProvider.DynamicRegistryTagProvider<Biome> {
	public TraverseBiomeTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator, BuiltinRegistries.BIOME.getKey(), "worldgen/biome", "Biome Tags");
	}

	@Override
	protected void generateTags() {
		// biome categories
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_FOREST.id()))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);


		// biome structure generation tags
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.MINESHAFT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.STRONGHOLD_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SWAMP_HUT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.WOODLANDS);
	}
}
