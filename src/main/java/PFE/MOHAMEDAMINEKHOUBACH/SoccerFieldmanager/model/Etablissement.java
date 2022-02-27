package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Etablissement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
    private String nom;
    private String reference;

    public Etablissement() {}

    public Etablissement(String nom, String reference) {
        this.nom = nom;
        this.reference = reference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString(){
        return "Etablissement{" +
                "id=" +id +
                ", nom='" + nom + '\'' +
                ", reference='" + reference + '\'' +

                '}';
    }
}
