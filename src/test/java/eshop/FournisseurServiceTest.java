package eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entity.Adresse;
import eshop.entity.Fournisseur;
import eshop.exception.FournisseurException;
import eshop.exception.IdException;
import eshop.service.FournisseurService;

@SpringJUnitConfig(JpaConfig.class)
class FournisseurServiceTest {

	@Autowired
	private FournisseurService fournisseurSrv;

	@Test
	void test() {
		assertNotNull(fournisseurSrv);
	}
	
	@Test
	public void insert() {
		Fournisseur f = new Fournisseur("bleubleu", "bleu@bleu.com", new Adresse("numero","rue","codePostal","ville"),"bleu");
		fournisseurSrv.create(f);
		assertNotNull(fournisseurSrv.getById(f.getId()));
	}
	
	@Test
	void insertError() {
		Fournisseur f = new Fournisseur(null, "bleu@bleu.com", new Adresse("numero","rue","codePostal","ville"),"bleu");
	assertThrows(FournisseurException.class, () ->{
		fournisseurSrv.create(f);
	});
	assertThrows(FournisseurException.class, () ->{
		fournisseurSrv.create(
				new Fournisseur("", "bleu@bleu.com", new Adresse("numero","rue","codePostal","ville"),"bleu"));
	});

}
	
	@Test
	void findById() {
		assertThrows(IdException.class, () ->{
			fournisseurSrv.getById(null);
		});
		assertThrows(FournisseurException.class, () ->{
			fournisseurSrv.getById(1L);
		});
	}

}
