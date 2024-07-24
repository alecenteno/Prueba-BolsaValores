package com.alejandracenteno.prueba.entity;

import java.io.Serializable;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "state")
public class State implements Serializable{
	
	private static final long serialVersionUID = 1426212227928307139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nullable
	private int idstate;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 2)
	private String abbreviation;
	
	@Column(length = 3, name = "phoneareacode")
	private int phoneareacode;
	
	@Column(length = 3)
	private int regionID;
	
	public State() {
		
	}

	public int getIdstate() {
		return idstate;
	}

	public void setIdstate(int idstate) {
		this.idstate = idstate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public int getPhoneareacode() {
		return phoneareacode;
	}

	public void setPhoneareacode(int phoneareacode) {
		this.phoneareacode = phoneareacode;
	}


}
