package com.terraformersmc.traverse.block;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class TraverseWoodTypes {
	public static final WoodType FIR = WoodTypeBuilder.copyOf(WoodType.OAK)
			.register(Identifier.of(Traverse.MOD_ID, "fir"), TraverseBlockSetTypes.FIR);
}
