package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table
@Entity
public class Reservation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
    private String reference;
    private Date date;

    @ManyToOne
    private Client client;
    @OneToOne
    private Terrain terrain;



    public Reservation() {}

    public Reservation(long id, String reference, Date date) {
        this.id = id;
        this.reference = reference;
        this.date = date;

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

    public Date getDate_reservation() {
        return date;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString(){
        return "Reservation{" +
                "id=" +id +
                ", date ='" + date + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
