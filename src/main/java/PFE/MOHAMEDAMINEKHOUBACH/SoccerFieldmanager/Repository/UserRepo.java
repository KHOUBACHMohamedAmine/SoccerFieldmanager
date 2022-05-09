package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    List<User> findByCin(String cin);

    List<User> findBySexe(String sexe);

    List<User> findByEtablissement(String etablissement);
    User findByLogin(String login);

}
