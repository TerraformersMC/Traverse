package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class TraverseBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	protected TraverseBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Basic block tags
		 */
		valueLookupBuilder(BlockTags.FENCE_GATES)
				.add(TraverseBlocks.FIR_FENCE_GATE);

		valueLookupBuilder(BlockTags.FLOWER_POTS)
				.add(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.POTTED_FIR_SAPLING);

		valueLookupBuilder(BlockTags.LEAVES)
				.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES)
				.add(TraverseBlocks.RED_AUTUMNAL_LEAVES)
				.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES)
				.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES)
				.add(TraverseBlocks.FIR_LEAVES);

		valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
				.addTag(TraverseBlockTags.FIR_LOGS);

		valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(TraverseBlocks.FIR_LOG);

		valueLookupBuilder(BlockTags.PLANKS)
				.add(TraverseBlocks.FIR_PLANKS);

		valueLookupBuilder(BlockTags.SAPLINGS)
				.add(TraverseBlocks.BROWN_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.RED_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING)
				.add(TraverseBlocks.FIR_SAPLING);

		valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
				.add(TraverseBlocks.FIR_HANGING_SIGN);

		valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
				.add(TraverseBlocks.FIR_WALL_HANGING_SIGN);

		valueLookupBuilder(BlockTags.STANDING_SIGNS)
				.add(TraverseBlocks.FIR_SIGN);

		valueLookupBuilder(BlockTags.WALL_SIGNS)
				.add(TraverseBlocks.FIR_WALL_SIGN);

		valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
				.add(TraverseBlocks.FIR_BUTTON);

		valueLookupBuilder(BlockTags.WOODEN_DOORS)
				.add(TraverseBlocks.FIR_DOOR);

		valueLookupBuilder(BlockTags.WOODEN_FENCES)
				.add(TraverseBlocks.FIR_FENCE);

		valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(TraverseBlocks.FIR_PRESSURE_PLATE);

		valueLookupBuilder(BlockTags.WOODEN_SHELVES)
				.add(TraverseBlocks.FIR_SHELF);

		valueLookupBuilder(BlockTags.WOODEN_SLABS)
				.add(TraverseBlocks.FIR_SLAB);

		valueLookupBuilder(BlockTags.WOODEN_STAIRS)
				.add(TraverseBlocks.FIR_STAIRS);

		valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(TraverseBlocks.FIR_TRAPDOOR);


		/*
		 * Conventional block tags
		 */
		valueLookupBuilder(TraverseBlockTags.PLANKS_THAT_BURN)
				.add(TraverseBlocks.FIR_PLANKS);

		valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(TraverseBlocks.STRIPPED_FIR_LOG);

		valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(TraverseBlocks.STRIPPED_FIR_WOOD);


		/*
		 * Local block tags
		 */
		valueLookupBuilder(TraverseBlockTags.FIR_LOGS)
				.add(TraverseBlocks.FIR_LOG)
				.add(TraverseBlocks.FIR_WOOD)
				.add(TraverseBlocks.STRIPPED_FIR_LOG)
				.add(TraverseBlocks.STRIPPED_FIR_WOOD);
	}

	@Override
	public String getName() {
		return "Traverse Block Tags";
	}
}
