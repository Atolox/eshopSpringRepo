package eshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entity.Civilite;
import eshop.entity.Client;
import eshop.entity.Commande;
import eshop.repository.ClientRepository;
import eshop.repository.CommandeRepository;

@SpringJUnitConfig(JpaConfig.class)
class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRep;
	private CommandeRepository commandeRep;
	
	// Tests CRUD
	@Test
	void test() {
		Client client1 = new Client("Rombaut", "bla@bla.fr", null, "Antoine", null, null);
		clientRep.save(client1);
		client1.setCivilite(Civilite.M);
		clientRep.save(client1);
		Client client2 = new Client("qsddqsd", "bla@bla.fr", null, "Antoine", null, null);
		Client client3 = new Client("azeaz", "bla@bla.fr", null, "Antoine", null, null);
		Client client4 = new Client("qsd", "bla@bla.fr", null, "Antoine", null, null);
		Client client5 = new Client("sqsqd", "bla@bla.fr", null, "Antoine", null, null);
		Client client6 = new Client("sdqd", "bla@bla.fr", null, "Antoine", null, null);
		Client client7 = new Client("Romazeaezbaut", "bla@bla.fr", null, "Antoine", null, null);
		Client client8 = new Client("qsd", "bla@bla.fr", null, "Antoine", null, null);
		clientRep.save(client2);
		clientRep.save(client3);
		clientRep.save(client4);
		clientRep.save(client5);
		clientRep.save(client6);
		clientRep.save(client7);
		clientRep.save(client8);
		System.out.println(clientRep.findById(56L));
		
		Commande c = new Commande(null, client1);
		System.out.println(c);
		commandeRep.save(c);
		

	}
	

}
