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

	//private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

	//public static final SurfaceBuilder<TernarySurfaceConfig> WOODED_ISLAND = add("wooded_island", new BeachSurfaceBuilder(TernarySurfaceConfig.CODEC, 62, v -> Blocks.SAND.getDefaultState()));
	/*private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
		SURFACE_BUILDERS.put(new Identifier(Traverse.MOD_ID, name), feature);
		return feature;
	}*/

	private static MaterialRule block(Block block){
		return MaterialRules.block(block.getDefaultState());
	}

	public static MaterialRule createRules(){
		MaterialRule defaultGrass = VanillaSurfaceRules.createDefaultRule(true, false, true);
		MaterialRule sandAndSandstone = sequence(condition(MaterialRules.STONE_DEPTH_CEILING, block(Blocks.SANDSTONE)), block(Blocks.SAND));
		MaterialRule desertShrubland = condition(MaterialRules.biome(TraverseBiomes.DESERT_SHRUBLAND), new SandWithPatchesSurfaceRule(1.5D, NoiseParametersKeys.SURFACE, defaultGrass, sandAndSandstone));
		MaterialRule aridHighlands = condition(MaterialRules.biome(TraverseBiomes.ARID_HIGHLANDS), new SandWithPatchesSurfaceRule(0.9D, NoiseParametersKeys.SURFACE, defaultGrass, sandAndSandstone));
		MaterialRule cliffs = condition(MaterialRules.biome(TraverseBiomes.CLIFFS, TraverseBiomes.SNOWY_CLIFFS),
				condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, sequence(
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.CALCITE, -0.0125, 0.0125), block(Blocks.CALCITE)),
						block(Blocks.STONE))));
		MaterialRule lushSwamp = condition(MaterialRules.biome(TraverseBiomes.LUSH_SWAMP),
				condition(MaterialRules.STONE_DEPTH_FLOOR,
						condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
								condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(63), 0)),
										condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0), block(Blocks.WATER))))));
		// I have no idea how to do this...  Still trying to understand if it's even possible to make islands in 1.18.
		//MaterialRule woodedIsland = condition(MaterialRules.biome(TraverseBiomes.WOODED_ISLAND),
		//				condition(stoneDepth(62, true, VerticalSurfaceType.CEILING), block(Blocks.STONE)));

		return sequence(condition(MaterialRules.surface(), sequence(desertShrubland, aridHighlands, cliffs, lushSwamp)), defaultGrass);
	}

	public static void register() {
		Registry.register(Registry.MATERIAL_RULE, new Identifier(Traverse.MOD_ID,"sand_with_patches_rule"), SandWithPatchesSurfaceRule.CONDITION_CODEC);
	}

	/*public static MaterialRule createDefaultRule(boolean surface, boolean bedrockRoof, boolean bedrockFloor) {
		MaterialRules.MaterialCondition materialCondition = MaterialRules.aboveY(YOffset.fixed(97), 2);
		MaterialRules.MaterialCondition materialCondition2 = MaterialRules.aboveY(YOffset.fixed(256), 0);
		MaterialRules.MaterialCondition materialCondition3 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(63), -1);
		MaterialRules.MaterialCondition materialCondition4 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(74), 1);
		MaterialRules.MaterialCondition materialCondition5 = MaterialRules.aboveY(YOffset.fixed(62), 0);
		MaterialRules.MaterialCondition materialCondition6 = MaterialRules.aboveY(YOffset.fixed(63), 0);
		MaterialRules.MaterialCondition materialCondition7 = MaterialRules.water(-1, 0);
		MaterialRules.MaterialCondition materialCondition8 = MaterialRules.water(0, 0);
		MaterialRules.MaterialCondition materialCondition9 = MaterialRules.waterWithStoneDepth(-6, -1);
		MaterialRules.MaterialCondition materialCondition10 = MaterialRules.hole();
		MaterialRules.MaterialCondition materialCondition11 = MaterialRules.biome(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN);
		MaterialRules.MaterialCondition materialCondition12 = MaterialRules.steepSlope();
		MaterialRule materialRule = sequence(condition(materialCondition8, GRASS_BLOCK), DIRT);
		MaterialRule materialRule2 = sequence(condition(MaterialRules.STONE_DEPTH_CEILING, SANDSTONE), SAND);
		MaterialRule materialRule3 = sequence(condition(MaterialRules.STONE_DEPTH_CEILING, STONE), GRAVEL);
		MaterialRules.MaterialCondition materialCondition13 = MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.BEACH, BiomeKeys.SNOWY_BEACH);
		MaterialRules.MaterialCondition materialCondition14 = MaterialRules.biome(BiomeKeys.DESERT);
		MaterialRule materialRule4 = sequence(
				condition(MaterialRules.biome(BiomeKeys.STONY_PEAKS), sequence(condition(MaterialRules.noiseThreshold(NoiseParametersKeys.CALCITE, -0.0125, 0.0125), CALCITE), STONE)),
				condition(MaterialRules.biome(BiomeKeys.STONY_SHORE), sequence(condition(MaterialRules.noiseThreshold(NoiseParametersKeys.GRAVEL, -0.05, 0.05), materialRule3), STONE)),
				condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_HILLS), condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.0), STONE)),
				condition(materialCondition13, materialRule2),
				condition(materialCondition14, materialRule2),
				condition(MaterialRules.biome(BiomeKeys.DRIPSTONE_CAVES), STONE));
		MaterialRule materialRule5 = condition(MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.45, 0.58), condition(materialCondition8, POWDER_SNOW));
		MaterialRule materialRule6 = condition(MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.35, 0.6), condition(materialCondition8, POWDER_SNOW));
		MaterialRule materialRule7 = sequence(
				condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS), sequence(
						condition(materialCondition12, PACKED_ICE),
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, -0.5, 0.2), PACKED_ICE),
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, -0.0625, 0.025), ICE),
						condition(materialCondition8, SNOW_BLOCK))),
				condition(MaterialRules.biome(BiomeKeys.SNOWY_SLOPES), sequence(
						condition(materialCondition12, STONE),
						materialRule5,
						condition(materialCondition8, SNOW_BLOCK))),
				condition(MaterialRules.biome(BiomeKeys.JAGGED_PEAKS), STONE),
				condition(MaterialRules.biome(BiomeKeys.GROVE), sequence(materialRule5, DIRT)),
				materialRule4,
				condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.75), STONE)),
				condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS), sequence(
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(2.0), materialRule3),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.0), STONE),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(-1.0), DIRT),
						materialRule3)),
				DIRT);
		MaterialRule materialRule8 = sequence(
				condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS), sequence(
						condition(materialCondition12, PACKED_ICE),
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, 0.0, 0.2), PACKED_ICE),
						condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, 0.0, 0.025), ICE),
						condition(materialCondition8, SNOW_BLOCK))),
				condition(MaterialRules.biome(BiomeKeys.SNOWY_SLOPES), sequence(
						condition(materialCondition12, STONE),
						materialRule6,
						condition(materialCondition8, SNOW_BLOCK))),
				condition(MaterialRules.biome(BiomeKeys.JAGGED_PEAKS), sequence(
						condition(materialCondition12, STONE),
						condition(materialCondition8, SNOW_BLOCK))),
				condition(MaterialRules.biome(BiomeKeys.GROVE), sequence(
						materialRule6,
						condition(materialCondition8, SNOW_BLOCK))),
				materialRule4,
				condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA), sequence(
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.75), STONE),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(-0.5), COARSE_DIRT))),
				condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS), sequence(
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(2.0), materialRule3),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.0), STONE),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(-1.0), materialRule),
						materialRule3)),
				condition(MaterialRules.biome(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), sequence(
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(1.75), COARSE_DIRT),
						condition(VanillaSurfaceRules.surfaceNoiseThreshold(-0.95), PODZOL))),
				condition(MaterialRules.biome(BiomeKeys.ICE_SPIKES), condition(materialCondition8, SNOW_BLOCK)),
				condition(MaterialRules.biome(BiomeKeys.MUSHROOM_FIELDS), MYCELIUM),
				materialRule);
		MaterialRules.MaterialCondition materialCondition15 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.909, -0.5454);
		MaterialRules.MaterialCondition materialCondition16 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1818, 0.1818);
		MaterialRules.MaterialCondition materialCondition17 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5454, 0.909);
		MaterialRule materialRule9 = sequence(
				condition(MaterialRules.STONE_DEPTH_FLOOR,
						sequence(
								condition(MaterialRules.biome(BiomeKeys.WOODED_BADLANDS), condition(materialCondition,
										sequence(
												condition(materialCondition15, COARSE_DIRT),
												condition(materialCondition16, COARSE_DIRT),
												condition(materialCondition17, COARSE_DIRT),
												materialRule
										))),
								condition(MaterialRules.biome(BiomeKeys.SWAMP),
										condition(materialCondition5,
												condition(MaterialRules.not(materialCondition6),
														condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0), WATER))))
						)
				),
				condition(MaterialRules.biome(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS),
						sequence(
								condition(MaterialRules.STONE_DEPTH_FLOOR,
										sequence(
												condition(materialCondition2, ORANGE_TERRACOTTA),
												condition(materialCondition4, sequence(
														condition(materialCondition15, TERRACOTTA),
														condition(materialCondition16, TERRACOTTA),
														condition(materialCondition17, TERRACOTTA),
														MaterialRules.terracottaBands())
												),
												condition(materialCondition7, sequence(
														condition(MaterialRules.STONE_DEPTH_CEILING, RED_SANDSTONE),
														RED_SAND)),
												condition(MaterialRules.not(materialCondition10), ORANGE_TERRACOTTA),
												condition(materialCondition9, WHITE_TERRACOTTA), materialRule3)
								),
								condition(materialCondition3, sequence(
										condition(materialCondition6, condition(MaterialRules.not(materialCondition4), ORANGE_TERRACOTTA)),
										MaterialRules.terracottaBands())),
								condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, condition(materialCondition9, WHITE_TERRACOTTA)))
				),
				condition(MaterialRules.STONE_DEPTH_FLOOR,
						condition(materialCondition7, sequence(
								condition(materialCondition11,
										condition(materialCondition10, sequence(
												condition(materialCondition8, AIR),
												condition(MaterialRules.temperature(), ICE), WATER)
										)
								),
								materialRule8)
						)
				),
				condition(materialCondition9, sequence(
						condition(MaterialRules.STONE_DEPTH_FLOOR, condition(materialCondition11, condition(materialCondition10, WATER))),
						condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, materialRule7),
						condition(materialCondition13, condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, SANDSTONE)),
						condition(materialCondition14, condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_30, SANDSTONE)))
				),
				condition(MaterialRules.STONE_DEPTH_FLOOR, sequence(
						condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS), STONE),
						condition(MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), materialRule2), materialRule3)
				)
		);
		ImmutableList.Builder builder = ImmutableList.builder();
		if (bedrockRoof) {
			builder.add(condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), BEDROCK));
		}
		if (bedrockFloor) {
			builder.add(condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK));
		}
		MaterialRule materialRule10 = condition(MaterialRules.surface(), materialRule9);
		builder.add(surface ? materialRule10 : materialRule9);
		builder.add(condition(MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8)), DEEPSLATE));
		return sequence((MaterialRule[])builder.build().toArray(MaterialRule[]::new));
	}*/

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
