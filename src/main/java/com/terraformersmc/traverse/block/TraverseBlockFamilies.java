package com.terraformersmc.traverse.block;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;

public class TraverseBlockFamilies {
	public static final BlockFamily FIR = BlockFamilies.familyBuilder(TraverseBlocks.FIR_PLANKS)
			.log(TraverseBlocks.FIR_LOG)
			.strippedLog(TraverseBlocks.STRIPPED_FIR_LOG)
			.button(TraverseBlocks.FIR_BUTTON)
			.fence(TraverseBlocks.FIR_FENCE)
			.fenceGate(TraverseBlocks.FIR_FENCE_GATE)
			.hangingSign(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.FIR_WALL_HANGING_SIGN)
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
