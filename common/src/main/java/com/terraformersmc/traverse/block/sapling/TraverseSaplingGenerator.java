package com.terraformersmc.traverse.block.sapling;

import java.util.function.Supplier;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class TraverseSaplingGenerator extends SaplingGenerator {
	public final Supplier<RegistryKey<ConfiguredFeature<?, ?>>> tree;

	public TraverseSaplingGenerator(Supplier<RegistryKey<ConfiguredFeature<?, ?>>> tree) {
		this.tree = tree;
	}

	protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
		return this.tree.get();
	}
}
