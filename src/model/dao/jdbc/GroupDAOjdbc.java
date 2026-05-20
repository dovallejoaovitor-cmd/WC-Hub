package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.GroupDAO;
import model.entities.Group;

public class GroupDAOjdbc implements GroupDAO{

	private Connection conn;
	
	
	
	public GroupDAOjdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Group findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM wcgroups WHERE id = ?"
					);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Group gp = instantiateGroup(rs);
				return gp;
			}
		}catch(SQLException e){
			throw new DbException("ERROR: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Group> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM wcgroups"
					);
			
			rs = ps.executeQuery();
			
			List<Group> obj = new ArrayList<>();
			while(rs.next()) {
				Group gp = instantiateGroup(rs);
				obj.add(gp);
			}
			
			return obj;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	private Group instantiateGroup(ResultSet rs) {
		try {
			Group gp = new Group();
			gp.setId(rs.getInt("id"));
			gp.setName(rs.getString("NameGroup"));
			return gp;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}	
}
