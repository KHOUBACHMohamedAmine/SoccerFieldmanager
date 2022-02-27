package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Client  extends Personnel implements Serializable  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private long id;
    private long numapogee;
    private String date_creation_du_compte;
    private String login;
    private String password;


    public Client() {}
    public Client(long numapogee, String date_creation_du_compte, String login, String password) {
        this.numapogee = numapogee;
        this.date_creation_du_compte = date_creation_du_compte;
        this.login = login;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumapogee() {
        return numapogee;
    }

    public void setNumapogee(long numapogee) {
        this.numapogee = numapogee;
    }

    public String getDate_creation_du_compte() {
        return date_creation_du_compte;
    }

    public void setDate_creation_du_compte(String date_creation_du_compte) {
        this.date_creation_du_compte = date_creation_du_compte;
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
        return "Client{" +
                "id=" +id +
                ", numapogee='" + numapogee + '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                ", nom='" + this.getNom() + '\'' +
                '}';
    }
}
