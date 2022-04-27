package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Table
@Entity
public class Reservation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
    private String reference;
    private String date_reservation;
    private int num_terrain;
    @ManyToOne
    private Client client;
    @OneToOne
    private Terrain terrain;



    public Reservation() {}

    public Reservation(long id, String reference, String date_reservation, int num_terrain) {
        this.id = id;
        this.reference = reference;
        this.date_reservation = date_reservation;
        this.num_terrain = num_terrain;
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

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getNum_terrain() {
        return num_terrain;
    }

    public void setNum_terrain(int num_terrain) {
        this.num_terrain = num_terrain;
    }
    @Override
    public String toString(){
        return "Reservation{" +
                "id=" +id +
                ", date reservation='" + date_reservation + '\'' +
                ", reference='" + reference + '\'' +
                ", num terrain ='" + num_terrain + '\'' +
                '}';
    }
}
