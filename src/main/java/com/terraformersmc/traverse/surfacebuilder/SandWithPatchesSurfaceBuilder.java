/*
package com.terraformersmc.traverse.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class SandWithPatchesSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {

	private final double threshold;

	public SandWithPatchesSurfaceBuilder(Codec<TernarySurfaceConfig> codec, double threshold) {
		super(codec);
		this.threshold = threshold;
	}

	@Override
	public void generate(Random random, Chunk chunk, Biome biome, int int_1, int int_2, int int_3, double noise, BlockState blockState_1, BlockState blockState_2, int int_4, int int_5, long long_1, TernarySurfaceConfig config) {
		if (noise > threshold) {
			SurfaceBuilder.DEFAULT.generate(random, chunk, biome, int_1, int_2, int_3, noise, blockState_1, blockState_2, int_4, int_5, long_1, config);
		} else {
			SurfaceBuilder.DEFAULT.generate(random, chunk, biome, int_1, int_2, int_3, noise, blockState_1, blockState_2, int_4, int_5, long_1, SurfaceBuilder.SAND_CONFIG);
		}

	}

}

*/
