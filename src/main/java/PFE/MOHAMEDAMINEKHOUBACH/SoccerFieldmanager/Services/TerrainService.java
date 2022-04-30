package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.TerrainRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Terrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TerrainService {

    private final TerrainRepo terrainRepo;

    @Autowired
    public TerrainService(TerrainRepo terrainRepo) {
        this.terrainRepo = terrainRepo;
    }
    public Terrain save(Terrain terrain){
        return terrainRepo.save(terrain);
    }
    public Terrain updateTerrain(Terrain terrain){
        return terrainRepo.save(terrain);
    }
    public List<Terrain> findAll(){
        return terrainRepo.findAll();
    }
    public Optional<Terrain> findById(Long id){
        return terrainRepo.findById(id);
    }
    public Terrain findByReference(String reference){
        return terrainRepo.findByReference(reference);
    }
    public List<Terrain> findByEtat(String etat){
        return terrainRepo.findByEtat(etat);
    }
    public void delete(Long id){
        terrainRepo.deleteById(id);
    }
    /*
   public Terrain addTerrain(Terrain terrain){
        return terrainRepo.save(terrain);
    }
    public Terrain updateTerrain(Terrain terrain){
        return terrainRepo.save(terrain);
    }
    public List<Terrain> findAllTerrains(){
        return terrainRepo.findAll();
    }
    public Optional<Terrain> findById(Long id){
        return terrainRepo.findById(id);
    }
    public List<Terrain> findByReference(String reference){
        return terrainRepo.findByReference(reference);
    }
    public List<Terrain> findByEtat(String etat){
        return terrainRepo.findByEtat(etat);
    }
    public void deleteTerrain(Long id){
        terrainRepo.deleteById(id);
    }*/
}
