package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;

import java.util.List;

public interface ClientService {
Client save(Client client);
List<Client> getAllClients();
Client getClientById(long id);
Client updateClient(Client client,long id);
void deleteById(long id);
List<Client> getClientByCin(String cin);
List<Client> getClientBySexe(String sexe);
List<Client> getClientByEtablissement(String etablissement);

}
