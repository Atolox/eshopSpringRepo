package eshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByLibelle(String libelle);

	List<Produit> findByLibelleContaining(String libelle);

	Page<Produit> findByLibelleContaining(String libelle, Pageable pageable);
	
//	@Modifying
//	@Transactional
//	@Query("update Formation f set f.referent=null where f.referent=:referent")
//	void updateByReferentSetReferentToNull(@Param("referent") Fournisseur referent);
//
//	@Modifying
//	@Transactional
//	@Query("delete Formation f where f.referent=:referent")
//	int deleteByReferent(@Param("referent") Formateur referent);
//	// on veut récupérer un référent, donc en objet ça sera Formateur referent
//}
}
