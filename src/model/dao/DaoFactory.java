package model.dao;

import db.DB;
import model.dao.jdbc.GroupDAOjdbc;
import model.dao.jdbc.NationalTeamDAOjdbc;

public class DaoFactory {

	public static GroupDAO createGroupDao() {
		return new GroupDAOjdbc(DB.getConnection());
	}
	
	public static NationalTeamDAO createNationalTeamDao() {
		return new NationalTeamDAOjdbc(DB.getConnection());
	}
}
