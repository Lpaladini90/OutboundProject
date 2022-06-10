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

import com.outbound.entities.GearList;

class GearListTest {

	private  static EntityManagerFactory emf;
	private EntityManager em;
	private GearList list;
	
	
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
		list = em.find(GearList.class, 1);
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		list = null;
	}

	
	
	@Test
	@DisplayName("Testing entity GearList to database")
	void test_entity_gearlist_to_database_connection() {
		
//		mysql> select * from gear_list where id = 1;
//		+----+--------------------+--------+---------+-------------------+
//		| id | description        | active | user_id | gear_inventory_id |
//		+----+--------------------+--------+---------+-------------------+
//		|  1 | Antelope Hunt List |      1 |       1 |                 1 |
//		+----+--------------------+--------+---------+-------------------+
//		1 row in set (0.00 sec)
		
		
		assertNotNull(list);
		assertNotNull(list.getId());
		assertEquals("Antelope Hunt List", list.getDescription());
		
		
	}  
	@Test
	@DisplayName("Testing entity GearList to User in database")
	void test_entity_gearlist_to_user_in_database_connection() {
		
//		mysql> select * from gear_list join user on user.id = gear_list.user_id where user.id = 1;
//		+----+--------------------+--------+---------+--------------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		| id | description        | active | user_id | inventory_id | id | username    | password                                                     | first_name | last_name | email            | role  | description    | phone          | active |
//		+----+--------------------+--------+---------+--------------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		|  1 | Antelope Hunt List |      1 |       1 |            1 |  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |
//		|  2 | Mule Deer Hunt     |      1 |       1 |            1 |  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |
//		+----+--------------------+--------+---------+--------------+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		2 rows in set (0.00 sec)
		
		
		assertNotNull(list);
		assertNotNull(list.getId());
		assertEquals("Lucas", list.getUser().getFirstName());
		
		
	}  
	@Test
	@DisplayName("Testing entity GearList to Inventory in database")
	void test_entity_gearlist_to_inventory_in_database_connection() {
		
//		mysql> select * from gear_list join inventory on inventory.id = gear_list.inventory_id where inventory.id = 1;
//		+----+--------------------+--------+---------+--------------+----+---------+
//		| id | description        | active | user_id | inventory_id | id | user_id |
//		+----+--------------------+--------+---------+--------------+----+---------+
//		|  1 | Antelope Hunt List |      1 |       1 |            1 |  1 |       1 |
//		|  2 | Mule Deer Hunt     |      1 |       1 |            1 |  1 |       1 |
//		+----+--------------------+--------+---------+--------------+----+---------+
//		2 rows in set (0.00 sec)
		
		assertNotNull(list);
		assertNotNull(list.getId());
		assertEquals(1, list.getInventory().getId());
		
		
	}  
	
	
	
	
	
	
	
	
	
	
	

}