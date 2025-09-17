package com.terraformersmc.traverse.block;

import net.minecraft.block.entity.BlockEntityType;

public class TraverseBlockEntityTypes {
	public static void register() {
		BlockEntityType.SHELF.addSupportedBlock(TraverseBlocks.FIR_SHELF);
	}
}
