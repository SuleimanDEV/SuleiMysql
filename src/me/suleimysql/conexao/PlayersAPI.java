package me.suleimysql.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class PlayersAPI extends MySQL {

	public static boolean contains(Player p) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("select * from players where UUID = '" + p.getUniqueId().toString() + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public static void addPlayer(Player p, double money, double limite, String cargo, String rank) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("insert into players(UUID, Money, Limite, Cargo, Rank) values (?,?,?,?,?)");
			stm.setString(1, p.getUniqueId().toString());
			stm.setDouble(2, money);
			stm.setDouble(3, limite);
			stm.setString(4, cargo);
			stm.setString(5, rank);
			stm.executeUpdate();
			Bukkit.getConsoleSender().sendMessage(prefix + "§aJogador §c" + p.getName() + " §aadicionado ao MySQL.");
		} catch (SQLException e) {
			Bukkit.getConsoleSender()
					.sendMessage(prefix + "§cNao foi possivel adicionar o jogador §f" + p.getName() + " §cno MySQL.");
		}
	}

	public static double getMoney(Player p) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("select * from players where UUID = '" + p.getUniqueId().toString() + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return rs.getDouble("Money");
			}
			return 0.0;
		} catch (SQLException e) {
			return 0.0;
		}
	}

	public static double getLimite(Player p) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("select * from players where UUID = '" + p.getUniqueId().toString() + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return rs.getDouble("Limite");
			}
			return 0.0;
		} catch (SQLException e) {
			return 0.0;
		}
	}

	public static String getRank(Player p) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("select * from players where UUID = '" + p.getUniqueId().toString() + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return rs.getString("Rank");
			}
			return "Membro";
		} catch (SQLException e) {
			return "Membro";
		}
	}

	public static String getCargo(Player p) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("select * from players where UUID = '" + p.getUniqueId().toString() + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return rs.getString("Cargo");
			}
			return "Membro";
		} catch (SQLException e) {
			return "Membro";
		}
	}

	public static void addLimite(Player p, double limite) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"update players set Limite = '" + getLimite(p) + limite + "' where UUID = '" + p.getUniqueId().toString() + "'");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addMoney(Player p, double money) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"update players set Money = '" + getMoney(p) + money + "' where UUID = '" + p.getUniqueId().toString() + "'");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setRank(Player p, String rank) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"update players set Rank = '" + rank + "' where UUID = '" + p.getUniqueId().toString() + "'");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setCargo(Player p, String cargo) {
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"update players set Cargo = '" + cargo + "' where UUID = '" + p.getUniqueId().toString() + "'");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
