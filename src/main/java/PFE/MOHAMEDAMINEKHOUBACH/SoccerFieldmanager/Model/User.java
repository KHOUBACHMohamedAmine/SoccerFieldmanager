package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")

public class User implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String email;
	private String passwordHash;
	private Boolean isEnabled = true;
	private LocalDateTime createdAt;
	@ManyToMany
	private List<Role> roles = new ArrayList<>();

	public User() {
	}

	public User(Long id, String email, String passwordHash, Boolean isEnabled, List<Role> roles) {
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = passwordHash;
	}

	public Boolean getEnabled() {
		return isEnabled;
	}

	public void setEnabled(Boolean enabled) {
		isEnabled = enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
