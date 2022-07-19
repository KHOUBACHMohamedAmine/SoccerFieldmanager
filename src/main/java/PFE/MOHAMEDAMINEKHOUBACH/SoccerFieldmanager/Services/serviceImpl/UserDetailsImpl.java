package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;


import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Client;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class 	UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8058788930038933670L;
	private User user;
	public ClientServiceImpl clientService;

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getTitre())));
		return authorities;
	}

	public Client getUserClient(String email){

		return this.clientService.getClientByUserEmail(email);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}

}
