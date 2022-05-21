package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.ClientRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

   private  final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


 @Override
 public Client save(Client client) {
  return clientRepo.save(client);
 }

 @Override
 public List<Client> getAllClients() {
  return clientRepo.findAll();
 }

 @Override
 public Client getClientById(long id) {
  return clientRepo.findById(id).orElseThrow(()-> new RessourceNotFound("Client","Id",id));
 }

 @Override
 public Client updateClient(Client client, long id) {
  Client existingClient = clientRepo.findById(id).orElseThrow(
          () -> new RessourceNotFound("Client", "Id", id));

  existingClient.setNom(client.getNom());
  existingClient.setPrenom(client.getPrenom());
  existingClient.setCin(client.getCin());
  existingClient.setEtablissement(client.getEtablissement());
  existingClient.setNumtel(client.getNumtel());
  existingClient.setNumapogee(client.getNumapogee());
  existingClient.setSexe(client.getSexe());
  existingClient.getUser().setEmail((client.getUser().getEmail()));
  existingClient.getUser().setPassword((client.getUser().getPassword()));
  clientRepo.save(existingClient);
  return existingClient;
 }

 @Override
 public Client deleteById(long id) {
  Client client = clientRepo.findById(id).orElseThrow(() ->
          new RessourceNotFound("Client", "Id", id));
  clientRepo.deleteById(id);
  return client;
 }

 @Override
 public List<Client> getClientByCin(String cin) {
     List<Client> clientsfounded=new ArrayList<Client>(clientRepo.findByCin(cin));
  if (clientsfounded.isEmpty()) throw new RessourceNotFound("Client","Cin",cin);
  else return clientsfounded ;
 }

 @Override
 public List<Client> getClientBySexe(String sexe) {
  List<Client> clientsfounded=new ArrayList<Client>(clientRepo.findBySexe(sexe));
  if (clientsfounded.isEmpty()) throw new RessourceNotFound("Client","Sexe",sexe);
  else return clientsfounded ;
 }

 @Override
 public List<Client> getClientByEtablissement(String etablissement) {
     List<Client> clientsfounded=new ArrayList<Client>(clientRepo.findByEtablissement(etablissement));
     if (clientsfounded.isEmpty()) throw new RessourceNotFound("Client","Etablissement",etablissement);
     else return clientsfounded ;
 }

 @Override
 public void archive(long id) {
  clientRepo.archive(id);
 }

 @Override
 public List<Client> getClientNonArchived() {
  return clientRepo.findByIsArchivedFalse();
 }



   /*
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
*/






}
