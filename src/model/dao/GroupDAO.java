package model.dao;

import java.util.List;

import model.entities.Groups;

public interface GroupDAO {

	Groups findById(Integer id);
	List<Groups> findAll();
	
}
