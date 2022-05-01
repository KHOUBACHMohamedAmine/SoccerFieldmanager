package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {
    void deleteClientById(Long id);

    Optional<Client> findByIdEquals(long id);

    List<Client> findByCinContains(String cin);

    List<Client> findByNomContains(String nom);

    List<Client> findBySexeContains(String sexe);

    List<Client> findByEtablissementContains(String etablissement);

    List<Client> findByNumapogeeEquals(long numapogee);




}
