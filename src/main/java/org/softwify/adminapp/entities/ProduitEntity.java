package org.softwify.adminapp.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity implements Serializable{
	@Serial
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ref;
	@Column(nullable = false, length = 200)
	private String nom;
	@Column
	private double qtStock;
	@ManyToOne
	@JoinColumn(name="idUser")
	private AppUserEntity user;
}
