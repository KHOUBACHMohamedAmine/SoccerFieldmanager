package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;


import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Administrateur implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    @Column(nullable = false, unique = true)
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private String numtel;

    public Administrateur() {
    }

    public Administrateur(long id, String login, String password, String cin, String nom, String prenom, String sexe, String numtel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.numtel = numtel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", numtel='" + numtel + '\'' +
                '}';
    }
}
