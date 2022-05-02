package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;

import java.util.List;

public interface TerrainService {
    Terrain save(Terrain terrain);
    List<Terrain> getAllTerrains();
    Terrain getTerrainById(long id);
    Terrain updateTerrain(Terrain terrain,long id);
    void deleteById(long id);
    List<Terrain> getTerrainByReference(String reference);
    List<Terrain> getTerrainByEtat(String etat);
}
