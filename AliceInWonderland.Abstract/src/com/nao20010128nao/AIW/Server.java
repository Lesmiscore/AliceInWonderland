package com.nao20010128nao.AIW;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.stream.Location;

public interface Server {
	/**
	 * Gets a view of all currently logged in players. This {@linkplain
	 * Collections#unmodifiableCollection(Collection) view} is a reused
	 * object, making some operations like {@link Collection#size()}
	 * zero-allocation.
	 * <p>
	 * The collection is a view backed by the internal representation, such
	 * that, changes to the internal state of the server will be reflected
	 * immediately. However, the reuse of the returned collection (identity)
	 * is not strictly guaranteed for future or all implementations. Casting
	 * the collection, or relying on interface implementations (like {@link
	 * Serializable} or {@link List}), is deprecated.
	 * <p>
	 * Iteration behavior is undefined outside of self-contained main-thread
	 * uses. Normal and immediate iterator use without consequences that
	 * affect the collection are fully supported. The effects following
	 * (non-exhaustive) {@link Entity#teleport(Location) teleportation},
	 * {@link Player#setHealth(double) death}, and {@link Player#kickPlayer(
	 * String) kicking} are undefined. Any use of this collection from
	 * asynchronous threads is unsafe.
	 * <p>
	 * For safe consequential iteration or mimicking the old array behavior,
	 * using {@link Collection#toArray(Object[])} is recommended. For making
	 * snapshots, {@link ImmutableList#copyOf(Collection)} is recommended.
	 *
	 * @return a view of currently online players.
	 */
	public Collection<? extends Player> getOnlinePlayers();

	/**
	 * Bans the specified address from the server.
	 *
	 * @param address
	 *            the IP address to ban
	 */
	public void banIP(String ip);

	/**
	 * Gets a set containing all banned players.
	 *
	 * @return a set containing banned players
	 */
	public Set<OfflinePlayer> getBannedPlayers();

	/**
	 * Gets a set containing all current IPs that are banned.
	 *
	 * @return a set containing banned IP addresses
	 */
	public Set<String> getIPBans();

	/**
	 * Gets the player by the given name, regardless if they are offline or
	 * online.
	 * <p>
	 * This method may involve a blocking web request to get the UUID for the
	 * given name.
	 * <p>
	 * This will return an object even if the player does not exist. To this
	 * method, all players will exist.
	 *
	 * @param name
	 *            the name the player to retrieve
	 * @return an offline player
	 * @see #getOfflinePlayer(java.util.UUID)
	 */
	public OfflinePlayer getOfflinePlayer(String name);

	/**
	 * Gets whether this server has a whitelist or not.
	 *
	 * @return whether this server has a whitelist or not
	 */
	public boolean hasWhitelist();

	/**
	 * Gets a list of whitelisted players.
	 *
	 * @return a set containing all whitelisted players
	 */
	public Set<OfflinePlayer> getWhitelistedPlayers();

	/**
	 * Reloads the whitelist from disk.
	 */
	public void reloadWhitelist();

	/**
	 * Sets if the server is whitelisted.
	 *
	 * @param value
	 *            true for whitelist on, false for off
	 */
	public void setWhitelist(boolean value);

	/**
	 * Unbans the specified address from the server.
	 *
	 * @param address
	 *            the IP address to unban
	 */
	public void unbanIP(String address);

	/**
	 * Get world type (level-type setting) for default world.
	 *
	 * @return the value of level-type (e.g. DEFAULT, FLAT, DEFAULT_1_1)
	 */
	public String getWorldType();

	/**
	 * Broadcast a message to all players.
	 * <p>
	 * This is the same as calling {@link #broadcast(java.lang.String,
	 * java.lang.String)} to {@link #BROADCAST_CHANNEL_USERS}
	 *
	 * @param message
	 *            the message
	 * @return the number of players
	 */
	public int broadcastMessage(String message);

	/**
	 * Gets a player object by the given username.
	 * <p>
	 * This method may not return objects for offline players.
	 *
	 * @param name
	 *            the name to look up
	 * @return a player if one was found, null otherwise
	 */
	public Player getPlayer(String name);

	/**
	 * Gets the player with the exact given name, case insensitive.
	 *
	 * @param name
	 *            Exact name of the player to retrieve
	 * @return a player object if one was found, null otherwise
	 */
	public Player getPlayerExact(String name);

	/**
	 * Gets a set containing all player operators.
	 *
	 * @return a set containing player operators
	 */
	public Set<OfflinePlayer> getOperators();

	/**
	 * Gets the default {@link GameMode} for new players.
	 *
	 * @return the default game mode
	 */
	public GameMode getDefaultGameMode();

	/**
	 * Sets the default {@link GameMode} for new players.
	 *
	 * @param mode
	 *            the new game mode
	 */
	public void setDefaultGameMode(GameMode mode);

	/**
	 * Gets a {@link ConsoleCommandSender} that may be used as an input source
	 * for this server.
	 *
	 * @return a console command sender
	 */
	public ConsoleCommandSender getConsoleSender();

	/**
	 * Gets the name of this server implementation.
	 *
	 * @return name of this server implementation
	 */
	public String getName();

	/**
	 * Gets the version string of this server implementation.
	 *
	 * @return version of this server implementation
	 */
	public String getVersion();

	/**
	 * Get the maximum amount of players which can login to this server.
	 *
	 * @return the amount of players this server allows
	 */
	public int getMaxPlayers();

	/**
	 * Get the game port that the server runs on.
	 *
	 * @return the port number of this server
	 */
	public int getPort();

	/**
	 * Get the view distance from this server.
	 *
	 * @return the view distance from this server.
	 */
	public int getViewDistance();

	/**
	 * Get the IP that this server is bound to, or empty string if not
	 * specified.
	 *
	 * @return the IP string that this server is bound to, otherwise empty
	 *         string
	 */
	public String getIp();

	/**
	 * Get the name of this server.
	 *
	 * @return the name of this server
	 */
	public String getServerName();

	/**
	 * Get generate-structures setting.
	 *
	 * @return true if structure generation is enabled, false otherwise
	 */
	public boolean getGenerateStructures();

	/**
	 * Gets a list of all worlds on this server.
	 *
	 * @return a list of worlds
	 */
	public List<World> getWorlds();

	/**
	 * Gets the world with the given name.
	 *
	 * @param name
	 *            the name of the world to retrieve
	 * @return a world with the given name, or null if none exists
	 */
	public World getWorld(String name);

	/**
	 * Reloads the server, refreshing settings and plugin information.
	 */
	public void reload();

	/**
	 * Returns the primary logger associated with this server instance.
	 *
	 * @return Logger associated with this server
	 */
	public Logger getLogger();

	/**
	 * Writes loaded players to disk.
	 */
	public void savePlayers();

	/**
	 * Dispatches a command on this server, and executes it if found.
	 *
	 * @param sender
	 *            the apparent sender of the command
	 * @param commandLine
	 *            the command + arguments. Example: <code>test abc
	 *     123</code>
	 * @return returns false if no target is found
	 * @throws CommandException
	 *             thrown when the executor for the given command
	 *             fails with an unhandled exception
	 */
	public boolean dispatchCommand(CommandSender sender, String commandLine);

	/**
	 * Gets the radius, in blocks, around each worlds spawn point to protect.
	 *
	 * @return spawn radius, or 0 if none
	 */
	public int getSpawnRadius();

	/**
	 * Sets the radius, in blocks, around each worlds spawn point to protect.
	 *
	 * @param value
	 *            new spawn radius, or 0 if none
	 */
	public void setSpawnRadius(int value);

	/**
	 * Gets whether the Server is in online mode or not.<br>
	 * In Minecraft:PE servers, this should be Xbox account authencation.
	 *
	 * @return true if the server authenticates clients, false otherwise
	 */
	public boolean getOnlineMode();

	/**
	 * Gets whether this server allows flying or not.
	 *
	 * @return true if the server allows flight, false otherwise
	 */
	public boolean getAllowFlight();

	/**
	 * Gets whether the server is in hardcore mode or not.
	 *
	 * @return true if the server mode is hardcore, false otherwise
	 */
	public boolean isHardcore();

	/**
	 * Shutdowns the server, stopping everything.
	 */
	public void shutdown();

	/**
	 * Broadcasts the specified message to every user with the given
	 * permission name.
	 *
	 * @param message
	 *            message to broadcast
	 * @param permission
	 *            the required permission {@link Permissible
	 *            permissibles} must have to receive the broadcast
	 * @return number of message recipients
	 */
	public int broadcast(String message, String permission);

	/**
	 * Gets the instance of the scoreboard manager.
	 * <p>
	 * This will only exist after the first world has loaded.
	 *
	 * @return the scoreboard manager or null if no worlds are loaded or
	 *         unsupported on this server.
	 */
	public ScoreboardManager getScoreboardManager();

	/**
	 * Set the idle kick timeout. Any players idle for the specified amount of
	 * time will be automatically kicked.
	 * <p>
	 * A value of 0 will disable the idle kick timeout.
	 *
	 * @param threshold
	 *            the idle timeout in minutes
	 */
	public void setIdleTimeout(int threshold);

	/**
	 * Gets the idle kick timeout.
	 *
	 * @return the idle timeout in minutes
	 */
	public int getIdleTimeout();

	// default methods

	/**
	 * Gets whether this server has a whitelist or not.
	 * (Equals as {@code #hasWhitelist()})
	 *
	 * @return whether this server has a whitelist or not
	 */
	public default boolean getWhitelist() {
		return hasWhitelist();
	}
}
