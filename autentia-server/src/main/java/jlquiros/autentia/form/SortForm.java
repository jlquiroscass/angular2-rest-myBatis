package jlquiros.autentia.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SortForm {
	
	private String columnName;
	private String ascDesc;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getAscDesc() {
		return ascDesc;
	}
	public void setAscDesc(String ascDesc) {
		this.ascDesc = ascDesc;
	}
	
	@JsonCreator
	public SortForm(@JsonProperty("columnName") String columnName,
			@JsonProperty("ascDesc") String ascDesc) {

		this.columnName = columnName;
		this.ascDesc = ascDesc;
	}
	

}
