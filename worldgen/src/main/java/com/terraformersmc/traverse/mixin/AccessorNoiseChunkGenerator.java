package com.terraformersmc.traverse.mixin;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NoiseChunkGenerator.class)
public interface AccessorNoiseChunkGenerator {
    @Accessor("settings")
    RegistryEntry<ChunkGeneratorSettings> traverse$getSettings();
}
