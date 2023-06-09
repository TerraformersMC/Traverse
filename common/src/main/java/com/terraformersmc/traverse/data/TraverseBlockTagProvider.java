package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.tag.TraverseBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BlockTags;

public class TraverseBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public TraverseBlockTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
			.add(TraverseBlocks.FIR_FENCE_GATE);

		this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
			.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.RED_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.FIR_LEAVES);

		this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
			.add(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.POTTED_FIR_SAPLING);

		this.getOrCreateTagBuilder(BlockTags.LEAVES)
			.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.RED_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES)
			.add(TraverseBlocks.FIR_LEAVES);

		this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
			.addTag(TraverseBlockTags.FIR_LOGS);

		this.getOrCreateTagBuilder(BlockTags.PLANKS)
			.add(TraverseBlocks.FIR_PLANKS);

		this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
			.add(TraverseBlocks.BROWN_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.RED_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING)
			.add(TraverseBlocks.FIR_SAPLING);

		this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
			.add(TraverseBlocks.FIR_SIGN);

		this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
			.add(TraverseBlocks.FIR_WALL_SIGN);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
			.add(TraverseBlocks.FIR_BUTTON);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
			.add(TraverseBlocks.FIR_DOOR);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
			.add(TraverseBlocks.FIR_FENCE);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
			.add(TraverseBlocks.FIR_PRESSURE_PLATE);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
			.add(TraverseBlocks.FIR_SLAB);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
			.add(TraverseBlocks.FIR_STAIRS);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
			.add(TraverseBlocks.FIR_TRAPDOOR);


		this.getOrCreateTagBuilder(TraverseBlockTags.FIR_LOGS)
			.add(TraverseBlocks.FIR_LOG)
			.add(TraverseBlocks.FIR_WOOD)
			.add(TraverseBlocks.STRIPPED_FIR_LOG)
			.add(TraverseBlocks.STRIPPED_FIR_WOOD);

		this.getOrCreateTagBuilder(TraverseBlockTags.PLANKS_THAT_BURN)
			.add(TraverseBlocks.FIR_PLANKS);

		this.getOrCreateTagBuilder(TraverseBlockTags.STRIPPED_LOGS)
			.add(TraverseBlocks.STRIPPED_FIR_LOG);

		this.getOrCreateTagBuilder(TraverseBlockTags.STRIPPED_WOOD)
			.add(TraverseBlocks.STRIPPED_FIR_WOOD);
	}
}
