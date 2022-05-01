package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
/**
Il n y a pas besoin de d'ajouter l'annotation @Table
à partir de @Entity JPA ce charge de mapper la class en une table dans la base de données
 */
// @Table
public class Terrain implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reference;
    private String etat;

    public Terrain() {
    }

    public Terrain(long id, String reference, String etat) {
        this.id = id;
        this.reference = reference;
        this.etat = etat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
