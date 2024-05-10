package org.softwify.adminapp.mapping;

import org.mapstruct.Mapper;
import org.softwify.adminapp.dto.ProduitDto;
import org.softwify.adminapp.entities.ProduitEntity;

@Mapper
public interface ProduitMapper {
	ProduitDto toProduit(ProduitEntity produitEntity);
	ProduitEntity fromProduit(ProduitDto produitDto);

}
