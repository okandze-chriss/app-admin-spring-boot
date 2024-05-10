package org.softwify.adminapp.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.softwify.adminapp.repository.IProduitRepository;
import org.softwify.adminapp.dto.ProduitDto;
import org.softwify.adminapp.exception.EntityNotFoundException;
import org.softwify.adminapp.exception.RequestException;
import org.softwify.adminapp.mapping.ProduitMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProduitService {
	private final IProduitRepository iProduitRepository;
	private final ProduitMapper produitMapper;
	MessageSource messageSource;
	
	
	public ProduitService(IProduitRepository iProduitRepository, ProduitMapper produitMapper,
			MessageSource messageSource) {
		super();
		this.iProduitRepository = iProduitRepository;
		this.produitMapper = produitMapper;
		this.messageSource = messageSource;
	}
	
	
	@Transactional(readOnly = true)
	public List<ProduitDto> getProduits(){
		return StreamSupport.stream(iProduitRepository.findAll().spliterator(), false)
				.map(produitMapper::toProduit)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ProduitDto getProduit(int id){
		return produitMapper.toProduit(iProduitRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("produit.notfound", new Object[] {id}, Locale.getDefault()))));
	}
	
	@Transactional
	public ProduitDto createProduit(ProduitDto produit){
		return produitMapper.toProduit(iProduitRepository.save(produitMapper.fromProduit(produit)));
	}
	
	
	@Transactional
	public ProduitDto updateProduit(int id, ProduitDto produit){
		return iProduitRepository.findById(id)
				.map(entity -> {
					produit.setRef(id);
					return produitMapper.toProduit(iProduitRepository.save(produitMapper.fromProduit(produit)));
				}).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("produit.notfound", new Object[]{id}, Locale.getDefault())));
	}
	
	@Transactional
	public void deleteProduit(int id){
		try {
			iProduitRepository.deleteById(id);
		} catch (Exception e) {
			throw new RequestException(messageSource.getMessage("produit.errordeletion", new Object[] {id}, Locale.getDefault()), HttpStatus.CONFLICT);
		}
	}
	
}
