package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
User save(User client);
List<User> getAllUsers();
User getUserById(long id);
User updateUser(User user, long id);
void deleteById(long id);
List<User> getUserByCin(String cin);
List<User> getUserBySexe(String sexe);
List<User> getUserByEtablissement(String etablissement);
User getUserByLogin(String login);
void addRoletoUser(String login, String role);

    ResponseEntity<?> authenticate(User user);
}
