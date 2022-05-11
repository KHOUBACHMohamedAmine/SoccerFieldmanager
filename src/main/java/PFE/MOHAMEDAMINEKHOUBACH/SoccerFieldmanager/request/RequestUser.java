package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.request;



import java.util.Set;


public class RequestUser {

	private String email;

	private String password;

	private Boolean isEnabled;

	private Set<String> roles;

	public String getEmail() {
		return email;
	}

	public RequestUser(String email, String password, Boolean isEnabled, Set<String> roles) {
		this.email = email;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return isEnabled;
	}

	public void setEnabled(Boolean enabled) {
		isEnabled = enabled;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
