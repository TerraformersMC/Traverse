package com.terraformersmc.traverse.surfacebuilder;

public class TraverseSurfaceBuilders {

	//private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

	//public static final SurfaceBuilder<TernarySurfaceConfig> ARID_HIGHLANDS = add("arid_highlands", new SandWithPatchesSurfaceBuilder(TernarySurfaceConfig.CODEC, 0.9D));
	//public static final SurfaceBuilder<TernarySurfaceConfig> DESERT_SHRUBLAND = add("desert_shrubland", new SandWithPatchesSurfaceBuilder(TernarySurfaceConfig.CODEC, 1.5D));
	//public static final SurfaceBuilder<TernarySurfaceConfig> WOODED_ISLAND = add("wooded_island", new BeachSurfaceBuilder(TernarySurfaceConfig.CODEC, 62, v -> Blocks.SAND.getDefaultState()));

	/*private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
		SURFACE_BUILDERS.put(new Identifier(Traverse.MOD_ID, name), feature);
		return feature;
	}*/

	public static void register() {
		/*for (Identifier id : SURFACE_BUILDERS.keySet()) {
			Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
		}*/
	}

}
