package model.dao;

import java.util.List;

import model.entities.Groups;
import model.entities.NationalTeams;

public interface NationalTeamsDAO {

	List<NationalTeams> findByGroup(Groups obj);
	NationalTeams findById(Integer id);
	List<NationalTeams> findAll();
}
