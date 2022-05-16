package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ClientServiceImpl;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})

@RequestMapping("/api/v1/clients")
public class ClientController {
    private ClientServiceImpl clientServiceImpl;


    public ClientController( ClientServiceImpl clientServiceImpl) {
        super();
        this.clientServiceImpl = clientServiceImpl;
    }
    @PostMapping("/")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return new ResponseEntity<Client>(clientServiceImpl.save(client),HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<Client> getAllClients(){
        return  clientServiceImpl.getAllClients();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(clientServiceImpl.getClientById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/sexe/{sexe}")
    public ResponseEntity getClientById(@PathVariable("sexe") String sexe){
        try{
            return new ResponseEntity(clientServiceImpl.getClientBySexe(sexe),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity getClientByCin(@PathVariable("cin") String cin){
        try{
            return new ResponseEntity(clientServiceImpl.getClientByCin(cin),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/etablissement/{etablissement}")
    public ResponseEntity getClientByEtablisssement(@PathVariable("etablissement") String etablissement){
        try{
            return new ResponseEntity(clientServiceImpl.getClientByEtablissement(etablissement),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
     @PutMapping("/update/id/{id}")
    public ResponseEntity updateClient(@PathVariable("id") long id,@RequestBody Client client){
        try {
            clientServiceImpl.updateClient(client,id);
            return new ResponseEntity(client,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

     }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClientById(@PathVariable("id") Long id){
       try{
           clientServiceImpl.deleteById(id);
           return new ResponseEntity<String>("Client deleted Succesfully",HttpStatus.OK);
       }catch (RessourceNotFound r){
           return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
       }

     }


}
