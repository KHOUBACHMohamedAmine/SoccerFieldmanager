package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.ClientServiceImpl;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
public class UserController {
    UserServiceImpl userService;
    ClientServiceImpl clientService;
    public UserController( UserServiceImpl userService,ClientServiceImpl clientService ) {
        super();
        this.clientService=clientService;
        this.userService = userService;
    }
    @PostMapping("/authenticate")

    public ResponseEntity<?> authenticate(@RequestBody User user) {
       try {
           return userService.authenticate(user);
       }catch (RuntimeException r ){
           r=new RuntimeException("Email ou Mot De Passe Incorrect !!");
           return new ResponseEntity(r.getMessage(),HttpStatus.OK);
       }

    }
    @GetMapping("/authenticate/client/email/{email}")
    public ResponseEntity findClientByUserEmail(@PathVariable("email") String email) {
        try{
            System.out.println("triggered2");
            return new ResponseEntity(clientService.getClientByUserEmail(email),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/signin")
    public ResponseEntity saveUser(@RequestBody User user){
        Role role=new Role(2L,"user");
        List<Role> roles=new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        try{
            userService.save(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (RuntimeException r){
            return new ResponseEntity<>(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }



}
