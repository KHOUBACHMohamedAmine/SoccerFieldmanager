package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
	private String token;
	private String email;
	private String type = "Bearer ";
	private Collection<? extends GrantedAuthority> authority;
	
	
	

	public JwtResponse(String token, String email, Collection<? extends GrantedAuthority> authority) {
		super();
		this.token = token;
		this.email = email;
		this.authority = authority;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
