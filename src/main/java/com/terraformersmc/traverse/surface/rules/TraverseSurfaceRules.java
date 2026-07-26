package com.terraformersmc.traverse.surface.rules;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class TraverseSurfaceRules {

	private static RuleSource block(Block block) {
		return SurfaceRules.state(block.defaultBlockState());
	}

	public static RuleSource bootstrap(HolderGetter<Biome> biomeGetter) {

		// Sandy surface rules
		RuleSource sandAndSandstone = sequence(ifTrue(UNDER_FLOOR,
			block(Blocks.SAND)), block(Blocks.SANDSTONE));
		RuleSource redSandAndSandstone = sequence(ifTrue(UNDER_FLOOR,
			block(Blocks.RED_SAND)), block(Blocks.RED_SANDSTONE));

		// Biome-level rules
		RuleSource desertShrubland = ifTrue(SurfaceRules.isBiome(biomeGetter, TraverseBiomes.DESERT_SHRUBLAND),
			ifTrue(noiseCondition2d(Noises.BADLANDS_SURFACE, 0.01D), sandAndSandstone));
		RuleSource lushSwamp = ifTrue(SurfaceRules.isBiome(biomeGetter, TraverseBiomes.LUSH_SWAMP),
			ifTrue(SurfaceRules.ON_FLOOR,
				ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0),
					ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0)),
						ifTrue(SurfaceRules.noiseCondition2d(Noises.SWAMP, 0.0),
							block(Blocks.WATER))))));

		// Return a surface-only sequence of our surface rules
		return ifTrue(abovePreliminarySurface(),
				sequence(desertShrubland, lushSwamp));
	}
}
