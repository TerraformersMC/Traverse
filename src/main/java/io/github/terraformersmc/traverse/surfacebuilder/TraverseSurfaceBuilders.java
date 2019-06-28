package io.github.terraformersmc.traverse.surfacebuilder;

import io.github.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.HashMap;
import java.util.Map;

public class TraverseSurfaceBuilders {

    private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> SAND_WITH_PATCHES = add("sand_with_patches", new SandWithPatchesSurfaceBuilder(TernarySurfaceConfig::deserialize));

    public static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
        SURFACE_BUILDERS.put(new Identifier(Traverse.MOD_ID, name), feature);
        return feature;
    }

    public static void register() {
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }

}
