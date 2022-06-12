package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.util.TraverseServerAccess;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ChunkSection.class)
public abstract class MixinChunkSection {
	@Shadow
	private @Final @Mutable PalettedContainer<RegistryEntry<Biome>> biomeContainer;

	@Inject(at = @At(value = "RETURN"),
			method = "<init>(ILnet/minecraft/world/chunk/PalettedContainer;Lnet/minecraft/world/chunk/PalettedContainer;)V",
			locals = LocalCapture.NO_CAPTURE)
	public void traverse$addBiomesToSection(int chunkPos, PalettedContainer<BlockState> blockStateContainer, PalettedContainer<RegistryEntry<Biome>> ignoredBiomeContainer, CallbackInfo ci) {
		TraverseServerAccess.getServer().ifPresent(server -> {
			Registry<Biome> biomeRegistry = server.getOverworld().getRegistryManager().get(Registry.BIOME_KEY);
			biomeContainer = new PalettedContainer<>(biomeRegistry.getIndexedEntries(), biomeRegistry.entryOf(BiomeKeys.PLAINS), PalettedContainer.PaletteProvider.BIOME);
		});
	}
}
