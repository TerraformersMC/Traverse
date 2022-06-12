package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.biome.TraverseBiomes;
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

import java.util.Optional;
import java.util.Random;

@Mixin(VanillaBiomeParameters.class)
public abstract class MixinVanillaBiomeParameters {
	// Provide a random seed with some meat to get a better initial pseudorandom values.
	// I really wanted to XOR this with the world seed but there is no world when this runs.
	// OTOH that means the results are deterministic so we know we get all the biomes.
	private final static Random random = new Random(7357857879180991417L);

	@Inject(at = @At(value = "RETURN"),
			method = "getRegularBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, CallbackInfoReturnable<RegistryKey<Biome>> cir) {
		RegistryKey<Biome> biomeKey = cir.getReturnValue();

		getBiomeOverride(temperature, humidity, biomeKey).ifPresent(cir::setReturnValue);
	}

	@Inject(at = @At(value = "RETURN"),
			method = "getShoreBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideShoreBiome(int temperature, int humidity, CallbackInfoReturnable<RegistryKey<Biome>> cir) {
		RegistryKey<Biome> biomeKey = cir.getReturnValue();

		getBiomeOverride(temperature, humidity, biomeKey).ifPresent(cir::setReturnValue);
	}

	@Inject(at = @At(value = "RETURN"),
			method = "getBadlandsBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideBadlandsBiome(int humidity, MultiNoiseUtil.ParameterRange weirdness, CallbackInfoReturnable<RegistryKey<Biome>> cir) {
		RegistryKey<Biome> biomeKey = cir.getReturnValue();

		getBiomeOverride(4, humidity, biomeKey).ifPresent(cir::setReturnValue);
	}

	@Inject(at = @At(value = "RETURN"),
			method = "getNearMountainBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideNearMountainBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, CallbackInfoReturnable<RegistryKey<Biome>> cir) {
		RegistryKey<Biome> biomeKey = cir.getReturnValue();

		getBiomeOverride(temperature, humidity, biomeKey).ifPresent(cir::setReturnValue);
	}

	protected Optional<RegistryKey<Biome>> getBiomeOverride(int temperature, int humidity, RegistryKey<Biome> biomeKey) {
		Optional<RegistryKey<Biome>> newBiomeKey = Optional.empty();

		// 20% chance to replace vanilla biomes
		if (biomeKey.getValue().getNamespace().equals("minecraft") && random.nextDouble() < 0.2f) {
			if (biomeKey.equals(BiomeKeys.FOREST)) {
				newBiomeKey = Optional.of(TraverseBiomes.AUTUMNAL_WOODS);
			} else if (biomeKey.equals(BiomeKeys.TAIGA)) {
				newBiomeKey = Optional.of(TraverseBiomes.CONIFEROUS_FOREST);
			} else if (biomeKey.equals(BiomeKeys.BIRCH_FOREST)) {
				newBiomeKey = Optional.of(TraverseBiomes.WOODLANDS);
			} else if (biomeKey.equals(BiomeKeys.DESERT)) {
				newBiomeKey = Optional.of(TraverseBiomes.DESERT_SHRUBLAND);
			} else if (biomeKey.equals(BiomeKeys.SWAMP) || (humidity == 4 && temperature > 2 && temperature < 5)) {
				// 1.18.2, at least, does not give me a good place to hook in for SWAMP, so I'm winging it.
				// I don't love this setting but it fits in OK, often tucked along a jungle biome or river...
				newBiomeKey = Optional.of(TraverseBiomes.LUSH_SWAMP);
			} else if (biomeKey.equals(BiomeKeys.PLAINS)) {
				newBiomeKey = Optional.of(TraverseBiomes.FLATLANDS);
			} else if (biomeKey.equals(BiomeKeys.SNOWY_TAIGA)) {
				newBiomeKey = Optional.of(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);
			}
		}

		return newBiomeKey;
	}
}
