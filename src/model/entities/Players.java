package model.entities;

import java.time.LocalDate;

public class Players {

	private Integer id;
	private String name;
	private LocalDate birthDate;
	private Integer age;
	private String club;
	private NationalTeams nation;
	private Integer rating;
	private Integer goals;
	private Integer assistances;
	private Integer yellowCards;
	private Integer redCards;
	
	public Players() {
		
	}

	public Players(Integer id, String name, LocalDate birthDate, Integer age, String club, NationalTeams nation,
			Integer rating, Integer goals, Integer assistances, Integer yellowCards, Integer redCards) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.age = age;
		this.club = club;
		this.nation = nation;
		this.rating = rating;
		this.goals = goals;
		this.assistances = assistances;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public NationalTeams getNation() {
		return nation;
	}

	public void setNation(NationalTeams nation) {
		this.nation = nation;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Integer getAssistances() {
		return assistances;
	}

	public void setAssistances(Integer assistances) {
		this.assistances = assistances;
	}

	public Integer getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(Integer yellowCards) {
		this.yellowCards = yellowCards;
	}

	public Integer getRedCards() {
		return redCards;
	}

	public void setRedCards(Integer redCards) {
		this.redCards = redCards;
	}
	
	
}
