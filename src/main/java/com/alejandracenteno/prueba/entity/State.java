package com.alejandracenteno.prueba.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "state")
public class State implements Serializable{
	
	private static final long serialVersionUID = 1426212227928307139L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idstate;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 2)
	private String abbreviation;
	
	@Column(length = 3)
	private int phoneAreaCode;
	
	@ManyToOne
	@JoinColumn(name="regionID")
	private Region region;
	
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

	public int getPhoneAreaCode() {
		return phoneAreaCode;
	}

	public void setPhoneAreaCode(int phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
	}


	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


}
