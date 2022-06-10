package EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.outbound.entities.inventory.Item;

class ItemTest {

	private static EntityManagerFactory emf;

	private EntityManager em;

	private Item item;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("OutboundJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();

	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		item = em.find(Item.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		item = null;
	}

	@Test
	@DisplayName("Testing entity Item to database")
	void test_entity_item_to_database_connection() {

//		 mysql> select * from item where id = 1;
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+
//		 | id | brand  | model_name | description                                                                      | weight | inventory_id |
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+
//		 |  1 | Kifaru | Fulcrum    | Functional, versatile and durable are just a few words that describe the Fulcrum |    3.4 |            1 |
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+
//		 1 row in set (0.00 sec)

		assertNotNull(item);
		assertNotNull(item.getId());
		assertEquals("Kifaru", item.getBrand());

	}

	@Test
	@DisplayName("Testing entity Item to inventory database")
	void test_entity_item_to_inventory_in_database_connection() {

//		 mysql> select * from item join item_category on item.item_category_id = item_category.id where item.id = 1;
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+------------------+----+-----------+
//		 | id | brand  | model_name | description                                                                      | weight | inventory_id | item_category_id | id | type_name |
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+------------------+----+-----------+
//		 |  1 | Kifaru | Fulcrum    | Functional, versatile and durable are just a few words that describe the Fulcrum |    3.4 |            1 |                1 |  1 | Backpack  |
//		 +----+--------+------------+----------------------------------------------------------------------------------+--------+--------------+------------------+----+-----------+
//		 1 row in set (0.00 sec)

		assertNotNull(item);
		assertNotNull(item.getId());
		assertEquals("Backpack", item.getCategory().getTypeName());

	}
	

}
