package model.dao;

import java.util.List;

import model.entities.Group;

public interface GroupDAO {

	Group findById(Integer id);
	List<Group> findAll();
	
}
