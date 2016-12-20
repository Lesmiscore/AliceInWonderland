package com.nao20010128nao.AIW;

import java.util.Collection;
import java.util.Set;

public interface Server {
	public Collection<? extends Player> getOnlinePlayers();

	public OfflinePlayer[] getOfflinePlayers();

	public void banIP(String ip);

	public void ban(String name);

	public boolean dispatchCommand(CommandSender sender, String commandLine);

	public Set<OfflinePlayer> getBannedPlayers();

	public Set<String> getIPBans();

	public int getMaxPlayers();

	public String getName();

	public String getMotd();

	public OfflinePlayer getOfflinePlayer(String name);

	public int getPort();

	public int getViewDistance();

	public World getWorld(String name);

	public boolean hasWhitelist();
}
