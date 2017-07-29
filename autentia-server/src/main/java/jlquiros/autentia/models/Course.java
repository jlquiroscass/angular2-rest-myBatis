package jlquiros.autentia.models;

public class Course {
	
	private Integer id;
	private String name;
	private String active;
	private Integer numHours;
	private String level;
	private Professor professor;
	
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getNumHours() {
		return numHours;
	}
	public void setNumHours(Integer numHours) {
		this.numHours = numHours;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Integer getProfessorId()
	{
		return this.professor.getId();
	}
	
	
	
	
	
	

}
