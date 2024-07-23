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
@Table(name = "county")
public class County implements Serializable{

	private static final long serialVersionUID = 4991955791092621182L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idcounty;
	
	@Column(length = 100)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="stateID")
	private State state;
	
	@OneToMany(mappedBy = "county")
	private List<PlaceName> placenames;
	
	public County() {
		
	}

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<PlaceName> getPlacenames() {
		return placenames;
	}

	public void setPlacenames(List<PlaceName> placenames) {
		this.placenames = placenames;
	}

	public PlaceName addPlacename(PlaceName placename) {
		getPlacenames().add(placename);
		placename.setCounty(this);

		return placename;
	}

	public PlaceName removePlacename(PlaceName placename) {
		getPlacenames().remove(placename);
		placename.setCounty(null);

		return placename;
	}
	
}
