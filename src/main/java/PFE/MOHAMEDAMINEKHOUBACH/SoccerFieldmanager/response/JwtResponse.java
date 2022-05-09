package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
	private String token;
	private String login;
	private String type = "Bearer ";
	private Collection<? extends GrantedAuthority> authority;
	
	
	

	public JwtResponse(String token, String login, Collection<? extends GrantedAuthority> authority) {
		super();
		this.token = token;
		this.login = login;
		this.authority = authority;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String email) {
		this.login = login;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}

	

}
