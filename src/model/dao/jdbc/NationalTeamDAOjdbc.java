package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.NationalTeamDAO;
import model.entities.Group;
import model.entities.NationalTeam;

public class NationalTeamDAOjdbc implements NationalTeamDAO{

	private Connection conn;
	
	
	
	public NationalTeamDAOjdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<NationalTeam> findByGroup(Group obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT national_teams.*, wcgroups.id AS GroupId, wcgroups.NameGroup AS GroupName " +
					"FROM national_teams JOIN wcgroups ON " +
					"wcgroups.id = national_teams.GroupId " +
					"WHERE wcgroups.id = ?"
					);
			
			ps.setInt(1, obj.getId());
			rs = ps.executeQuery();
			
			List<NationalTeam> nt = new ArrayList<>();
			while(rs.next()) {
				Group gp = instantiateGroup(rs);
				NationalTeam team = instantiateNationalTeam(rs, gp);
				nt.add(team);
			}
			return nt;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	}

	@Override
	public NationalTeam findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT national_teams.*, wcgroups.id AS GroupId, wcgroups.NameGroup AS GroupName " +
					"FROM national_teams JOIN wcgroups ON " +
					"wcgroups.id = national_teams.GroupId " +
					"WHERE national_teams.id = ?"
					);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Group gp = instantiateGroup(rs);
				NationalTeam nt = instantiateNationalTeam(rs, gp);
				return nt;
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<NationalTeam> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT national_teams.*, wcgroups.id AS GroupsId, wcgroups.NameGroup AS GroupName " +
					"FROM national_teams JOIN wcgroups ON " +
					" wcgroups.id = national_teams.GroupId " 
					);
			
			rs = ps.executeQuery();
			
			List<NationalTeam> list = new ArrayList<>();
			while(rs.next()) {
				Group gp = instantiateGroup(rs);
				NationalTeam nt = instantiateNationalTeam(rs, gp);
				
				list.add(nt);
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	
	}
	
	public NationalTeam instantiateNationalTeam(ResultSet rs, Group gp) {
		try {
			NationalTeam obj = new NationalTeam();
			obj.setId(rs.getInt("id"));
			obj.setName(rs.getString("NameNationalTeam"));
			obj.setGroup(gp);
			return obj;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	private Group instantiateGroup(ResultSet rs) {
		try {
			Group gp = new Group();
			gp.setId(rs.getInt("GroupId"));
			gp.setName(rs.getString("GroupName"));
			return gp;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}	

}
