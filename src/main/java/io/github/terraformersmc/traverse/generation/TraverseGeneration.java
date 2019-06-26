package io.github.terraformersmc.traverse.generation;

import io.github.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;

public class TraverseGeneration extends TraverseBiomes {

    public static void register() {
        OverworldBiomes.addBaseBiome(AUTUMNAL_WOODS, OverworldClimate.TEMPERATE, 1D);
        OverworldBiomes.addBaseBiome(AUTUMNAL_WOODS, OverworldClimate.COOL, 1D / 6D);
    }

}
