package model.dao;

import java.util.List;

import model.entities.NationalTeams;
import model.entities.Players;

public interface PlayersDAO {

	List<Players> findByNationalTeam(NationalTeams obj);
	Players findById(Integer id);
	List<Players> findAll();
}
