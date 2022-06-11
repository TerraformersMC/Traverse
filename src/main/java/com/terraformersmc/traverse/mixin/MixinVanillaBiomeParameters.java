package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(VanillaBiomeParameters.class)
public abstract class MixinVanillaBiomeParameters {
	// Provide a seed with some meat to make sure we get a pseudorandom distribution.
	// I really want to XOR this with the world seed if I can figure out how to get the seed.
	private final static Random random = new Random(1358858879180991417L);

	@Inject(at = @At(value = "RETURN"),
			method = "getRegularBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, CallbackInfoReturnable<RegistryKey<Biome>> cir) {
		RegistryKey<Biome> biomeKey = cir.getReturnValue();
		Biome biome = BuiltinRegistries.BIOME.get(biomeKey);
		//Random random = new Random((long) humidity << 16 + temperature);

		// 20% chance to replace vanilla biomes
		double randomness = random.nextDouble();
		System.out.println("TRAVERSE: Biome " + biomeKey.getValue() + " seen at T, H " + temperature + ", " + humidity + " yields chance: " + randomness);
		if (biomeKey.getValue().getNamespace().equals("minecraft") && randomness < 0.2f) {
			if (biomeKey.equals(BiomeKeys.FOREST)) {
				cir.setReturnValue(RegistryKey.of(Registry.BIOME_KEY, new Identifier("traverse", "autumnal_woods")));
			}
			if (biomeKey.equals(BiomeKeys.TAIGA)) {
				cir.setReturnValue(TraverseBiomes.CONIFEROUS_FOREST);
			}
			if (biomeKey.equals(BiomeKeys.BIRCH_FOREST)) {
				cir.setReturnValue(TraverseBiomes.WOODLANDS);
			}
			if (biomeKey.equals(BiomeKeys.DESERT)) {
				cir.setReturnValue(TraverseBiomes.DESERT_SHRUBLAND);
			}
			if (biomeKey.equals(BiomeKeys.SWAMP)) {
				cir.setReturnValue(TraverseBiomes.LUSH_SWAMP);
			}
			if (biomeKey.equals(BiomeKeys.PLAINS)) {
				cir.setReturnValue(TraverseBiomes.FLATLANDS);
			}
			if (biomeKey.equals(BiomeKeys.SNOWY_TAIGA)) {
				cir.setReturnValue(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);
			}
		}
	}
}
