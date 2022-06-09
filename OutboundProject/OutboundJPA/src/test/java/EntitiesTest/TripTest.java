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

	private static EntityManagerFactory emf;
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

	@Test
	@DisplayName("Testing relational mapping from trip to user in database")
	void test_relational_mapping_from_trip_to_user_in_db() {

//	mysql> select * from user join trip on trip.user_id = user.id where user.id =1;
//	+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//	| id | username    | password                                                     | first_name | last_name | email            | role  | description    | phone          | active | id | name                     | start_date | end_date | description                                         | success | user_id |
//	+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//	|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  1 | Fall Antelope Hunt       | NULL       | NULL     | Wyoming Hunt in the fall for antelope and mule deer |       1 |       1 |
//	|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  2 | Mule Deer Fall Hunt      | NULL       | NULL     | Hunting Mule Deer in Colorado                       |       0 |       1 |
//	|  1 | lpaladini90 | $2a$10$jUUiSZOm80cSZGNAQLHRLutd3C2sw3or3GOCUzSXzixHw6NC9Phv. | Lucas      | Paladini  | lpaladini@me.com | ADMIN | I like to hunt | (509)-993-8866 |      1 |  3 | Black Bear Spring Hunt   | NULL       | NULL     | Alaskan Black bear hunt in the spring               |       0 |       1 |
//	+----+-------------+--------------------------------------------------------------+------------+-----------+------------------+-------+----------------+----------------+--------+----+--------------------------+------------+----------+-----------------------------------------------------+---------+---------+
//	15 rows in set (0.01 sec)

		assertNotNull(trip);
		assertNotNull(trip.getId());
		assertEquals("Lucas", trip.getUser().getFirstName());

	}

}
