package jlquiros.autentia.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseForm {
	
	private Integer id;
	private String name;
	private String active;
	private Integer numHours;
	private String level;
	private Integer professor_id;
	
	
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

	public Integer getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(Integer professor_id) {
		this.professor_id = professor_id;
	}
	
	public CourseForm(Integer id, String name, String active, Integer numHours, String level, Integer professor_id) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.numHours = numHours;
		this.level = level;
		this.professor_id = professor_id;
	}
	
	@JsonCreator
	public CourseForm(@JsonProperty("id") Integer id,
			@JsonProperty("name") String name,
			@JsonProperty("numHours") Integer numHours,
			@JsonProperty("level") String level,
			@JsonProperty("professor_id") Integer professor_id,
			@JsonProperty("active") String active) {

		this.id = id;
		this.name = name;
		this.numHours = numHours;
		this.level = level;
		this.professor_id = professor_id;
		this.active = active.equals("true")?"A":"I";
	}
	
	
	

}
