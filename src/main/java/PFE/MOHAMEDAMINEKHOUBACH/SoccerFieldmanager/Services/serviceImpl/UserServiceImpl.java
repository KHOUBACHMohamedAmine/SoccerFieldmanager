package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception.PasswordsDontMatchException;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception.UserAlreadyExistsHttpException;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception.UserNotFoundHttpException;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.UserRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.RoleService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserDetailsServiceImpl;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.response.JwtResponse;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleService roleService;
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    @Transactional
    public User register(SignUpDTO signUpDTO) throws UserAlreadyExistsHttpException {
        if (!signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword())) {
            throw new PasswordsDontMatchException();
        }

        String email = signUpDTO.getEmail();

        if (userRepo.findByEmail(email)!=null) {
            throw new UserAlreadyExistsHttpException(email);
        }

        User user = signUpUser(signUpDTO);

        return userRepo.save(user);
    }
    private User signUpUser(SignUpDTO signUpDTO) {
        User user = new User();
        user.setEmail(signUpDTO.getEmail());
        user.setEmail(signUpDTO.getFullName());

        String encodedPassword = encodePassword(signUpDTO.getPassword());
        user.setPasswordHash(encodedPassword);
        user.setRoles((List<Role>) new HashSet<Role>(Collections.singletonList(roleService.getDefaultRole())));
        return user;
    }
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }



    private Authentication createAuthentication(LoginDTO loginDTO) {
        return new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
    }
    @Override
    public Token login(LoginDTO loginDTO) throws UserNotFoundHttpException {
        try {
            Authentication authentication = createAuthentication(loginDTO);
            BundleUserDetailsService.BundleUserDetails userDetails =
                    (BundleUserDetailsService.BundleUserDetails) authenticationManager
                            .authenticate(authentication).getPrincipal();
            User user = userDetails.getUser();

            return createToken(user);
        } catch (AuthenticationException exception) {
            throw new UserNotFoundHttpException("Incorrect email or password", HttpStatus.FORBIDDEN);
        }
    }
    private Token createToken(User user) {
        return tokenService.createToken(user);
    }
    @Override
    public void addRoletouser(String email, String role) {
        Role roles = roleService.findByTitre(role);
        User user = userRepo.findByEmail(email);
        user.getRoles().add(roles);

    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }


}
