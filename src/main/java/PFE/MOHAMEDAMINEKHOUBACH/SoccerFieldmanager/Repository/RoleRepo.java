package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;


import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByTitre(String titre);





}
