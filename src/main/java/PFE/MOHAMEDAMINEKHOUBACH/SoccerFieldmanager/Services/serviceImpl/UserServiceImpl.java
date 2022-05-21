package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.UserRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.RoleService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.response.JwtResponse;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleService roleService;


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

    @Override
    public ResponseEntity save(User user) {
        JwtUtil jwtUtil= new JwtUtil();
        User founderUser = userRepo.findByEmail(user.getEmail());
        if (founderUser != null)throw new RuntimeException("Email already used !");
            else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            userRepo.save(user);
            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(user.getEmail());
            String jwt = JwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));


        }
    }

    @Override
    public void addRoletouser(String email, String role) {
        Role roles = roleService.findByTitre(role);
        User user = userRepo.findByEmail(email);
        user.getRoles().add(roles);

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public ResponseEntity<?> authenticate(User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(user.getEmail());
        String jwt = JwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

}
