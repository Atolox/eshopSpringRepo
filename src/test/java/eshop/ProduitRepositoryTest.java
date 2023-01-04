package eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entity.Produit;
import eshop.repository.ProduitRepository;


@SpringJUnitConfig(JpaConfig.class)
public class ProduitRepositoryTest {
	
	@Autowired
	private ProduitRepository produitRepo;

	@Test
	public void insert() {
		Produit p= new Produit("James Bond Coffret","Contient tous les films" , 800);
		Produit p1= new Produit("Barbie Coffret","Contient tous les films" , 800);
		Produit p2= new Produit("Star Wars Coffret","Contient tous les films" , 800);
		Produit p3= new Produit("Breaking Bad Coffret","Contient toutes les saisons" , 800);
		Produit p4= new Produit("Dexter Coffret","Contient toutes les saisons" , 800);
		produitRepo.save(p);
		produitRepo.save(p1);
		produitRepo.save(p2);
		produitRepo.save(p3);
		produitRepo.save(p4);
		produitRepo.deleteById(111L);
		
		
	}
}
