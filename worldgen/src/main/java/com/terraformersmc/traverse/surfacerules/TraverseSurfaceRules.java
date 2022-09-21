package com.terraformersmc.traverse.surfacerules;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule;

import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class TraverseSurfaceRules {

	private static MaterialRule block(Block block) {
		return MaterialRules.block(block.getDefaultState());
	}

	public static MaterialRule createRules() {

		// Sandy surface rules
		MaterialRule sandAndSandstone = sequence(condition(STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
			block(Blocks.SAND)), block(Blocks.SANDSTONE));
		MaterialRule redSandAndSandstone = sequence(condition(STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
			block(Blocks.RED_SAND)), block(Blocks.RED_SANDSTONE));

		// Biome-level rules
		MaterialRule desertShrubland = condition(MaterialRules.biome(TraverseBiomes.DESERT_SHRUBLAND),
			condition(noiseThreshold(NoiseParametersKeys.BADLANDS_SURFACE, 0.01D), sandAndSandstone));
		MaterialRule lushSwamp = condition(MaterialRules.biome(TraverseBiomes.LUSH_SWAMP),
			condition(MaterialRules.STONE_DEPTH_FLOOR,
				condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
					condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(63), 0)),
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0),
							block(Blocks.WATER))))));

		// Return a surface-only sequence of our surface rules
		return condition(surface(),
				sequence(desertShrubland, lushSwamp));
	}

	public static void register() {
	}
}
