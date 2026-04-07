package com.terraformersmc.traverse.block;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;

public class TraverseBlockFamilies {
	public static final BlockFamily FIR = BlockFamilies.familyBuilder(TraverseBlocks.FIR_PLANKS)
			.button(TraverseBlocks.FIR_BUTTON)
			.fence(TraverseBlocks.FIR_FENCE)
			.fenceGate(TraverseBlocks.FIR_FENCE_GATE)
			.pressurePlate(TraverseBlocks.FIR_PRESSURE_PLATE)
			.sign(TraverseBlocks.FIR_SIGN, TraverseBlocks.FIR_WALL_SIGN)
			.slab(TraverseBlocks.FIR_SLAB)
			.stairs(TraverseBlocks.FIR_STAIRS)
			.door(TraverseBlocks.FIR_DOOR)
			.trapdoor(TraverseBlocks.FIR_TRAPDOOR)
			.recipeGroupPrefix("wooden")
			.recipeUnlockedBy("has_planks")
			.getFamily();
}
