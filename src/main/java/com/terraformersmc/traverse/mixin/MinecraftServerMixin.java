package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow public abstract SaveProperties getSaveProperties();

    @Inject(method = "createWorlds", at = @At("RETURN"))
    private void traverse_hackyAddSurfaceRules(WorldGenerationProgressListener $$0, CallbackInfo ci) {
        traverse_appendSurfaceRule(this.getSaveProperties(), DimensionOptions.OVERWORLD, TraverseSurfaceRules.TRAVERSE_MATERIAL_RULE);

    }

    private static void traverse_appendSurfaceRule(SaveProperties worldData, RegistryKey<DimensionOptions> optionsRegistryKey, MaterialRules.MaterialRule materialRule) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        DimensionOptions dimensionOptions = worldData.getGeneratorOptions().getDimensions().get(optionsRegistryKey);
        if (dimensionOptions == null) {
            throw new NullPointerException(String.format("\"%s\" is not a valid level stem key as it doesn't exist in this world's settings. This is more than likely the result of a broken level.dat and most often occurs when moving a world between MC versions.", optionsRegistryKey.getValue()));
        }
        ChunkGenerator chunkGenerator = dimensionOptions.getChunkGenerator();
        if (chunkGenerator instanceof NoiseChunkGenerator) {
            Object noiseGeneratorSettings = ((NoiseChunkGeneratorAccessor) chunkGenerator).cinderscapes_getSettings().value();
            ((ChunkGeneratorSettingsAccessor) noiseGeneratorSettings).cinderscapes_setSurfaceRule(MaterialRules.sequence(materialRule, ((ChunkGeneratorSettings) noiseGeneratorSettings).surfaceRule()));
        }
    }

}
