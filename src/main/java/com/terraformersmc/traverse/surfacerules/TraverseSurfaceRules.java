package com.terraformersmc.traverse.surfacerules;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;

public class TraverseSurfaceRules {

	//private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

	//public static final SurfaceBuilder<TernarySurfaceConfig> WOODED_ISLAND = add("wooded_island", new BeachSurfaceBuilder(TernarySurfaceConfig.CODEC, 62, v -> Blocks.SAND.getDefaultState()));
	static MaterialRules.MaterialRule materialRule = MaterialRules.sequence(MaterialRules.condition(MaterialRules.water(0, 0), MaterialRules.block(Blocks.GRASS_BLOCK.getDefaultState())), MaterialRules.block(Blocks.DIRT.getDefaultState()));
	static MaterialRules.MaterialRule materialRule2 = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, MaterialRules.block(Blocks.SANDSTONE.getDefaultState())), MaterialRules.block(Blocks.SAND.getDefaultState()));
	public static final MaterialRules.MaterialRule DESERT_SHRUBLAND = MaterialRules.condition(MaterialRules.biome(TraverseBiomes.DESERT_SHRUBLAND), new SandWithPatchesSurfaceRule(1.5D, NoiseParametersKeys.SURFACE, materialRule, materialRule2));
	public static final MaterialRules.MaterialRule ARID_HIGHLANDS = MaterialRules.condition(MaterialRules.biome(TraverseBiomes.ARID_HIGHLANDS), new SandWithPatchesSurfaceRule(0.9D, NoiseParametersKeys.SURFACE, materialRule, materialRule2));


	public static final MaterialRules.MaterialRule TRAVERSE_MATERIAL_RULE = MaterialRules.sequence(MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), MaterialRules.block(Blocks.BEDROCK.getDefaultState())), MaterialRules.condition(MaterialRules.surface(), MaterialRules.sequence(DESERT_SHRUBLAND, ARID_HIGHLANDS)));
	/*private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
		SURFACE_BUILDERS.put(new Identifier(Traverse.MOD_ID, name), feature);
		return feature;
	}*/

	public static void register() {
		/*for (Identifier id : SURFACE_BUILDERS.keySet()) {
			Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
		}*/
	}

	record SandWithPatchesSurfaceRule(double threshold, RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> noise, MaterialRules.MaterialRule thenRun, MaterialRules.MaterialRule elseRun) implements MaterialRules.MaterialRule {

		static final Codec<SandWithPatchesSurfaceRule> CONDITION_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.DOUBLE.fieldOf("threshold").forGetter(SandWithPatchesSurfaceRule::threshold),
				RegistryKey.createCodec(Registry.NOISE_WORLDGEN).fieldOf("noise").forGetter(SandWithPatchesSurfaceRule::noise),
				MaterialRules.MaterialRule.CODEC.fieldOf("then_run").forGetter(SandWithPatchesSurfaceRule::thenRun),
				MaterialRules.MaterialRule.CODEC.fieldOf("else_run").forGetter(SandWithPatchesSurfaceRule::elseRun)).apply(instance, SandWithPatchesSurfaceRule::new));

		@Override
		public Codec<? extends MaterialRules.MaterialRule> codec() {
			return CONDITION_CODEC;
		}

		@Override
		public MaterialRules.BlockStateRule apply(MaterialRules.MaterialRuleContext context) {
			MaterialRules.BlockStateRule followup1 = thenRun.apply(context);
			MaterialRules.BlockStateRule followup2 = elseRun.apply(context);
			final DoublePerlinNoiseSampler doublePerlinNoiseSampler = context.surfaceBuilder.getNoiseSampler(this.noise);
			return (x, y, z) -> {
				double noise = doublePerlinNoiseSampler.sample(x, 0.0, y);
				if (noise > threshold){
					return followup1.tryApply(x, y, z);
				} else {
					return followup2.tryApply(x, y, z);
				}
			};
		}
	}

}
