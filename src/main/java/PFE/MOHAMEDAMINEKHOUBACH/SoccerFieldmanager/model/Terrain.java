package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reference;
    private String etat;

    public Terrain(String reference, String etat) {
        super();
        this.reference = reference;
        this.etat = etat;
    }

    public Terrain() {}

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
    public String toString(){
        return "Terrain{" +
                "id=" +id +
                ", etat='" + etat + '\'' +
                ", reference='" + reference + '\'' +

                '}';
    }
}
