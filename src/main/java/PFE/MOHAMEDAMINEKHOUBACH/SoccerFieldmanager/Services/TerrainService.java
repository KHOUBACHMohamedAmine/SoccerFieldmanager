package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.TerrainRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Terrain;

import java.util.List;
import java.util.Optional;

public class TerrainService {
    private final TerrainRepo terrainRepo;

    public TerrainService(TerrainRepo terrainRepo) {
        this.terrainRepo = terrainRepo;
    }
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
        return terrainRepo.findByReferenceContains(reference);
    }
    public List<Terrain> findByEtat(String etat){
        return terrainRepo.findByEtatContains(etat);
    }
    public void deleteTerrain(Long id){
        terrainRepo.deleteTerrainById(id);
    }
}
