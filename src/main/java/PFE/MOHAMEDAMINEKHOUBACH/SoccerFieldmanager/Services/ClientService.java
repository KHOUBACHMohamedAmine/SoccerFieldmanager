package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.ClientRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Assurance;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public boolean createAccount(String cin, String nom, String prenom, String sexe, String numtel, long numapogee, String login, String password, String etablissement, Assurance assurance) {
    Client client = new Client(cin,nom,prenom,sexe,numtel,numapogee,login,password,etablissement,assurance);
        return client.verifierAssurance();

    }
    public List<Client> findAllClients(){
     return clientRepo.findAll();
    }
    public Optional<Client> findClientsById(Long id){
        return clientRepo.findByIdEquals(id);
    }
    public List<Client> findClientsByNom(String nom){
        return clientRepo.findByNomContains(nom);
    }
    public List<Client> findClientsByCin(String cin){
        return clientRepo.findByCinContains(cin);
    }
    public List<Client> findClientsByEtablissement(String etab){
        return clientRepo.findByEtablissementContains(etab);
    }
    public List<Client> findClientsBySexe(String sexe){
        return clientRepo.findBySexeContains(sexe);
    }
    public List<Client> findClientsByApogee(Long apogee){
        return clientRepo.findByNumapogeeEquals(apogee);
    }
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }
    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);
    }







}
