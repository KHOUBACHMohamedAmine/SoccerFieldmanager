package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;


import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user Have this email: "+ email);
		} else {
			return new UserDetailsImpl(user);
		}
	}


}
