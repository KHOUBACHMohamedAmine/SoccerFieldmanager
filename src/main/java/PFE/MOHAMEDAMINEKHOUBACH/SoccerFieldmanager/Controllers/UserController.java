package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
public class UserController {
    UserServiceImpl userService;
    public UserController( UserServiceImpl userService ) {
        super();
        this.userService = userService;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        return userService.authenticate(user);
    }
    @PostMapping("/signin")
    public ResponseEntity saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

}
