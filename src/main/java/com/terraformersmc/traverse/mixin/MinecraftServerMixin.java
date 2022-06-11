package com.terraformersmc.traverse.mixin;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import com.terraformersmc.traverse.util.TraverseServerAccess;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.SaveLoader;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.WorldGenerationProgressListenerFactory;
import net.minecraft.util.UserCache;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.annotation.Nullable;
import java.net.Proxy;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow public abstract SaveProperties getSaveProperties();

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/SaveLoader;dynamicRegistryManager()Lnet/minecraft/util/registry/DynamicRegistryManager$Immutable;", shift = At.Shift.AFTER),
			method = "<init>",
			locals = LocalCapture.NO_CAPTURE)
	private void traverse$captureServer(Thread serverThread, LevelStorage.Session session, ResourcePackManager dataPackManager, SaveLoader saveLoader, Proxy proxy, DataFixer dataFixer, @Nullable MinecraftSessionService sessionService, @Nullable GameProfileRepository gameProfileRepo, @Nullable UserCache userCache, WorldGenerationProgressListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {
		TraverseServerAccess.capture((MinecraftServer)(Object) this);
		Traverse.LOGGER.debug("MinecraftServerMixin.captureServer captured.");
	}

    @Inject(method = "createWorlds", at = @At("RETURN"), expect = 1, require = -1)
    private void traverse$hackyAddSurfaceRules(WorldGenerationProgressListener $$0, CallbackInfo ci) {
        traverse$appendSurfaceRule(this.getSaveProperties(), DimensionOptions.OVERWORLD, TraverseSurfaceRules.createRules());
    }

    private static void traverse$appendSurfaceRule(SaveProperties worldData, RegistryKey<DimensionOptions> optionsRegistryKey, MaterialRules.MaterialRule materialRule) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        DimensionOptions dimensionOptions = worldData.getGeneratorOptions().getDimensions().get(optionsRegistryKey);
        if (dimensionOptions == null) {
            throw new NullPointerException(String.format("\"%s\" is not a valid level stem key as it doesn't exist in this world's settings. This is more than likely the result of a broken level.dat and most often occurs when moving a world between MC versions.", optionsRegistryKey.getValue()));
        }
        ChunkGenerator chunkGenerator = dimensionOptions.getChunkGenerator();
        if (chunkGenerator instanceof NoiseChunkGenerator) {
            Object noiseGeneratorSettings = ((NoiseChunkGeneratorAccessor) chunkGenerator).traverse$getSettings().value();
            ((ChunkGeneratorSettingsAccessor) noiseGeneratorSettings).traverse$setSurfaceRule(MaterialRules.sequence(materialRule, ((ChunkGeneratorSettings) noiseGeneratorSettings).surfaceRule()));
        }
    }

}
