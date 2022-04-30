package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    List<Client> findBySexe(String sexe);
    List<Client> findByEtablissement(String etablissement);
    Client findByCin(String cin);
}
