package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

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
    // private String date_reservation;
    /**
     * Pour les nom des variables il est préférable de les écrire 'camelCase'
     * et la date doit etre de type DATE
     */
    private Date dateReservation;

    /**
    Un client peut effectuer plusieur réservation
    Une réservation peut etre effectuer par un seul client donc l'anottation utilisé ici c'est OneToOne
     */
    // @ManyToOne
    @OneToOne
    private Client client;
    @OneToOne
    private Terrain terrain;


    public Reservation() {}

    public Reservation(long id, String reference, Date dateReservation, Client client, Terrain terrain) {
        this.id = id;
        this.reference = reference;
        this.dateReservation = dateReservation;
        this.client = client;
        this.terrain = terrain;
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

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
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
}
