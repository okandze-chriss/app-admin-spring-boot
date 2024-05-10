package org.softwify.adminapp.dto;

import jakarta.validation.constraints.NotNull;

public class ProduitDto{
	private int ref;
	@NotNull(message = "The name must not be null")
	private String nom;
	@NotNull
	private double qtStock;
	
	public ProduitDto() {
		super();
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getQtStock() {
		return qtStock;
	}

	public void setQtStock(double qtStock) {
		this.qtStock = qtStock;
	}
	
	
}
