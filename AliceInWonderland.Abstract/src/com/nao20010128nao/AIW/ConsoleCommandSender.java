package com.nao20010128nao.AIW;

public interface ConsoleCommandSender extends CommandSender {
	@Override
	public default String getName() {
		return "CONSOLE";
	}
}
