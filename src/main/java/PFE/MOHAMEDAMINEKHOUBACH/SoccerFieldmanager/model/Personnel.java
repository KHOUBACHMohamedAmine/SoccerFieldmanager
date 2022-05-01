package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personnel implements Serializable {



    @Column(nullable = false, unique = true)
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private String numTel;




    public Personnel() {
    }

    public Personnel(String cin, String nom, String prenom, String sexe, String numTel) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.numTel = numTel;
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
        return numTel;
    }

    public void setNumtel(String numTel) {
        this.numTel = numTel;
    }
    @Override
    public String toString(){
        return "Personnel{" +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", sexe='" + sexe + '\'' +
                ", numtel='" + numTel + '\'' +

                '}';
    }
}
