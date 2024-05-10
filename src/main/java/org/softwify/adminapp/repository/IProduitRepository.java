package org.softwify.adminapp.repository;

import org.softwify.adminapp.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitRepository extends JpaRepository<ProduitEntity, Integer> {

}
