package org.softwify.adminapp.dto;

import jakarta.validation.constraints.NotNull;
public class AppUserDto{
	private int id;
	@NotNull(message = "The lastname must not be null")
	private String nom;
	@NotNull(message = "The firstname must not be null")
	private String prenom;
	@NotNull(message = "The email must not be null")
	private String email;
	@NotNull(message = "The password must not be null")
	private String password;
	@NotNull
	private int etat;
	public AppUserDto() {
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	

}
