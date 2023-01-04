package eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entity.Produit;
import eshop.exception.ProduitException;
import eshop.repository.ProduitRepository;
import exoFormation.entity.Formateur;
import exoFormation.exception.FormateurException;
import exoFormation.exception.IdException;


@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository produitRepo;

	//creation d'un produit
	public void create(Produit produit) {
		checkProduitIsNotNull(produit);
		if(produit==null) {
			throw new ProduitException("produit null");
		}
		if (produit.getLibelle()==null || produit.getLibelle().isEmpty()) {
			throw new ProduitException("libelle vide");
		}
		
	}
	
	public void checkProduitIsNotNull(Produit produit) {
		if (produit==null) {
			throw new ProduitException("produit null");
		}
	}
	
	public Produit getByNom(Long libelle) {
		if (libelle==null) {
			throw new IdException();
		}
		return produitRepo.findByNom(libelle).orElseThrow(() -> {
				throw new FormateurException("formateur inconnu");
			});
		}


}
