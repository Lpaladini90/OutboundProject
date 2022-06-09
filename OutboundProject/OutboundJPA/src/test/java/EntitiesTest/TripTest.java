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

import com.outbound.entities.Trip;

class TripTest {

	private  static EntityManagerFactory emf;
	private EntityManager em;
	private Trip trip;
	
	
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
		trip = em.find(Trip.class, 1);
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		trip = null;
	}
	
	@Test
	@DisplayName("Testing entity connection Trip to the data base")
	void testing_entity_trip_to_database() {
//		mysql> select * from trip where id =1;
//		+----+--------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		| id | name               | start_date | end_date | description                                         | success | user_id |
//		+----+--------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		|  1 | Fall Antelope Hunt | NULL       | NULL     | Wyoming Hunt in the fall for antelope and mule deer |       1 |       1 |
//		+----+--------------------+------------+----------+-----------------------------------------------------+---------+---------+
//		1 row in set (0.00 sec)
		
		assertNotNull(trip);
		assertNotNull(trip.getId());
		assertEquals("Fall Antelope Hunt", trip.getName());
		
	}
	
	
	
	


}
