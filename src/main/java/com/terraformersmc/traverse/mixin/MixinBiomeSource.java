package com.terraformersmc.traverse.mixin;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.util.TraverseServerAccess;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.fabricmc.fabric.mixin.datagen.DynamicRegistryManagerAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.BiomeSupplier;
import net.minecraft.world.dimension.DimensionType;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Mixin(BiomeSource.class)
public abstract class MixinBiomeSource implements BiomeSupplier {
	private static Set<RegistryEntry<Biome>> extendedBiomes;
	private static Supplier<List<BiomeSource.IndexedFeatures>> extendedFeaturesSupplier;
	private static boolean alreadyExtended = false;

	@Shadow
	private @Final @Mutable Set<RegistryEntry<Biome>> biomes;

	@Shadow
	private @Final @Mutable Supplier<List<BiomeSource.IndexedFeatures>> indexedFeaturesSupplier;

	@Shadow
	protected abstract List<BiomeSource.IndexedFeatures> method_39525(List<RegistryEntry<Biome>> biomes, boolean bl);

	@Inject(at = @At(value = "RETURN"),
			method = "<init>(Ljava/util/List;)V",
			locals = LocalCapture.NO_CAPTURE)
	private void traverse$addBiomesToSource(List<RegistryEntry<Biome>> defaultBiomes, CallbackInfo ci) {
		MinecraftServer server = TraverseServerAccess.getLastServer();

		if (server == null)
			Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource needs biomes too early!");

		if (alreadyExtended) {
			biomes = extendedBiomes;
		} else if(defaultBiomes.contains(BuiltinRegistries.BIOME.getEntry(BiomeKeys.PLAINS).get())) {
			if(server != null) {
				Registry<Biome> biomeRegistry = server.getRegistryManager().get(Registry.BIOME_KEY);

				ImmutableList.Builder<RegistryEntry<Biome>> builder = ImmutableList.builder();
				builder.addAll(defaultBiomes);
				for (RegistryKey<Biome> biomeKey : TraverseBiomes.BIOMES.keySet()) {
					biomeRegistry.getEntry(biomeKey).ifPresent(biomeRegistryEntry -> {
							if (biomeRegistryEntry.value() == null) {
								Traverse.LOGGER.warn("DEBUGGING: Biome null for: " + biomeKey.getValue());
							} else {
								Traverse.LOGGER.info("DEBUGGING: Biome: " + biomeRegistryEntry.value());
								Traverse.LOGGER.info("DEBUGGING: Biome Identifier: " + biomeRegistryEntry.getKey().get().getValue());
								Traverse.LOGGER.info("DEBUGGING: Biome Raw ID: " + biomeRegistry.getRawId(biomeRegistryEntry.value()));
							}
					});
					biomeRegistry.getEntry(biomeKey).ifPresentOrElse(builder::add,
						() -> Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource cannot get registry entry for: " + biomeKey.getValue()));
				}
				ImmutableList<RegistryEntry<Biome>> biomeList = builder.build().stream().distinct().collect(ImmutableList.toImmutableList());

				biomes = extendedBiomes = new ObjectLinkedOpenHashSet<>(biomeList);
				alreadyExtended = true;

/*
				Registry<Biome> biomeRegistry = server.getRegistryManager().get(Registry.BIOME_KEY);
				for (RegistryKey<Biome> biomeKey : TraverseBiomes.BIOMES.keySet()) {
					biomeRegistry.getEntry(biomeKey).ifPresentOrElse(extendedBiomes::add,
						() -> Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource cannot get registry entry for: " + biomeKey.getValue()));
				}
				alreadyExtended = true;
*/
			}
		}

		if (alreadyExtended) {
//			biomes = new HashSet<>(extendedBiomes);
//			indexedFeaturesSupplier = Suppliers.memoize(() -> this.method_39525(biomes.stream().toList(), true));
		}

/*
		MinecraftServer server = TraverseServerAccess.getLastServer();
		if (server != null) {
			Registry<Biome> biomeRegistry = server.getOverworld().getRegistryManager().get(Registry.BIOME_KEY);
			for (RegistryKey<Biome> key : TraverseBiomes.BIOMES.keySet()) {
				biomeRegistry.getEntry(key).ifPresentOrElse(biomeEntry -> {
					if (!biomes.contains(biomeEntry)) {
						if (!biomes.add(biomeEntry)) {
							Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource add failed: " + key.getValue());
						}
					}
				}, () -> Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource lookup failed: " + key.getValue()));
			}

		} else {
			Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource needs biomes too early!");
		}

		Traverse.LOGGER.error("Do we see a Traverse biome?  " + Boolean.toString(BuiltinRegistries.BIOME.contains(TraverseBiomes.AUTUMNAL_WOODS)));
		indexedFeaturesSupplier = Suppliers.memoize(() -> method_39525(new ArrayList<>(BuiltinRegistries.BIOME.streamEntries().toList()), true));
*/
		Traverse.LOGGER.info("BiomeSource<init> complete.");
	}

//	@Inject(at = @At("HEAD"),
//			method = "method_40141",
//			cancellable = true)
//	private void traverse$skipInitialIndexedFeaturesBroken(List<RegistryEntry<Biome>> biomes, CallbackInfoReturnable<List<BiomeSource.IndexedFeatures>> cir) {
//		Traverse.LOGGER.info("Cancelling method_40141 computation...");
//		cir.setReturnValue(new ArrayList<>());
//	}

	@Inject(at = @At("HEAD"),
			method = "method_39525",
			cancellable = true)
	private void traverse$skipInitialIndexedFeatures(List<RegistryEntry<Biome>> biomes, boolean bl, CallbackInfoReturnable<List<BiomeSource.IndexedFeatures>> cir) {
		MinecraftServer server = TraverseServerAccess.getLastServer();

		if (server != null && biomes.contains(server.getRegistryManager().get(Registry.BIOME_KEY).getEntry(BiomeKeys.PLAINS).get())) {
			Registry<Biome> biomeRegistry = server.getRegistryManager().get(Registry.BIOME_KEY);

			ImmutableList.Builder<RegistryEntry<Biome>> builder = ImmutableList.builder();
			builder.addAll(biomes);
			for (RegistryKey<Biome> biomeKey : TraverseBiomes.BIOMES.keySet()) {
				biomeRegistry.getEntry(biomeKey).ifPresent(biomeRegistryEntry -> {
					if (biomeRegistryEntry.value() == null) {
						Traverse.LOGGER.warn("DEBUGGING: Biome null for: " + biomeKey.getValue());
					} else {
						Traverse.LOGGER.info("DEBUGGING: Biome: " + biomeRegistryEntry.value());
						Traverse.LOGGER.info("DEBUGGING: Biome Identifier: " + biomeRegistryEntry.getKey().get().getValue());
						Traverse.LOGGER.info("DEBUGGING: Biome Raw ID: " + biomeRegistry.getRawId(biomeRegistryEntry.value()));
					}
				});
				biomeRegistry.getEntry(biomeKey).ifPresentOrElse(builder::add,
						() -> Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource cannot get registry entry for: " + biomeKey.getValue()));
			}
			biomes = builder.build().stream().distinct().collect(ImmutableList.toImmutableList());
		} else {
			Traverse.LOGGER.warn("MixinBiomeSource.addBiomesForFeatures needs biomes too early!");
		}


		if (server == null) {
			Traverse.LOGGER.warn("Cancelling method_39525 computation for now...");
			cir.setReturnValue(new ArrayList<>());
		} else {
			Traverse.LOGGER.warn("Let 'er rip!!");
			for (RegistryEntry<Biome> biome : biomes) {
				biome.getKey().ifPresentOrElse(key -> Traverse.LOGGER.info("Found biome: " + key.getValue()),
						() -> Traverse.LOGGER.warn("Found biome with NO KEY..."));
			}
		}
	}

/*
	protected void addBiomesToSource() {
		MinecraftServer server = TraverseServerAccess.getLastServer();
		assert(server != null);  // we're called when it's created after all

		if (!alreadyExtended) {
			Registry<Biome> biomeRegistry = server.getRegistryManager().get(Registry.BIOME_KEY);
			for (RegistryKey<Biome> biomeKey : TraverseBiomes.BIOMES.keySet()) {
				biomeRegistry.getEntry(biomeKey).ifPresentOrElse(extendedBiomes::add,
					() -> Traverse.LOGGER.warn("MixinBiomeSource.addBiomesToSource cannot get registry entry for: " + biomeKey.getValue()));
			}
			alreadyExtended = true;
		}
	}
*/
}
