package io.github.terraformersmc.traverse.biome;

import io.github.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class TraverseBiomes {

    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    public static final Biome ARID_HIGHLANDS = add("arid_highlands", new AridHighlandsBiome());
    public static final Biome AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", new AutumnalWoodedHillsBiome());
    public static final Biome AUTUMNAL_WOODS = add("autumnal_woods", new AutumnalWoodsBiome());
    public static final Biome CONIFEROUS_FOREST = add("coniferous_forest", new ConiferousForestBiome());
    public static final Biome MEADOW = add("meadow", new MeadowBiome());
    public static final Biome MINI_JUNGLE = add("mini_jungle", new MiniJungleBiome());
    public static final Biome RAISED_CONIFEROUS_FOREST = add("raised_coniferous_forest", new RaisedConiferousForestBiome());
    public static final Biome WOODLANDS = add("woodlands", new WoodlandsBiome());

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
