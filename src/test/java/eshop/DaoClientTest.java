package eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.dao.DaoClient;
import eshop.entity.Client;

//@Transactional
//@Rollback
@SpringJUnitConfig(JpaConfig.class)
class DaoClientTest {

	@Autowired
	DaoClient daoClient;
	
	@Test
//	@Commit
	void insertTest() {
		Client client = new Client("Rombaut", "bla@bla.fr", null, "Antoine", null, null);
		assertNull(client.getId());
		daoClient.insert(client);
		assertNotNull(client.getId());
		assertNotNull(daoClient.findByKey(client.getId()));

	}
	
	@Test
	void deleteTest() {
		Client client2 = new Client("Youpi", "bla@bla.fr", null, "Antoine", null, null);
		assertNull(client2.getId());
		daoClient.insert(client2);
		assertNotNull(client2.getId());
		daoClient.deleteByKey(client2.getId());
		assertNull(daoClient.findByKey(client2.getId()));
	}
	
	@Test
	void updateTest() {
		Client client3 = new Client("Youpi", "bla@bla.fr", null, "Antoine", null, null);
		assertNull(client3);
		daoClient.insert(client3);
		assertNotNull(client3.getId());
		clien

	}

}
