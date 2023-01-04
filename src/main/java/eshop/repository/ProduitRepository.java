package eshop.repository;

import java.util.List;

<<<<<<< HEAD
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entity.Fournisseur;
import eshop.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> { // la clé primaire est un long

//recherche un produit par le libéllé du produit
	List<Produit> findByLibelle(String libelle);

//recherche un libellé contenant le mot désiré format Liste
	List<Produit> findByLibelleContaining(String libelle);

// recherche un libellé contentant le mot désiré.format Page
	Page<Produit> findByLibelleContaining(String libelle, Pageable pageable);

@Modifying
@Transactional
@Query("update Produit p set p.fournisseur=null where p.fournisseur=:fournisseur")
 void updtaByFournisseurSetFournisseurToNull(@Param("fournisseur")Fournisseur fournisseur);

@Query("delete Produit p where p.fournisseur=:fournisseur")
void deleteByFournisseur(@Param("fournisseur")Fournisseur fournisseur);

=======
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
>>>>>>> 0ac4b36cb0ac4a363d07d4ecde5628e3588f46af
}
