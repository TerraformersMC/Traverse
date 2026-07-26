package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlockIds;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
	protected TraverseBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Basic block tags
		 */
		tag(BlockTags.FENCE_GATES)
				.add(TraverseBlockIds.FIR_FENCE_GATE);

		tag(BlockTags.FLOWER_POTS)
				.add(TraverseBlockIds.POTTED_BROWN_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.POTTED_ORANGE_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.POTTED_RED_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.POTTED_YELLOW_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.POTTED_FIR_SAPLING);

		tag(BlockTags.LEAVES)
				.add(TraverseBlockIds.BROWN_AUTUMNAL_LEAVES)
				.add(TraverseBlockIds.ORANGE_AUTUMNAL_LEAVES)
				.add(TraverseBlockIds.RED_AUTUMNAL_LEAVES)
				.add(TraverseBlockIds.YELLOW_AUTUMNAL_LEAVES)
				.add(TraverseBlockIds.FIR_LEAVES);

		tag(BlockItemTags.LOGS_THAT_BURN.block())
				.addTag(TraverseBlockTags.FIR_LOGS);

		tag(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(TraverseBlockIds.FIR_LOG);

		tag(BlockTags.PLANKS)
				.add(TraverseBlockIds.FIR_PLANKS);

		tag(BlockItemTags.SAPLINGS.block())
				.add(TraverseBlockIds.BROWN_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.ORANGE_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.RED_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.YELLOW_AUTUMNAL_SAPLING)
				.add(TraverseBlockIds.FIR_SAPLING);

		tag(BlockTags.CEILING_HANGING_SIGNS)
				.add(TraverseBlockIds.FIR_HANGING_SIGN);

		tag(BlockTags.WALL_HANGING_SIGNS)
				.add(TraverseBlockIds.FIR_WALL_HANGING_SIGN);

		tag(BlockTags.STANDING_SIGNS)
				.add(TraverseBlockIds.FIR_SIGN);

		tag(BlockTags.WALL_SIGNS)
				.add(TraverseBlockIds.FIR_WALL_SIGN);

		tag(BlockTags.WOODEN_BUTTONS)
				.add(TraverseBlockIds.FIR_BUTTON);

		tag(BlockTags.WOODEN_DOORS)
				.add(TraverseBlockIds.FIR_DOOR);

		tag(BlockTags.WOODEN_FENCES)
				.add(TraverseBlockIds.FIR_FENCE);

		tag(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(TraverseBlockIds.FIR_PRESSURE_PLATE);

		tag(BlockTags.WOODEN_SHELVES)
				.add(TraverseBlockIds.FIR_SHELF);

		tag(BlockTags.WOODEN_SLABS)
				.add(TraverseBlockIds.FIR_SLAB);

		tag(BlockTags.WOODEN_STAIRS)
				.add(TraverseBlockIds.FIR_STAIRS);

		tag(BlockTags.WOODEN_TRAPDOORS)
				.add(TraverseBlockIds.FIR_TRAPDOOR);


		/*
		 * Conventional block tags
		 */
		tag(TraverseBlockTags.PLANKS_THAT_BURN)
				.add(TraverseBlockIds.FIR_PLANKS);

		tag(ConventionalBlockTags.STRIPPED_LOGS)
				.add(TraverseBlockIds.STRIPPED_FIR_LOG);

		tag(ConventionalBlockTags.STRIPPED_WOODS)
				.add(TraverseBlockIds.STRIPPED_FIR_WOOD);


		/*
		 * Local block tags
		 */
		tag(TraverseBlockTags.FIR_LOGS)
				.add(TraverseBlockIds.FIR_LOG)
				.add(TraverseBlockIds.FIR_WOOD)
				.add(TraverseBlockIds.STRIPPED_FIR_LOG)
				.add(TraverseBlockIds.STRIPPED_FIR_WOOD);
	}

	@Override
	public String getName() {
		return "Traverse Block Tags";
	}
}
