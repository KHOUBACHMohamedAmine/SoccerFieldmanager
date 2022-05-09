package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;



import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;



import java.util.List;


public interface RoleService {

	Role findByTitre(String string);

	int save(Role role);

	List<Role> findAll();



}
