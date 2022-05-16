package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception.UserNotFoundHttpException;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserServiceImpl;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.security.LoginDTO;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.security.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws UserNotFoundHttpException {
        Token token = userService.login(loginDTO);
        return toResponse(token);

    }
    private ResponseEntity toResponse(Token token) {
        return ok(Collections.singletonMap("token", token));
    }
}
