package com.terraformersmc.traverse.block;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.WoodType;

public class TraverseWoodTypes {
	public static final WoodType FIR = WoodTypeBuilder.copyOf(WoodType.OAK)
			.register(Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "fir"), TraverseBlockSetTypes.FIR);
}
