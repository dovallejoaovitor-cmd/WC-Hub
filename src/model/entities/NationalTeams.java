package model.entities;

public class NationalTeams {

	private Integer id;
	private String name;
	private Groups group;
	
	public NationalTeams() {
		
	}

	public NationalTeams(Integer id, String name, Groups group) {
		this.id = id;
		this.name = name;
		this.group = group;
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

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}
	
	
	
}
