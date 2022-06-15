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

import com.outbound.entities.inventory.ItemCategory;
import com.outbound.entities.inventory.WeaponType;

class WeaponTypeTest {

	private static EntityManagerFactory emf;

	private EntityManager em;

	private WeaponType type;

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
		type = em.find(WeaponType.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		type = null;
	}

	@Test
	@DisplayName("Testing entity weapon type to database")
	void test_entity_weapontype_to_database_connection() {

//		mysql> select * from weapon_type where id =1;
//		+----+-------+-------------+------------------+
//		| id | name  | description | item_category_id |
//		+----+-------+-------------+------------------+
//		|  1 | Rifle | rifle       |                9 |
//		+----+-------+-------------+------------------+
//		1 row in set (0.00 sec)
		
		assertNotNull(type);
		assertNotNull(type.getId());
		assertEquals("Rifle", type.getName());

	}

	@Test
	@DisplayName("Testing entity weapon type to item category in database")
	void test_entity_weapontype_to_itemcategory_in_database_connection() {
		
	
//	mysql> select * from item_category join weapon_type on weapon_type.item_category_id = item_category.id where weapon_type.item_category_id  = 9;
//	+----+-----------+----+--------------+--------------+------------------+
//	| id | type_name | id | name         | description  | item_category_id |
//	+----+-----------+----+--------------+--------------+------------------+
//	|  9 | Weapon    |  1 | Rifle        | rifle        |                9 |
//	|  9 | Weapon    |  2 | Bow          | bow          |                9 |
//	|  9 | Weapon    |  3 | Muzzleloader | muzzleloader |                9 |
//	+----+-----------+----+--------------+--------------+------------------+
//	3 rows in set (0.00 sec)


	assertNotNull(type);
	assertNotNull(type.getId());
	assertEquals("Weapon", type.getCategory().getTypeName());
	
	
	}
	
	
	
}
