package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.RoleRepo;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   private  final UserRepo userRepo;
   private  final RoleService roleService;
   private final RoleRepo roleRepo;
 @Autowired
 private AuthenticationManager authenticationManager;

 @Autowired
 private PasswordEncoder passwordEncoder;

 @Autowired
 private UserDetailsServiceImpl userDetailsServiceImpl;


 @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleService roleService, RoleRepo roleRepo) {
        this.userRepo = userRepo;
  this.roleService = roleService;
  this.roleRepo = roleRepo;
 }


 @Override
 public User save(User user) {
  return userRepo.save(user);
 }

 @Override
 public List<User> getAllUsers() {
  return userRepo.findAll();
 }

 @Override
 public User getUserById(long id) {
  return userRepo.findById(id).orElseThrow(()-> new RessourceNotFound("User","Id",id));
 }

 @Override
 public User updateUser(User user, long id) {
  User existingUser = userRepo.findById(id).orElseThrow(
          () -> new RessourceNotFound("User", "Id", id));

  existingUser.setNom(user.getNom());
  existingUser.setPrenom(user.getPrenom());
  existingUser.setCin(user.getCin());
  existingUser.setEtablissement(user.getEtablissement());
  existingUser.setNumtel(user.getNumtel());
  existingUser.setNumapogee(user.getNumapogee());
  existingUser.setSexe(user.getSexe());
  existingUser.setLogin(user.getLogin());
  existingUser.setPassword(user.getPassword());
  userRepo.save(existingUser);
  return existingUser;
 }

 @Override
 public void deleteById(long id) {
  userRepo.findById(id).orElseThrow(() -> new RessourceNotFound("User", "Id", id));
  userRepo.deleteById(id);
 }

 @Override
 public List<User> getUserByCin(String cin) {
     List<User> clientsfounded=new ArrayList<User>(userRepo.findByCin(cin));
  if (clientsfounded.isEmpty()) throw new RessourceNotFound("User","Cin",cin);
  else return clientsfounded ;
 }

 @Override
 public List<User> getUserBySexe(String sexe) {
  List<User> clientsfounded=new ArrayList<User>(userRepo.findBySexe(sexe));
  if (clientsfounded.isEmpty()) throw new RessourceNotFound("User","Sexe",sexe);
  else return clientsfounded ;
 }

 @Override
 public List<User> getUserByEtablissement(String etablissement) {
     List<User> users=new ArrayList<User>(userRepo.findByEtablissement(etablissement));
     if (users.isEmpty()) throw new RessourceNotFound("User","Etablissement",etablissement);
     else return users ;
 }

 @Override
 public User getUserByLogin(String login) {
  return userRepo.findByLogin(login);
 }

 @Override
 public void addRoletoUser(String login, String role) {
  Role roles = roleService.findByTitre(role);
  User user = userRepo.findByLogin(login);
  user.setRoles(roles);
 }
 @Override
 public ResponseEntity<?> authenticate(User user) {
  Authentication authentication = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
  SecurityContextHolder.getContext().setAuthentication(authentication);
  UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(user.getLogin());
  String jwt = JwtUtil.generateToken(userDetails);
  return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
 }



}
