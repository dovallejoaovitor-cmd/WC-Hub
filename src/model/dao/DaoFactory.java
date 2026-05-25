package model.dao;

import db.DB;
import model.dao.jdbc.GroupDAOjdbc;
import model.dao.jdbc.NationalTeamDAOjdbc;
import model.dao.jdbc.PlayerDAOjdbc;

public class DaoFactory {

	public static GroupDAO createGroupDao() {
		return new GroupDAOjdbc(DB.getConnection());
	}
	
	public static NationalTeamDAO createNationalTeamDao() {
		return new NationalTeamDAOjdbc(DB.getConnection());
	}
	
	public static PlayerDAO createPlayerDao() {
		return new PlayerDAOjdbc(DB.getConnection());
	}
}
