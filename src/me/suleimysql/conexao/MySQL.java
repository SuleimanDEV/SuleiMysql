package me.suleimysql.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class MySQL {

	public static Connection con = null;

	public static String prefix = "§6§lSL§f§lPLUGINS » ";
	
	public static void open() {

		String url = "jdbc:mysql://localhost/redewish";
		String user = "root";
		String pass = "pass";

		try {
			con = DriverManager.getConnection(url, user, pass);
			Bukkit.getConsoleSender().sendMessage("§6§lSL§f§lPLUGINS » §aConexao com MySQL Sucedida.");
			createTable();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§6§lSL§f§lPLUGINS » §CConexao com MySQL Nao foi Sucedida.");
		}
	}

	public static void createTable() {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"create table if not exists players(UUID varchar(64), Money DOUBLE, Rank TEXT, Cargo TEXT, Limite DOUBLE)");
			stm.executeUpdate();
			Bukkit.getConsoleSender().sendMessage("§6§lSL§f§lPLUGINS » §aTabela criada com sucesso. (MySQL)");
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§6§lSL§f§lPLUGINS » §cNao foi possivel criar a tabela. (MySQL)");
		}
	}
}
