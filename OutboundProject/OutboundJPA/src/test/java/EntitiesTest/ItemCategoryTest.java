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

import com.outbound.entities.inventory.ItemCategory;

class ItemCategoryTest {

	private static EntityManagerFactory emf;

	private EntityManager em;

	private ItemCategory cat;

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
		cat = em.find(ItemCategory.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cat = null;
	}

	@Test
	@DisplayName("Testing entity Item_category to database")
	void test_entity_itemcategory_to_database_connection() {

//		mysql> select * from item_category where id = 1;
//		+----+-----------+
//		| id | type_name |
//		+----+-----------+
//		|  1 | Backpack  |
//		+----+-----------+
//		1 row in set (0.00 sec)
		
		
		assertNotNull(cat);
		assertNotNull(cat.getId());
		assertEquals("Backpack", cat.getTypeName());

	}
	
	@Test
	@DisplayName("Testing entity item category to item in database")
	void test_entity_itemcategory_to_item_in_database_connection() {

//		mysql> select * from item_category where id = 1;
//		+----+-----------+
//		| id | type_name |
//		+----+-----------+
//		|  1 | Backpack  |
//		+----+-----------+
//		1 row in set (0.00 sec)
		
		
		assertNotNull(cat);
		assertNotNull(cat.getId());
		assertEquals("Backpack", cat.getTypeName());

	}
	@Test
	@DisplayName("Testing entity item category to weapon type in database")
	void test_entity_itemcategory_to_weapontype_in_database_connection() {
		
//		mysql> select * from item_category join weapon_type on weapon_type.item_category_id = item_category.id where item_category.id = 1;
//		Empty set (0.00 sec)
		
		
		assertNotNull(cat);
		assertNotNull(cat.getId());
		assertTrue(cat.getWeaponTypes().size()<1);
		
	}
	
	
	
	
	

}
