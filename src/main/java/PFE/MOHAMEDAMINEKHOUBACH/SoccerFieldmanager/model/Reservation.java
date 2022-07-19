package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    private int hour;
    private int status;

    @ManyToOne
    private Client client;
    @OneToOne
    private Terrain terrain;



    public Reservation() {}

    public Reservation(String reference, Date date, int hour, int status, Client client, Terrain terrain) {
        this.reference = reference;
        this.date = date;
        this.hour = hour;
        this.status = status;
        this.client = client;
        this.terrain = terrain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHour() {return hour;}

    public void setHour(int hour) {this.hour = hour;}

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date= date;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
