package org.softwify.adminapp.dto;


import jakarta.validation.constraints.NotNull;

public class AppRolesDto{
	private int id;
	@NotNull(message = "The name must not be null")
	private String nom;
	
	public AppRolesDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
