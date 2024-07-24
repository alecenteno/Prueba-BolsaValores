package com.alejandracenteno.prueba.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity(name = "placename")
@Table(name = "placename")
public class PlaceName implements Serializable{
	
	private static final long serialVersionUID = -5094274184598628437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idplacename;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 5)
	private String postalcode;
	
	@Column(name = "countyid")
	private int countyid;

	
	public int getIdplacename() {
		return idplacename;
	}

	public void setIdplacename(int idplacename) {
		this.idplacename = idplacename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public int getCountyid() {
		return countyid;
	}

	public void setCountyid(int countyid) {
		this.countyid = countyid;
	}

	
}
