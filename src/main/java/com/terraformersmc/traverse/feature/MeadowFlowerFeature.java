package com.terraformersmc.traverse.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.FlowerFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class MeadowFlowerFeature extends FlowerFeature<RandomPatchFeatureConfig> {

    public MeadowFlowerFeature(Function<Dynamic<?>, ? extends RandomPatchFeatureConfig> function) {
        super(function);
    }

	@Override
    public BlockState getFlowerToPlace(Random random, BlockPos pos, RandomPatchFeatureConfig config) {
        int n = random.nextInt(12);
        if (n >= 0 && n <= 2) {
            return Blocks.POPPY.getDefaultState();
        }
        else if (n >= 3 && n <= 5) {
            return Blocks.AZURE_BLUET.getDefaultState();
        }
        else if (n >= 6 && n <= 8) {
            return Blocks.OXEYE_DAISY.getDefaultState();
        }
        else if (n >= 9 && n <= 10) {
            return Blocks.DANDELION.getDefaultState();
        }
        else {
            int t = random.nextInt(5);
            if (t == 0) {
                return Blocks.ORANGE_TULIP.getDefaultState();
            }
            else if (t == 1) {
                return Blocks.PINK_TULIP.getDefaultState();
            }
            else if (t == 2) {
                return Blocks.RED_TULIP.getDefaultState();
            }
            else {
                return Blocks.WHITE_TULIP.getDefaultState();
            }
        }
    }

//	@Override
//    public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos blockPos, FlowerFeatureConfig defaultFeatureConfig) {
//        return generate(world, generator, random, blockPos, defaultFeatureConfig);
//    }

	@Override
	public boolean method_23369(IWorld iWorld, BlockPos blockPos, RandomPatchFeatureConfig featureConfig) {
		return false;
	}

	@Override
	public int method_23370(RandomPatchFeatureConfig featureConfig) {
		return 0;
	}

	@Override
	public BlockPos method_23371(Random random, BlockPos blockPos, RandomPatchFeatureConfig featureConfig) {
		return null;
	}

}
