package model.dao;

import db.DB;
import model.dao.jdbc.GroupDAOjdbc;

public class DaoFactory {

	public static GroupDAO createGroupDao() {
		return new GroupDAOjdbc(DB.getConnection());
	}
}
