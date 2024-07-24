package com.alejandracenteno.prueba.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "county")
public class County implements Serializable{

	private static final long serialVersionUID = 4991955791092621182L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcounty;
	
	@Column(length = 100)
	private String name;
	
	
	@Column(name="stateID")
	private int state;

	public int getIdcounty() {
		return idcounty;
	}

	public void setIdcounty(int idcounty) {
		this.idcounty = idcounty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		
}
