package com.terraformersmc.traverse.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.terraformersmc.traverse.Traverse;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TraverseConfigManager {
	private final Path biomeConfigPath;
	private final Path biomeConfigBackupPath;
	private TraverseBiomeConfig biomeConfig;

	private static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

	public TraverseConfigManager() {
		Path configDirectory = FabricLoader.getInstance().getConfigDir().resolve(Traverse.MOD_ID);

		try {
			Files.createDirectories(configDirectory);
		} catch (IOException e) {
			Traverse.LOGGER.error("Failed to create config directory at " + configDirectory, e);
		}

		biomeConfigPath = configDirectory.resolve("biome.json");
		biomeConfigBackupPath = configDirectory.resolve("biome-invalid-syntax.json");
	}

	private static <T> T loadConfig(Path configPath, T defaults, Class<T> clazz, Path backupPath) {
		if (!Files.exists(configPath)) {
			if (!saveConfig(configPath, defaults)) {
				Traverse.LOGGER.error("Unable to save default configuration values for " + configPath);

				// Not much else to do at this point.
				return defaults;
			}
		}

		String content;

		try {
			// Load the entire file first, so that we don't get any weird IO errors halfway through.
			content = Files.readString(configPath);
		} catch (IOException e) {
			Traverse.LOGGER.error("Failed to load Traverse configuration file at " + configPath, e);
			Traverse.LOGGER.error("This shouldn't happen under normal conditions, ensure that you have the correct permissions");
			Traverse.LOGGER.error("Reverting to default configuration");

			return defaults;
		}

		try {
			return GSON.fromJson(content, clazz);
		} catch (JsonSyntaxException e) {
			Traverse.LOGGER.error("Failed to parse Traverse configuration file at " + configPath, e);

			// Revert the config so that the user has a fresh start if they need it.
			// It's also possible for the user to delete the config to recreate it, but that seems a bit unintuitive.
			Traverse.LOGGER.error("Reverting to default configuration, ensure that your file has correct syntax");
			saveConfig(configPath, defaults);

			// There are a few websites like this, but this was the first result that came up.
			Traverse.LOGGER.error("In the future, consider using something like https://jsonchecker.com/ to check your syntax");

			// It would be quite annoying if a user just spent 10 minutes editing the file, only for it to be wiped away.
			// Save a backup so they can review the errors and fix them.
			Traverse.LOGGER.error("The previous configuration file content has been written to " + backupPath);

			try {
				Files.writeString(backupPath, content);
			} catch (IOException ioe) {
				Traverse.LOGGER.error("Couldn't save previous configuration file content at " + backupPath, ioe);
				Traverse.LOGGER.error("This shouldn't happen under normal conditions, ensure that you have the correct permissions and that your disk isn't full!");
			}

			return defaults;
		}
	}

	private static <T> boolean saveConfig(Path configPath, T instance) {
		String jsonString = GSON.toJson(instance);

		try {
			Files.writeString(configPath, jsonString);

			return true;
		} catch (IOException e) {
			Traverse.LOGGER.error("Couldn't save Traverse configuration file at " + configPath, e);
			Traverse.LOGGER.error("This shouldn't happen under normal conditions, ensure that you have the correct permissions and that your disk isn't full!");

			return false;
		}
	}

	public TraverseBiomeConfig getBiomeConfig() {
		if (biomeConfig == null) {
			biomeConfig = loadConfig(biomeConfigPath, new TraverseBiomeConfig(), TraverseBiomeConfig.class, biomeConfigBackupPath);
		}

		return biomeConfig;
	}
}
