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

import com.outbound.entities.User;

class UserTest {


	private  static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	
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
		user = em.find(User.class, 1);
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	
	
	@Test
	@DisplayName("Testing entity User to database")
	void test_entity_user_to_database_connection() {
		
//		mysql> select * from user where id = 1;
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		| id | username    | password                                                     | first_name | last_name | email            | role  | description    | phone          | active |
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+
//		1 row in set (0.01 sec)		
		
		
		assertNotNull(user);
		assertNotNull(user.getId());
		assertEquals("Lucas", user.getFirstName());
		assertEquals("lpaladini@me.com", user.getEmail());
		
	}  
	

	@Test
	@DisplayName("Testing relational mapping from user to trip in database")
	void test_relational_mapping_from_user_to_trip_in_db() {
		
//		mysql> select * from user join trip on trip.user_id = user.id where user.id =1;
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		| id | username    | password                                                     | first_name | last_name | email            | role  | description    | phone          | active | id | name                     | start_date | end_date | description                                         | success | user_id |
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  1 | Fall Antelope Hunt       | NULL       | NULL     | Wyoming Hunt in the fall for antelope and mule deer |       1 |       1 |
//		|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  2 | Mule Deer Fall Hunt      | NULL       | NULL     | Hunting Mule Deer in Colorado                       |       0 |       1 |
//		|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  3 | Black Bear Spring Hunt   | NULL       | NULL     | Alaskan Black bear hunt in the spring               |       0 |       1 |
//		+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		15 rows in set (0.01 sec)
		
		
		assertNotNull(user);
		assertNotNull(user.getId());
		assertTrue(user.getTrips().size()>0);
		
	}
	

	
	
}
