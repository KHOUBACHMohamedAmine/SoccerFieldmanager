package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    List<Client> findByCin(String cin);

    List<Client> findBySexe(String sexe);

    List<Client> findByEtablissement(String etablissement);

    Client findByUser_Email(String email);




    List<Client> findByIsArchivedFalse();




}
