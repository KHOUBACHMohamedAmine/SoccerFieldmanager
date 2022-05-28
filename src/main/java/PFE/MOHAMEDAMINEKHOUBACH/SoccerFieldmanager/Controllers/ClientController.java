package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ClientServiceImpl;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/clients")
public class ClientController {
    private ClientServiceImpl clientServiceImpl;
    private UserServiceImpl userService;

    public ClientController( ClientServiceImpl clientServiceImpl) {
        super();
        this.clientServiceImpl = clientServiceImpl;
    }
    @PostMapping("/")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return new ResponseEntity<Client>(clientServiceImpl.save(client),HttpStatus.CREATED);
    }
   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/")
    public List<Client> getAllClients(){
        return  clientServiceImpl.getAllClients();
    }
    @GetMapping("/nonArchived")
    public List<Client> getClientsNonArchived(){
        return  clientServiceImpl.getClientNonArchived();
    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/id/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(clientServiceImpl.getClientById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/sexe/{sexe}")
    public ResponseEntity getClientById(@PathVariable("sexe") String sexe){
        try{
            return new ResponseEntity(clientServiceImpl.getClientBySexe(sexe),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/cin/{cin}")
    public ResponseEntity getClientByCin(@PathVariable("cin") String cin){
        try{
            return new ResponseEntity(clientServiceImpl.getClientByCin(cin),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/etablissement/{etablissement}")
    public ResponseEntity getClientByEtablisssement(@PathVariable("etablissement") String etablissement){
        try{
            return new ResponseEntity(clientServiceImpl.getClientByEtablissement(etablissement),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
  //  @PreAuthorize("hasAuthority('ADMIN')")
     @PutMapping("/update/id/{id}")
    public ResponseEntity updateClient(@PathVariable("id") long id,@RequestBody Client client){

        try {
            Client existingClient = clientServiceImpl.updateClient(client,id);
            return new ResponseEntity(existingClient,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

     }
  //  @PreAuthorize("hasAuthority('ADMIN')")
     @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClientById(@PathVariable("id") Long id){
       try{
           Client client =clientServiceImpl.deleteById(id);
           return new ResponseEntity<>(client,HttpStatus.OK);
       }catch (RessourceNotFound r){
           return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
       }

     }
    @PutMapping("/archive/id/{id}")
    public ResponseEntity archive(@PathVariable("id") long id ){

        try{
            Client client =clientServiceImpl.archive(id);
            return new ResponseEntity<>(client,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
