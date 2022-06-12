package com.terraformersmc.traverse.mixin;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.datafixer.Schemas;
import net.minecraft.datafixer.fix.BiomeRenameFix;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiFunction;

@Mixin(Schemas.class)
public class MixinSchemas {
	@Shadow
	@Final
	private static BiFunction<Integer, Schema, Schema> EMPTY_IDENTIFIER_NORMALIZE;

	@Inject(method = "build", at = @At("TAIL"))
	private static void injectTraverseDataFixers(DataFixerBuilder builder, CallbackInfo ci) {
		Schema traverse1_18_2 = builder.addSchema(2970, EMPTY_IDENTIFIER_NORMALIZE);
		ImmutableMap<String, String> traverse1_18_2_biome_map = ImmutableMap.<String, String>builder()
				.put("traverse:autumnal_wooded_hills", "traverse:autumnal_woods")
				.put("traverse:cliffs", "minecraft:stony_peaks")
				.put("traverse:coniferous_wooded_hills", "traverse:coniferous_forest")
				.put("traverse:high_coniferous_forest", "traverse:coniferous_forest")
				.put("traverse:meadow", "traverse:flatlands")
				.put("traverse:plains_plateau", "minecraft:plains")
				.put("traverse:rocky_edge", "minecraft:plains")
				.put("traverse:snowy_cliffs", "minecraft:jagged_peaks")
				.put("traverse:snowy_coniferous_wooded_hills", "traverse:snowy_coniferous_forest")
				.put("traverse:snowy_high_coniferous_forest", "traverse:snowy_coniferous_forest")
				.put("traverse:wooded_plateau", "minecraft:forest")
				.put("traverse:wooded_island", "minecraft:forest")
				.build();
		builder.addFixer(new BiomeRenameFix(traverse1_18_2, false, "Traverse 1.18.2 remove biome variants and superseded biomes", traverse1_18_2_biome_map));
	}
}
