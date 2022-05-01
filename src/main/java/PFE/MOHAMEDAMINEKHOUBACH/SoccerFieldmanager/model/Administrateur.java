package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
public class Administrateur extends Personnel implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;


    public Administrateur() {}

    public Administrateur(String cin, String nom, String prenom, String sexe, String numtel, String login, String password) {
        super(cin, nom, prenom, sexe, numtel);
        this.login = login;
        this.password = password;
    }



    public Administrateur(String login, String password) {
        this.login = login;
        this.password = password;
    }





    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Administrateur{" +
                ", Prenom='" + this.getPrenom() + '\'' +
                ", Nom='" + this.getNom() + '\'' +
                '}';
    }

}
