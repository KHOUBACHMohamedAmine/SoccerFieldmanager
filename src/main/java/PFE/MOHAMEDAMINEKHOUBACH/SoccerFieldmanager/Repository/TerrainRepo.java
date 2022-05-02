package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TerrainRepo extends JpaRepository <Terrain , Long> {

    List<Terrain> findByReference(String reference);
    List<Terrain> findByEtat(String etat);

}
