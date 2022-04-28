package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerrainRepo extends JpaRepository <Terrain , Long> {

    void deleteTerrainById(Long id);


    Optional<Terrain> findById(Long aLong);

    List<Terrain> findByReferenceContains(String reference);

    List<Terrain> findByEtatContains(String etat);

}
