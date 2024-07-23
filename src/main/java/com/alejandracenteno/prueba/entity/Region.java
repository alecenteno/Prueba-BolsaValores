package com.alejandracenteno.prueba.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "region")
public class Region implements Serializable {
	
	private static final long serialVersionUID = -4451448190227496606L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idregion;
	
	@Column(length = 100)
	private String name;
	

	public Region() {
		
	}

	public int getIdregion() {
		return idregion;
	}

	public void setIdregion(int idregion) {
		this.idregion = idregion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
