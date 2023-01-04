package eshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entity.Fournisseur;


public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

	List<Fournisseur> findByNom(String nom);
	List<Fournisseur> findByNomContaining(String nom);
	Page<Fournisseur> findByNomContaining(String nom, Pageable pageable);
	List<Fournisseur> findByEmail(String email);
	List<Fournisseur> findByContact(String contact);
	List<Fournisseur> findByContactContaining(String contact);
	Page<Fournisseur> findByContactContaining(String contact, Pageable pageable);
	
	@Query("select f from Fournisseur f left join fetch f.produits where f.id =:id")
	Optional<Fournisseur> findByKeyFetchProduits(@Param("id") Long id);
}
