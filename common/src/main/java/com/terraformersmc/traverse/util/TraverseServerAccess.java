package com.terraformersmc.traverse.util;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Optional;

public class TraverseServerAccess {
	private static MinecraftServer server;
	private static final HashMap<RegistryKey<World>, ServerWorld> worlds = new HashMap<>();

	// Early capture of the server.
	public static void capture(MinecraftServer minecraftServer) {
		if (minecraftServer == null) {
			Traverse.LOGGER.warn("TraverseServerAccess.capture [early] called with null server!");
		} else {
			server = minecraftServer;
		}
	}

	// Update whenever we see a ServerWorld started.
	public static void capture(ServerWorld world, MinecraftServer minecraftServer) {
		if (minecraftServer == null) {
			Traverse.LOGGER.warn("TraverseServerAccess.capture [world] called with null server!");
		} else {
			RegistryKey<World> worldKey = world.getRegistryKey();

			server = minecraftServer;
			worlds.put(worldKey, world);
		}
	}

	/**
	 * @return Most recently created MinecraftServer regardless of whether it is running, or null.
	 */
	public static @Nullable MinecraftServer getLastServer() {
		return server;
	}

	/**
	 * @return Optional of the MinecraftServer, but only if it is running.
	 */
	public static Optional<MinecraftServer> getServer() {
		return Optional.ofNullable(server != null && (server.isRunning() || server.isStopping() || server.isSaving()) ? server : null);
	}

	/**
	 * @param worldKey The ServerWorld to fetch.
	 * @return Optional of the requested ServerWorld if it exists.
	 */
	public static Optional<ServerWorld> getServerWorld(RegistryKey<World> worldKey) {
		return Optional.ofNullable(worlds.get(worldKey));
	}
}
