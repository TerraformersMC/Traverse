package com.terraformersmc.traverse.mixin;

import com.terraformersmc.traverse.fix.BiomeIdFixData;
import net.fabricmc.fabric.impl.registry.sync.RegistryMapSerializer;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.level.storage.LevelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

@Mixin(LevelStorage.Session.class)
public class MixinLevelStorageSession {
	@Shadow
	@Final
	private LevelStorage.LevelSave directory;

	@Unique
	private static final Logger TRAVERSE_LOGGER = LoggerFactory.getLogger("TraverseRegistrySyncFix");

	@Unique
	private boolean traverse_readIdMapFile(File file) throws IOException {
		TRAVERSE_LOGGER.debug("Reading registry data from " + file.toString());

		if (file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			NbtCompound nbt = NbtIo.readCompressed(fileInputStream);
			fileInputStream.close();

			if (nbt != null) {
				BiomeIdFixData.applyFabricDynamicRegistryMap(RegistryMapSerializer.fromNbt(nbt));
				return true;
			}
		}

		return false;
	}

	@Inject(method = "readLevelProperties", at = @At("HEAD"))
	public void readWorldProperties(CallbackInfoReturnable<SaveProperties> callbackInfo) {
		try {
			if (traverse_readIdMapFile(new File(new File(directory.path().toFile(), "data"), "fabricDynamicRegistry.dat"))) {
				TRAVERSE_LOGGER.info("[Traverse - Registry Sync Fix] Loaded registry data");
			}
		} catch (FileNotFoundException e) {
			// Pass
		} catch (IOException e) {
			TRAVERSE_LOGGER.warn("Reading registry file failed!", e);
		}
	}
}
