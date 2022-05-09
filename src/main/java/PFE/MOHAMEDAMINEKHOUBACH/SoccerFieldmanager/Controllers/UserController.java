package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:8090"})
@RequestMapping("/api/v1/users")
public class UserController {
    private UserServiceImpl userServiceImpl;
    private UserService userService;

    public UserController(UserServiceImpl userServiceImpl, UserService userService) {
        this.userServiceImpl = userServiceImpl;
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userServiceImpl.save(user),HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<User> getAllUsers(){
        return  userServiceImpl.getAllUsers();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){

        try{
            return new ResponseEntity(userServiceImpl.getUserById(id),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/sexe/{sexe}")
    public ResponseEntity getUserBySexe(@PathVariable("sexe") String sexe){
        try{
            return new ResponseEntity(userServiceImpl.getUserBySexe(sexe),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity getUserByCin(@PathVariable("cin") String cin){
        try{
            return new ResponseEntity(userServiceImpl.getUserByCin(cin),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/etablissement/{etablissement}")
    public ResponseEntity getUserByEtablisssement(@PathVariable("etablissement") String etablissement){
        try{
            return new ResponseEntity(userServiceImpl.getUserByEtablissement(etablissement),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
     @PutMapping("/update/id/{id}")
    public ResponseEntity updateUser(@PathVariable("id") long id,@RequestBody User user){
        try {
            userServiceImpl.updateUser(user,id);
            return new ResponseEntity(user,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

     }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id){
       try{
           userServiceImpl.deleteById(id);
           return new ResponseEntity<String>("User deleted Succesfully",HttpStatus.OK);
       }catch (RessourceNotFound r){
           return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
       }


     }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        return userService.authenticate(user);
    }

}
