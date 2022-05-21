package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Terrain;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.TerrainServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
@RequestMapping("/api/v1/terrains")
public class TerrainController {
    private TerrainServiceImpl terrainServiceImpl;

    public TerrainController( TerrainServiceImpl terrainServiceImpl) {
        super();
        this.terrainServiceImpl = terrainServiceImpl;
    }

    @PostMapping("/")
    public ResponseEntity<Terrain> saveTerrain(@RequestBody Terrain terrain){
        return new ResponseEntity<Terrain>(terrainServiceImpl.save(terrain), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Terrain> getAllTerrains(){
        return  terrainServiceImpl.getAllTerrains();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(terrainServiceImpl.getTerrainById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/etat/{etat}")
    public ResponseEntity getTerrainsByEtat(@PathVariable("etat") String etat){
        try{
            return new ResponseEntity(terrainServiceImpl.getTerrainByEtat(etat),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/reference/{reference}")
    public ResponseEntity getTerrainsByReference(@PathVariable("reference") String reference){
        try{
            return new ResponseEntity(terrainServiceImpl.getTerrainByReference(reference),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/update/id/{id}")
    public ResponseEntity updateClient(@PathVariable("id") long id,@RequestBody Terrain terrain){
        try {
            terrainServiceImpl.updateTerrain(terrain,id);
            return new ResponseEntity(terrain,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClientById(@PathVariable("id") Long id){
        try {
            terrainServiceImpl.deleteById(id);
            return new ResponseEntity<String>("Terrain deleted Succesfully",HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
