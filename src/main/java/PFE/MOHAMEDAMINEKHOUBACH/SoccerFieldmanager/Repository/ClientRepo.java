package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

/**
 * Il te manque l'annotation @Repository
 */
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    /**
    Dans JPA il y a déja une methode prédefini pour le delete 'deletById(Long id) et pour le get findById(Long id)
     Donc tu ne doit pas les déclarées ici
     */
    // void deleteClientById(Long id);
    // void deleteById(Long id);
    List<Client> findBySexe(String sexe);
    List<Client> findByEtablissement(String etablissement);
    /**
     * @param cin
     * @return Client
     */
    Client findByCin(String cin);


    /**
     * Pour ton cas c'est pas la peine d'utilisé Equals et Contains
     */
    /*
    Optional<Client> findByIdEquals(long id);

    List<Client> findByCinContains(String cin);

    List<Client> findByNomContains(String nom);

    List<Client> findBySexeContains(String sexe);

    List<Client> findByEtablissementContains(String etablissement);

    List<Client> findByNumapogeeEquals(long numapogee);*/




}
