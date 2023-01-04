package eshop.repository;

import java.util.List;

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

}
