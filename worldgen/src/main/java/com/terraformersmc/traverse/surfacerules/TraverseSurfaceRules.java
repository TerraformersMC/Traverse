package com.terraformersmc.traverse.surfacerules;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;

import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class TraverseSurfaceRules {

	private static MaterialRule block(Block block) {
		return MaterialRules.block(block.getDefaultState());
	}

	public static MaterialRule createRules() {
		MaterialRule defaultGrass = VanillaSurfaceRules.createDefaultRule(true, false, true);
		MaterialRule sandAndSandstone = sequence(condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
				block(Blocks.SAND)), block(Blocks.SANDSTONE));

		MaterialRule desertShrubland = condition(MaterialRules.biome(TraverseBiomes.DESERT_SHRUBLAND),
				new SandWithPatchesSurfaceRule(0.01D, NoiseParametersKeys.BADLANDS_SURFACE, sandAndSandstone, defaultGrass));
		MaterialRule lushSwamp = condition(MaterialRules.biome(TraverseBiomes.LUSH_SWAMP),
				condition(MaterialRules.STONE_DEPTH_FLOOR,
						condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
								condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(63), 0)),
										condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0),
												block(Blocks.WATER))))));

		return sequence(condition(MaterialRules.surface(), sequence(desertShrubland, lushSwamp, defaultGrass)), defaultGrass);
	}

	public static void register() {
		Registry.register(Registry.MATERIAL_RULE, new Identifier(Traverse.MOD_ID,"sand_with_patches_rule"), SandWithPatchesSurfaceRule.CONDITION_CODEC);
	}

	record SandWithPatchesSurfaceRule(double threshold, RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> noise, MaterialRule thenRun, MaterialRule elseRun) implements MaterialRule {

		static final Codec<SandWithPatchesSurfaceRule> CONDITION_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.DOUBLE.fieldOf("threshold").forGetter(SandWithPatchesSurfaceRule::threshold),
				RegistryKey.createCodec(Registry.NOISE_WORLDGEN).fieldOf("noise").forGetter(SandWithPatchesSurfaceRule::noise),
				MaterialRule.CODEC.fieldOf("then_run").forGetter(SandWithPatchesSurfaceRule::thenRun),
				MaterialRule.CODEC.fieldOf("else_run").forGetter(SandWithPatchesSurfaceRule::elseRun)).apply(instance, SandWithPatchesSurfaceRule::new));

		@Override
		public Codec<? extends MaterialRule> codec() {
			return CONDITION_CODEC;
		}

		@Override
		public MaterialRules.BlockStateRule apply(MaterialRules.MaterialRuleContext context) {
			MaterialRules.BlockStateRule followup1 = thenRun.apply(context);
			MaterialRules.BlockStateRule followup2 = elseRun.apply(context);
			final DoublePerlinNoiseSampler doublePerlinNoiseSampler = context.surfaceBuilder.getNoiseSampler(this.noise);
			return (x, y, z) -> {
				double noise = doublePerlinNoiseSampler.sample(x, 0.0, z);
				if (noise > threshold){
					return followup1.tryApply(x, y, z);
				} else {
					return followup2.tryApply(x, y, z);
				}
			};
		}
	}
}
