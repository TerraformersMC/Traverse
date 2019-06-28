package io.github.terraformersmc.traverse.generation;

import io.github.terraformersmc.traverse.biome.TraverseBiomes;
import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biomes;

public class TraverseGeneration extends TraverseBiomes {

    public static void register() {
        //Arid Highlands
        OverworldBiomes.addBaseBiome(ARID_HIGHLANDS, OverworldClimate.DRY, 2D);

        //Autumnal Wooded Hills
        OverworldBiomes.addHillsBiome(AUTUMNAL_WOODS, AUTUMNAL_WOODED_HILLS, 1D);

        //Autumnal Woods
        OverworldBiomes.addBaseBiome(AUTUMNAL_WOODS, OverworldClimate.TEMPERATE, 1D);
        OverworldBiomes.addBaseBiome(AUTUMNAL_WOODS, OverworldClimate.COOL, 1D / 4D);

        //Coniferous Forest
        OverworldBiomes.addBaseBiome(CONIFEROUS_FOREST, OverworldClimate.TEMPERATE, 0.8D);
        OverworldBiomes.addBaseBiome(CONIFEROUS_FOREST, OverworldClimate.COOL, 0.3D);

        //Meadow
        OverworldBiomes.addBaseBiome(MEADOW, OverworldClimate.TEMPERATE, 0.9D);
        OverworldBiomes.addBaseBiome(MEADOW, OverworldClimate.COOL, 0.9D);
        OverworldBiomes.addBiomeVariant(Biomes.PLAINS, MEADOW, 0.2D, OverworldClimate.COOL, OverworldClimate.TEMPERATE);

        //Mini Jungle
        OverworldBiomes.addBaseBiome(MINI_JUNGLE, OverworldClimate.TEMPERATE, 0.2D);
        OverworldBiomes.addBiomeVariant(Biomes.SWAMP, MINI_JUNGLE, 0.2D);
        OverworldBiomes.addBiomeVariant(Biomes.JUNGLE, MINI_JUNGLE, 0.15D);

        //Raised Coniferous Forest
        OverworldBiomes.addHillsBiome(CONIFEROUS_FOREST, RAISED_CONIFEROUS_FOREST, 1D);

        //Woodlands
        OverworldBiomes.addBaseBiome(WOODLANDS, OverworldClimate.COOL, 1D);
        OverworldBiomes.addBaseBiome(WOODLANDS, OverworldClimate.TEMPERATE, 1D);

        // Spawn Biomes
        FabricBiomes.addSpawnBiome(ARID_HIGHLANDS);
        FabricBiomes.addSpawnBiome(CONIFEROUS_FOREST);
        FabricBiomes.addSpawnBiome(MEADOW);
        FabricBiomes.addSpawnBiome(WOODLANDS);
    }

}
