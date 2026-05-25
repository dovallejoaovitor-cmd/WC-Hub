package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.PlayerDAO;
import model.entities.NationalTeam;
import model.entities.Player;

public class PlayerDAOjdbc implements PlayerDAO{
	
	private Connection conn;
	
	

	public PlayerDAOjdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Player> findByNationalTeam(NationalTeam obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM player " +
					"JOIN national_teams ON " +
					"player.PlayerNationId = national_teams.id " +
					"WHERE national_teams.id = ?;"
					);
			ps.setInt(1, obj.getId());
			rs = ps.executeQuery();
			List<Player> pl = new ArrayList<>();
			while(rs.next()) {
				NationalTeam nt = instantiateNationalTeam(rs);
				Player player = instantiatePlayer(rs, nt);
				pl.add(player);
			}
			return pl;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Player findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM player " +
					"WHERE player.id = ?"
					);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				NationalTeam nt = instantiateNationalTeam(rs);
				Player player = instantiatePlayer(rs, nt);
				return player;
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Player> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM player"
					);
			rs = ps.executeQuery();
			List<Player> pl = new ArrayList<>();
			while(rs.next()) {
				NationalTeam nt = instantiateNationalTeam(rs);
				Player player = instantiatePlayer(rs, nt);
				pl.add(player);
			}
			return pl;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public NationalTeam instantiateNationalTeam(ResultSet rs) {
		try {
			NationalTeam nt = new NationalTeam();
			nt.setId(rs.getInt("id"));
			nt.setName("NameNationalTeam");
			return nt;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public Player instantiatePlayer(ResultSet rs, NationalTeam nt) {
		try {
			Player player = new Player();
			player.setId(rs.getInt("id"));
			player.setName(rs.getString("PlayerName"));
			player.setBirthDate(rs.getDate("birthDate").toLocalDate());
			player.setAge(rs.getInt("PlayerAge"));
			player.setPosition(rs.getString("PlayerPosition"));
			player.setClub(rs.getString("PlayerClub"));
			player.setNation(nt);
			player.setRating(rs.getInt("PlayerRating"));
			player.setGoals(rs.getInt("PlayerGoals"));
			player.setAssistances(rs.getInt("PlayerAssistances"));
			player.setYellowCards(rs.getInt("PlayerYellowCards"));
			player.setRedCards(rs.getInt("PlayerRedCards"));
			return player;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
