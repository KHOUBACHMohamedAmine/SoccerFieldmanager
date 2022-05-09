package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class SoccerFieldmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SoccerFieldmanagerApplication.class, args);


	}

































	// TODO for 4-march-2022
	/**
	 * 1- create your database (soccer_db) in phpAdmin : DONE
	 * 2- You should distinguish between association and inheritance (l'heritage)
	 * 	 Association:
	 *   - One Reservation belong to one Terrain
	 *   - A Terrain has 1..* Reservation
	 *   ==> so here we use the injection of Terran in reservation by the @OneToOne annotation
	 *   - A Reservation was created by one User
	 *   - A User can make 1..* of Reservation
	 	see : https://www.youtube.com/watch?v=f5bdUjEIbrg
	          https://www.youtube.com/watch?v=9SGDpanrc8U
	 *	Inheritance:
	 *	A client is a Personnel
	 *	3- refer to https://www.youtube.com/watch?v=7dBijbBdgbc and https://gayerie.dev/epsi-b3-orm/javaee_orm/jpa_inheritance.html
	 * 	to understand the inheritance between entities, and to implement the correct way of inheritance between ( User, Personnel, and administrateur)
	 **/

}
