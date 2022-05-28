package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")

public class User implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String email;
	private String password;
	private Boolean isEnabled = true;
	@ManyToMany
	private List<Role> roles = new ArrayList<>();

	public User() {
	}

	public User(Long id, String email, String password, Boolean isEnabled, List<Role> roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", isEnabled=" + isEnabled +
				", roles=" + roles +
				'}';
	}
}
