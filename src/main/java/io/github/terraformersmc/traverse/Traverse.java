package io.github.terraformersmc.traverse;

import io.github.terraformersmc.traverse.biome.TraverseBiomes;
import io.github.terraformersmc.traverse.block.TraverseBlocks;
import io.github.terraformersmc.traverse.feature.TraverseFeatures;
import io.github.terraformersmc.traverse.generation.TraverseGeneration;
import io.github.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.fabricmc.api.ModInitializer;

public class Traverse implements ModInitializer {

    public static final String MOD_ID = "traverse";

    @Override
    public void onInitialize() {
        TraverseBlocks.register();
        TraverseSurfaceBuilders.register();
        TraverseFeatures.register();
        TraverseBiomes.register();
        TraverseGeneration.register();
    }

}
