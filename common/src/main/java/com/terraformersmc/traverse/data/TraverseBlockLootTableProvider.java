package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class TraverseBlockLootTableProvider extends FabricBlockLootTableProvider {
	protected TraverseBlockLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		// simple blocks
		addDrop(TraverseBlocks.BROWN_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.FIR_BUTTON);
		addDrop(TraverseBlocks.FIR_FENCE);
		addDrop(TraverseBlocks.FIR_FENCE_GATE);
		addDrop(TraverseBlocks.FIR_LOG);
		addDrop(TraverseBlocks.FIR_PLANKS);
		addDrop(TraverseBlocks.FIR_PRESSURE_PLATE);
		addDrop(TraverseBlocks.FIR_SAPLING);
		addDrop(TraverseBlocks.FIR_HANGING_SIGN);
		addDrop(TraverseBlocks.FIR_SIGN);
		addDrop(TraverseBlocks.FIR_STAIRS);
		addDrop(TraverseBlocks.FIR_TRAPDOOR);
		addDrop(TraverseBlocks.FIR_WALL_HANGING_SIGN);
		addDrop(TraverseBlocks.FIR_WALL_SIGN);
		addDrop(TraverseBlocks.FIR_WOOD);
		addDrop(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.RED_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.STRIPPED_FIR_LOG);
		addDrop(TraverseBlocks.STRIPPED_FIR_WOOD);
		addDrop(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);

		// less simple blocks
		doorDrops(TraverseBlocks.FIR_DOOR);
		slabDrops(TraverseBlocks.FIR_SLAB);

		// potted things
		addPottedPlantDrops(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING);
		addPottedPlantDrops(TraverseBlocks.POTTED_FIR_SAPLING);
		addPottedPlantDrops(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING);
		addPottedPlantDrops(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING);
		addPottedPlantDrops(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING);

		// tree leaves
		addDrop(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, leavesDrops(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.FIR_LEAVES, leavesDrops(TraverseBlocks.FIR_LEAVES, TraverseBlocks.FIR_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, leavesDrops(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.RED_AUTUMNAL_LEAVES, leavesDrops(TraverseBlocks.RED_AUTUMNAL_LEAVES, TraverseBlocks.RED_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, leavesDrops(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
	}
}
