package me.suleimysql;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.suleimysql.conexao.MySQL;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		MySQL.open();
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
}
