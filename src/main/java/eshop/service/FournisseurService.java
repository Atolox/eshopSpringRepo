package eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eshop.entity.Fournisseur;
import eshop.exception.FournisseurException;
import eshop.exception.IdException;
import eshop.repository.FournisseurRepository;
import eshop.repository.ProduitRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private ProduitRepository produitRepo;
	
	public void create(Fournisseur fournisseur) {
		if (fournisseur == null) { // on crée si le fournisseur n'existe pas
			throw new FournisseurException("fournisseur null");
		}
		if (fournisseur.getContact() == null || fournisseur.getContact().isEmpty()) {
			throw new FournisseurException("pas de contact");
		}
		if (fournisseur.getProduits() == null || fournisseur.getProduits().isEmpty()) {
			throw new FournisseurException("pas de produit");
		}

		fournisseurRepo.save(fournisseur);
	}

	private void checkFournisseurIsNotNull(Fournisseur fournisseur) {
		if (fournisseur == null) {
			throw new FournisseurException("fournisseur null");
		}
	}

	public Fournisseur getById(Long id) {
		if (id == null) {
			throw new IdException();
		}
		return fournisseurRepo.findById(id).orElseThrow(() -> {
			throw new FournisseurException("fournisseur inconnu");
		});
	}

	public void delete(Fournisseur fournisseur) {
		checkFournisseurIsNotNull(fournisseur);
		deleteById(fournisseur.getId());
	}

	public void delete(Long id) {
		deleteById(id);
	}

	private void deleteById(Long id) {
		Fournisseur fournisseur = getById(id);
	//	formationRepo.updateByReferentSetReferentToNull(fournisseur);
		fournisseurRepo.delete(fournisseur);
	}
	
	public List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	public Page<Fournisseur> getAll(Pageable pageable) {
		if (pageable == null) {
			throw new FournisseurException();
		}
		return fournisseurRepo.findAll(pageable);
	}

	public Page<Fournisseur> getNextPage(Page<Fournisseur> page) {
		if (page == null) {
			throw new FournisseurException();
		}
		return fournisseurRepo.findAll(page.nextOrLastPageable());
	}

	public Page<Fournisseur> getPreviousPage(Page<Fournisseur> page) {
		if (page == null) {
			throw new FournisseurException();
		}
		return fournisseurRepo.findAll(page.previousOrFirstPageable());
	}

//	public Fournisseur update(Fournisseur fournisseur) {
//		// @formatter:off
//		Fournisseur fournisseurEnBase = getById(fournisseur.getId());
//		fournisseurEnBase.setPrenom(fournisseur.getPrenom() != null ? fournisseur.getPrenom() : fournisseurEnBase.getPrenom());
//		fournisseurEnBase.setNom(fournisseur.getNom() != null ? fournisseur.getNom() : fournisseurEnBase.getNom());
//		fournisseurEnBase.setEmail(fournisseur.getEmail());
//		fournisseurEnBase.setTelephone(fournisseur.getTelephone());
//		if (fournisseur.getAdresse() != null) {
//			fournisseurEnBase.setAdresse(new Adresse(fournisseur.getAdresse().getNumero(), fournisseur.getAdresse().getRue(),
//					fournisseur.getAdresse().getCodePostal(), fournisseur.getAdresse().getVille()));
//		} else {
//			fournisseurEnBase.setAdresse(null);
//		}
//		fournisseurEnBase.setInterne(fournisseur.isInterne());
//		fournisseur.setCout(fournisseur.getCout());
//		return fournisseurRepo.save(fournisseurEnBase);
//		// @formatter:on
//	}
}

