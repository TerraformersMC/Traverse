package com.terraformersmc.traverse.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ColoredParticleLeavesBlock extends LeavesBlock {
	private final int leafParticleColor;

	public static final MapCodec<ColoredParticleLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(
			(instance) -> instance.group(
							Codecs.rangedInclusiveFloat(0.0f, 1.0f).fieldOf("leaf_particle_chance")
									.forGetter(arg -> arg.leafParticleChance),
							Codecs.RGB.fieldOf("leaf_particle_color")
									.forGetter(arg -> arg.leafParticleColor),
							ColoredParticleLeavesBlock.createSettingsCodec()
					)
					.apply(instance, ColoredParticleLeavesBlock::new));

	public ColoredParticleLeavesBlock(float leafParticleChance, int blockColor, Settings settings) {
		super(leafParticleChance, settings);

		this.leafParticleColor = blockColor;
	}

	@Override
	protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
		EntityEffectParticleEffect effect = EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, leafParticleColor);
		ParticleUtil.spawnParticle(world, pos, random, effect);
	}

	public MapCodec<? extends ColoredParticleLeavesBlock> getCodec() {
		return CODEC;
	}
}
