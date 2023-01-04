package eshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entity.Adresse;
import eshop.entity.Fournisseur;
import eshop.exception.FournisseurException;
import eshop.repository.FournisseurRepository;

@SpringJUnitConfig(JpaConfig.class)
class FournisseurRepositoryTest {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	
	@Test
	public void insert() {
		Fournisseur fournisseur1= new Fournisseur("bloublou", "blou@blou.com", new Adresse("numero","rue","codePostal","ville"),"blou" );
		Fournisseur fournisseur2= new Fournisseur("blabla", "bla@bla.com", new Adresse("numero","rue","codePostal","ville"),"bla" );
		Fournisseur fournisseur3= new Fournisseur("blublu", "blu@blu.com", new Adresse("numero","rue","codePostal","ville"),"blu" );
		Fournisseur fournisseur4= new Fournisseur("blibli", "bli@bli.com", new Adresse("numero","rue","codePostal","ville"),"bli" );
		fournisseurRepo.save(fournisseur1);
		fournisseurRepo.save(fournisseur2);
		fournisseurRepo.save(fournisseur3);
		fournisseurRepo.save(fournisseur4);
	} 
	
	@Test
	void requetePerso() {
		fournisseurRepo.findByContactContaining("o");
		fournisseurRepo.findByNomContaining("o");
		
	}
	
//	@Test
//	void test() {
//		assertTrue(fournisseurRepo.findById(50L).orElseThrow(FournisseurException::new) instanceof Fournisseur);
//	}
	
	@Test
	void findByIdException() {
		assertThrows(FournisseurException.class, ()->{
			fournisseurRepo.findById(500L).orElseThrow(FournisseurException::new);
		});
	}
	
	@Test
	void PageTest() {
		Pageable pageable=PageRequest.of(0, 2);
		Page<Fournisseur> page= fournisseurRepo.findAll(pageable);
		System.out.println(page);
		page.forEach(f->{
			System.out.println(f.getId());
		});
		page = fournisseurRepo.findAll(page.nextOrLastPageable());
		System.out.println(page);
		page.forEach(f->{
			System.out.println(f.getId());
		});
	}

}
