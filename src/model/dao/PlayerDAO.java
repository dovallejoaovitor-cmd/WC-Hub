package model.dao;

import java.util.List;

import model.entities.NationalTeam;
import model.entities.Player;

public interface PlayerDAO {

	List<Player> findByNationalTeam(NationalTeam obj);
	Player findById(Integer id);
	List<Player> findAll();
}
