package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;

public class TraverseBlockLootTableProvider extends FabricBlockLootTableProvider {
	protected TraverseBlockLootTableProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateBlockLootTables() {
		// simple blocks
		addDrop(TraverseBlocks.BROWN_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.FIR_BUTTON);
		addDrop(TraverseBlocks.FIR_FENCE);
		addDrop(TraverseBlocks.FIR_FENCE_GATE);
		addDrop(TraverseBlocks.FIR_LOG);
		addDrop(TraverseBlocks.FIR_PLANKS);
		addDrop(TraverseBlocks.FIR_PRESSURE_PLATE);
		addDrop(TraverseBlocks.FIR_SAPLING);
		addDrop(TraverseBlocks.FIR_SIGN);
		addDrop(TraverseBlocks.FIR_STAIRS);
		addDrop(TraverseBlocks.FIR_TRAPDOOR);
		addDrop(TraverseBlocks.FIR_WALL_SIGN);
		addDrop(TraverseBlocks.FIR_WOOD);
		addDrop(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.RED_AUTUMNAL_SAPLING);
		addDrop(TraverseBlocks.STRIPPED_FIR_LOG);
		addDrop(TraverseBlocks.STRIPPED_FIR_WOOD);
		addDrop(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);

		// less simple blocks
		addDrop(TraverseBlocks.FIR_DOOR, BlockLootTableGenerator::doorDrops);
		addDrop(TraverseBlocks.FIR_SLAB, BlockLootTableGenerator::slabDrops);

		// potted things
		addPottedPlantDrop(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING);
		addPottedPlantDrop(TraverseBlocks.POTTED_FIR_SAPLING);
		addPottedPlantDrop(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING);
		addPottedPlantDrop(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING);
		addPottedPlantDrop(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING);

		// tree leaves
		addDrop(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, leavesDrop(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.FIR_LEAVES, leavesDrop(TraverseBlocks.FIR_LEAVES, TraverseBlocks.FIR_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, leavesDrop(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.RED_AUTUMNAL_LEAVES, leavesDrop(TraverseBlocks.RED_AUTUMNAL_LEAVES, TraverseBlocks.RED_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		addDrop(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, leavesDrop(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
	}
}
