package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Terrain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private long id;
    private String reference;
    private String etat;

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
