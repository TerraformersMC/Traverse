package com.terraformersmc.traverse.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;

import java.util.Random;
import java.util.function.Function;

public class MeadowFlowerFeature extends FlowerFeature {

    public MeadowFlowerFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function) {
        super(function);
    }

    @Override
    public BlockState getFlowerToPlace(Random random, BlockPos pos) {
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

    @Override
    public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos blockPos, DefaultFeatureConfig defaultFeatureConfig) {
        return method_13176(world, generator, random, blockPos, defaultFeatureConfig);
    }

}
