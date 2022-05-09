package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.request;



import java.util.Set;


public class RequestUser {


	public RequestUser(String login, String password, Boolean isEnabled, Set<String> roles) {
		this.login = login;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public RequestUser() {
	}

	private String login;

	private String password;

	private Boolean isEnabled;

	private Set<String> roles;

	public String getLogin() {
		return login;
	}

}
