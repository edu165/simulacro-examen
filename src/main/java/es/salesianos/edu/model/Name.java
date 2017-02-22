package es.salesianos.edu.model;

import java.util.Date;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import java.io.Serializable;

public class Name implements Serializable{
	private int idName;
	public int getIdName() {
		return idName;
	}
	public void setIdName(int idName) {
		this.idName = idName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSubname() {
		return Subname;
	}
	public void setSubname(String subname) {
		Subname = subname;
	}
	public Integer getYearBorn() {
		return YearBorn;
	}
	public void setYearBorn(Integer yearBorn) {
		YearBorn = yearBorn;
	}
	private String Name;
	private String Subname;
	private Integer YearBorn;
	

}
