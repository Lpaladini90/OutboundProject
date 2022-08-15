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
//
//	@Test
//	@DisplayName("testing entity gear list to join table to item")
//	void test_gearlist_to_join_table_to_item() {
////		mysql> select * from gear_list join item_has_gear_list on gear_list.id = item_has_gear_list.gear_list_id join item on item.id = item_has_gear_list.item_id where gear_list.id =1;
////		+----+---------------+--------------------+--------+---------+---------+--------------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------+--------------+------------------+
////		| id | title         | description        | active | user_id | item_id | gear_list_id | id | brand              | model_name                        | description                                                                                                                                                                                                                                                              | weight | active | inventory_id | item_category_id |
////		+----+---------------+--------------------+--------+---------+---------+--------------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------+--------------+------------------+
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       1 |            1 |  1 | Kifaru             | Fulcrum                           | Functional, versatile and durable are just a few words that describe the Fulcrum                                                                                                                                                                                         |    3.4 |      1 |            1 |                1 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       2 |            1 |  2 | Adventure Med Kits | Ultralight/ Watertight .9 Med Kit | The kit features two layers of rugged waterproofing protection, keeping the contents safe and dry even in the most extreme elements. Ideal for ultralight hiking, this kit lets you keep weight to a minimum, as it weighs less than 8 oz., while still being prepared.  |   0.75 |      1 |            1 |                3 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       3 |            1 |  3 | Vortex Binoculars  | Diamondback HD 12x50              | The Diamondback® HD smashes the scale of price vs performance, delivering a rock-solid optic that optically punches high above its class.                                                                                                                                |    1.8 |      1 |            1 |                5 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       4 |            1 |  4 | Mountain House     | Beef Strogi                       | freeze dried food- use with jet boil.                                                                                                                                                                                                                                    |  0.268 |      1 |            1 |                7 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       5 |            1 |  5 | Jetboil            | MicroMo                           | Cooking System                                                                                                                                                                                                                                                           |   0.75 |      1 |            1 |                2 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       6 |            1 |  6 | MSR                | IsoPro                            | jet boil fuel                                                                                                                                                                                                                                                            |   0.25 |      1 |            1 |                2 |
////		|  1 | Antelope Fall | Antelope Hunt List |      1 |       1 |       7 |            1 |  7 | Ascent             | 900                               | light weight down sleeping bag                                                                                                                                                                                                                                           |   3.55 |      1 |            1 |                6 |
////		+----+---------------+--------------------+--------+---------+---------+--------------+----+--------------------+-----------------------------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+--------+--------+--------------+------------------+
////		7 rows in set (0.00 sec)
//		
//		assertNotNull(list);
//		assertNotNull(list.getId());
//		assertTrue(list.getItems().size()>0);
//	}
	
	

}
