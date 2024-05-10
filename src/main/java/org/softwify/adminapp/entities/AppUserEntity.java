package org.softwify.adminapp.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserEntity implements Serializable{
	@Serial
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 150)
	private String nom;
	@Column(nullable = false, length = 200)
	private String prenom;
	@Column(nullable = false, length = 200)
	private String email;
	@Column(nullable = false, length = 200)
	private String password;
	@Column
	private int etat;
	@ManyToMany
	@JoinTable(name = "Roles_Users")
	private List<AppRolesEntity> appRoles;
	@OneToMany(targetEntity = ProduitEntity.class, mappedBy = "user")
	private List<ProduitEntity> produits = new ArrayList<>();

}
