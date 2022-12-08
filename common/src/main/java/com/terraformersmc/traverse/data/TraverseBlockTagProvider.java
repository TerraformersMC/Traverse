package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class TraverseBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	protected TraverseBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
			.add(TraverseBlocks.FIR_FENCE_GATE);

		getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
			.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.RED_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.FIR_LEAVES);

		getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
			.add(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_FIR_SAPLING);

		getOrCreateTagBuilder(BlockTags.LEAVES)
			.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.RED_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.FIR_LEAVES);

		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
			.addTag(TraverseBlockTags.FIR_LOGS);

		getOrCreateTagBuilder(BlockTags.PLANKS)
			.add(TraverseBlocks.FIR_PLANKS);

		getOrCreateTagBuilder(BlockTags.SAPLINGS)
			.add(TraverseBlocks.BROWN_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.RED_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.FIR_SAPLING);

		getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
			.add(TraverseBlocks.FIR_HANGING_SIGN);

		getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
			.add(TraverseBlocks.FIR_WALL_HANGING_SIGN);

		getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
			.add(TraverseBlocks.FIR_SIGN);

		getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
			.add(TraverseBlocks.FIR_WALL_SIGN);

		getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
			.add(TraverseBlocks.FIR_BUTTON);

		getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
			.add(TraverseBlocks.FIR_DOOR);

		getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
			.add(TraverseBlocks.FIR_FENCE);

		getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
			.add(TraverseBlocks.FIR_PRESSURE_PLATE);

		getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
			.add(TraverseBlocks.FIR_SLAB);

		getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
			.add(TraverseBlocks.FIR_STAIRS);

		getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
			.add(TraverseBlocks.FIR_TRAPDOOR);

		getOrCreateTagBuilder(TraverseBlockTags.FIR_LOGS)
			.add(TraverseBlocks.FIR_LOG)
			.add(TraverseBlocks.FIR_WOOD)
			.add(TraverseBlocks.STRIPPED_FIR_LOG)
			.add(TraverseBlocks.STRIPPED_FIR_WOOD);
	}
}
