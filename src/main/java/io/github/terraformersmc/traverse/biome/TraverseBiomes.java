package io.github.terraformersmc.traverse.biome;

import io.github.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class TraverseBiomes {

    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    public static final AutumnalWoodsBiome AUTUMNAL_WOODS = add("autumnal_woods", new AutumnalWoodsBiome());

    public static <B extends Biome> B add(String name, B biome) {
        BIOMES.put(new Identifier(Traverse.MOD_ID, name), biome);
        return biome;
    }

    public static void register() {
        for (Identifier id : BIOMES.keySet()) {
            Registry.register(Registry.BIOME, id, BIOMES.get(id));
        }
    }

}
