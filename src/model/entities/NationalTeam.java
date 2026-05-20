package model.entities;

public class NationalTeam {

	private Integer id;
	private String name;
	private Group group;
	private String flagPath;
	
	public NationalTeam() {
		
	}

	public NationalTeam(Integer id, String name, Group group, String flagPath) {
		this.id = id;
		this.name = name;
		this.group = group;
		this.flagPath = flagPath;
		
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getFlagPath() {
		return flagPath;
	}

	public void setFlagPath(String flagPath) {
		this.flagPath = flagPath;
	}
	
	
	
}
