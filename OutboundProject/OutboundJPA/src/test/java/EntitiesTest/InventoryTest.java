package EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.outbound.entities.inventory.Inventory;

class InventoryTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Inventory list;

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
		list = em.find(Inventory.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		list = null;
	}

	@Test
	@DisplayName("Testing entity Inventory to database")
	void test_entity_inventory_to_database_connection() {

//		mysql> select * from inventory where id =1;
//		+----+---------+
//		| id | user_id |
//		+----+---------+
//		|  1 |       1 |
//		+----+---------+
//		1 row in set (0.00 sec)

		assertNotNull(list);
		assertNotNull(list.getId());
		assertEquals(1, list.getId());

	}

	@Test
	@DisplayName("Testing entity Inventory to User in database")
	void test_entity_inventory_to_user_in_database_connection() {

//		mysql> select * from inventory join user on user.id = inventory.user_id where inventory.id = 1;
//		+----+---------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		| id | user_id | id | username    | password                                                     | first_name | last_name | email            | role  | description    | phone          | active |
//		+----+---------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		|  1 |       1 |  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |
//		+----+---------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		1 row in set (0.00 sec)

		assertNotNull(list);
		assertNotNull(list.getId());
		assertEquals("Lucas", list.getUser().getFirstName());

	}
//
	@Test
	@DisplayName("Testing entity Inventory to GearList in database")
	void test_entity_inventory_to_gearlist_in_database_connection() {

//		mysql> select * from inventory join gear_list on gear_list.inventory_id = inventory.id where inventory.id = 1;
//		+----+---------+----+--------------------+--------+---------+--------------+
//		| id | user_id | id | description        | active | user_id | inventory_id |
//		+----+---------+----+--------------------+--------+---------+--------------+
//		|  1 |       1 |  1 | Antelope Hunt List |      1 |       1 |            1 |
//		|  1 |       1 |  2 | Mule Deer Hunt     |      1 |       1 |            1 |
//		+----+---------+----+--------------------+--------+---------+--------------+
//		2 rows in set (0.01 sec)

		assertNotNull(list);
		assertNotNull(list.getId());
		assertTrue(list.getLists().size() > 0);

	}
//
	@Test
	@DisplayName("Testing entity Inventory to Items in database")
	void test_entity_inventory_to_items_in_database_connection() {

//		mysql> select * from inventory join item on item.inventory_id = inventory.id where inventory.id = 1;
//		+----+---------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------------+
//		| id | user_id | id | brand              | model_name                        | description                                                                                                                                                                                                                                                              | weight | inventory_id |
//		+----+---------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------------+
//		|  1 |       1 |  1 | Kifaru             | Fulcrum                           | Functional, versatile and durable are just a few words that describe the Fulcrum                                                                                                                                                                                         |    3.4 |            1 |
//		|  1 |       1 |  2 | Adventure Med Kits | Ultralight/ Watertight .9 Med Kit | The kit features two layers of rugged waterproofing protection, keeping the contents safe and dry even in the most extreme elements. Ideal for ultralight hiking, this kit lets you keep weight to a minimum, as it weighs less than 8 oz., while still being prepared.  |   0.75 |            1 |
//		|  1 |       1 |  3 | Vortex Binoculars  | Diamondback HD 12x50              | The Diamondback® HD smashes the scale of price vs performance, delivering a rock-solid optic that optically punches high above its class.                                                                                                                                |    1.8 |            1 |
//		|  1 |       1 | 10 | Counter Assault    | Bear Spray                        | Bear protection with holster                                                                                                                                                                                                                                             |    0.5 |            1 |
//		|  1 |       1 | 11 | Matthews           | Vertix                            | Compound Bow                                                                                                                                                                                                                                                             |   NULL |            1 |
//		|  1 |       1 | 12 | First Lite         | Corrugate Pants                   | brown general hunt pants                                                                                                                                                                                                                                                 |   NULL |            1 |
//		ETC .............
//		+----+---------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------------+
//		12 rows in set (0.00 sec)
		

		assertNotNull(list);
		assertNotNull(list.getId());
		assertTrue(list.getItems().size() > 0);

	}

}
