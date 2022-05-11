package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Role;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.RoleRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepo roleRepo;

	@Override
	public int save(Role role) {
		Role loadedRole = roleRepo.findByTitre(role.getTitre());
		if (loadedRole != null) {
			return 0;
		} else {
			roleRepo.save(role);
			return 1;
		}
	}

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findByTitre(String titre) {
		return roleRepo.findByTitre(titre);
	}




}
