package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.ClientRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.TerrainRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TerrainServiceImpl implements TerrainService {
    private  final TerrainRepo terrainRepo;

    @Autowired
    public TerrainServiceImpl(TerrainRepo terrainRepo) {
        this.terrainRepo = terrainRepo;
    }

    @Override
    public  Terrain save(Terrain terrain) {
        return terrainRepo.save(terrain);
    }

    @Override
    public List<Terrain> getAllTerrains() {
        return terrainRepo.findAll();
    }

    @Override
    public Terrain getTerrainById(long id) {
        return terrainRepo.findById(id).orElseThrow(()-> new RessourceNotFound("Terrain","Id",id));

    }

    @Override
    public Terrain updateTerrain(Terrain terrain, long id) {
        Terrain existingTerrain = terrainRepo.findById(id).orElseThrow(
                () -> new RessourceNotFound("Terrain", "Id", id));

        existingTerrain.setEtat(terrain.getEtat());
        existingTerrain.setReference(terrain.getReference());
        terrainRepo.save(existingTerrain);
        return existingTerrain;
    }

    @Override
    public Terrain deleteById(long id) {
        Terrain terrain = terrainRepo.findById(id).orElseThrow(() ->
                new RessourceNotFound("Terrain", "Id", id));

        terrainRepo.deleteById(id);
        return terrain;

    }

    @Override
    public List<Terrain> getTerrainByReference(String reference) {
        List<Terrain> terrainsfounded=new ArrayList<Terrain>(terrainRepo.findByReference(reference));
        if (terrainsfounded.isEmpty()) throw new RessourceNotFound("Terrain","Reference",reference);
        else return terrainsfounded ;
    }

    @Override
    public List<Terrain> getTerrainByEtat(String etat) {
        List<Terrain> terrainsfounded=new ArrayList<Terrain>(terrainRepo.findByEtat(etat));
        if (terrainsfounded.isEmpty()) throw new RessourceNotFound("Terrain","Etat",etat);
        else return terrainsfounded ;
    }

    //  private final TerrainRepo terrainRepo;

  /*  @Autowired
    public TerrainServiceImpl(TerrainRepo terrainRepo) {
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
    }*/

}
