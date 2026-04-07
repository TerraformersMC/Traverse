package com.terraformersmc.traverse.block;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TraverseBlockSetTypes {
	public static final BlockSetType FIR = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
			.register(Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "fir"));
}
