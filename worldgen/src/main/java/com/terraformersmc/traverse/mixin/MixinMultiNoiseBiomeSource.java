package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.util.TraverseServerAccess;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.Random;

@Mixin(MultiNoiseBiomeSource.class)
public abstract class MixinMultiNoiseBiomeSource extends BiomeSource {

	protected MixinMultiNoiseBiomeSource(List<RegistryEntry<Biome>> biomes) {
		super(biomes);
	}

	@Inject(at = @At(value = "RETURN"),
			method = "getBiome",
			cancellable = true,
			locals = LocalCapture.NO_CAPTURE)
	protected void traverse$overrideGetBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise, CallbackInfoReturnable<RegistryEntry<Biome>> cir) {
		TraverseServerAccess.getServer().ifPresentOrElse(server -> {
			RegistryEntry<Biome> biomeEntry = cir.getReturnValue();
			RegistryKey<Biome> biomeKey = biomeEntry.getKey().orElse(BiomeKeys.THE_VOID);

			// The constant here is basically a salt; it is intended to protect against lame (small) seeds.
			Random random = new Random(1358858879180991417L ^ server.getOverworld().getSeed() ^ ((long) (x >> 6) << 16 + (z >> 6)));
			random.setSeed(random.nextLong());

			if (biomeKey.getValue().getNamespace().equals("minecraft") && random.nextDouble() < 0.3f) {
				Registry<Biome> biomeRegistry = server.getOverworld().getRegistryManager().get(Registry.BIOME_KEY);

				if (biomeKey.equals(BiomeKeys.FOREST)) {
					biomeRegistry.getEntry(TraverseBiomes.AUTUMNAL_WOODS).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.TAIGA)) {
					biomeRegistry.getEntry(TraverseBiomes.CONIFEROUS_FOREST).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.BIRCH_FOREST)) {
					biomeRegistry.getEntry(TraverseBiomes.WOODLANDS).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.DESERT)) {
					biomeRegistry.getEntry(TraverseBiomes.DESERT_SHRUBLAND).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.SWAMP)) {
					biomeRegistry.getEntry(TraverseBiomes.LUSH_SWAMP).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.PLAINS)) {
					biomeRegistry.getEntry(TraverseBiomes.FLATLANDS).ifPresent(cir::setReturnValue);
				} else if (biomeKey.equals(BiomeKeys.SNOWY_TAIGA)) {
					biomeRegistry.getEntry(TraverseBiomes.SNOWY_CONIFEROUS_FOREST).ifPresent(cir::setReturnValue);
				} else {
					return;
				}

				if (!cir.isCancelled()) {
					Traverse.LOGGER.warn("MixinMultiNoiseBiomeSource.overrideGetBiome failed to replace biome: " + biomeKey.getValue());
				}
			}
		}, () -> Traverse.LOGGER.warn("MixinMultiNoiseBiomeSource.overrideGetBiome needs biomes too early!"));
	}
}
