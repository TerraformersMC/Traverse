package com.terraformersmc.traverse.block.sapling;

import java.util.function.Supplier;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class TraverseSaplingGenerator extends SaplingGenerator {
	public final Supplier<RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>>> tree;

	public TraverseSaplingGenerator(Supplier<RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>>> tree) {
		this.tree = tree;
	}

	protected RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(Random random, boolean bl) {
		return this.tree.get();
	}
}
