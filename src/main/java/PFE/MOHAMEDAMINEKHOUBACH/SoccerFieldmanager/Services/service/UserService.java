package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;


import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    int save(User user);

    List<User> findAll();

    User findByEmail(String email);

    public void addRoletouser(String email, String role);

    ResponseEntity<?> authenticate(User user);

}
