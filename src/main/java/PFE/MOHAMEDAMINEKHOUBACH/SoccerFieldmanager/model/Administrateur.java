package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;


import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Administrateur extends Personnel implements Serializable {
    
    @Column( updatable = false , nullable = false)


    private String login;
    private String password;


    public Administrateur() {}

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
                "id=" + getId() +
                ", Prenom='" + this.getPrenom() + '\'' +
                ", Nom='" + this.getNom() + '\'' +
                '}';
    }

}
