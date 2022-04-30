package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:8090"})
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
        return new ResponseEntity<Client>(clientServiceImpl.getClientById(id),HttpStatus.OK);
    }
    @GetMapping("/sexe/{sexe}")
    public List<Client> getClientById(@PathVariable("sexe") String sexe){
        return clientServiceImpl.getClientBySexe(sexe);
    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable("cin") String cin){
        return new ResponseEntity<Client>(clientServiceImpl.getClientByCin(cin),HttpStatus.OK);
    }
    @GetMapping("/etablissement/{etablissement}")
    public List<Client> getClientByEtablisssement(@PathVariable("etablissement") String etablissement){
        return clientServiceImpl.getClientByEtablissement(etablissement);

    }
     @PutMapping("/update/id/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,@RequestBody Client client){
        return new ResponseEntity<Client>(clientServiceImpl.updateClient(client,id),HttpStatus.OK);
     }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable("id") Long id){
        clientServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Client deleted Succesfully",HttpStatus.OK);
     }

}
