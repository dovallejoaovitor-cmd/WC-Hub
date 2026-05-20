package model.dao;

import java.util.List;

import model.entities.Group;
import model.entities.NationalTeam;

public interface NationalTeamDAO {

	List<NationalTeam> findByGroup(Group obj);
	NationalTeam findById(Integer id);
	List<NationalTeam> findAll();
}
