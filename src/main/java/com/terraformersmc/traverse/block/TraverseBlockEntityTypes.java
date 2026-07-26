package com.terraformersmc.traverse.block;

import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class TraverseBlockEntityTypes {
	public static void register() {
		BlockEntityTypes.SHELF.addValidBlock(TraverseBlocks.FIR_SHELF);
	}
}
