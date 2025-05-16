package com.terraformersmc.traverse.block;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.Identifier;

public class TraverseBlockSetTypes {
	public static final BlockSetType FIR = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
			.register(Identifier.of(Traverse.MOD_ID, "fir"));
}
