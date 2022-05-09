package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "role")
public class Role implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titre")
	private String titre;

	public Role(String titre) {
		super();
		this.titre = titre;
	}

    public Role() {
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	

}
