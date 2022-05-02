package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Assurance implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private int num;
    private Date date_expiration;

    @OneToOne
    private Client client;


    public Assurance(int num, Date date_expiration) {
        this.num = num;
        this.date_expiration = date_expiration;
    }

    public Assurance() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    @Override
    public String toString() {
        return "Assurance{" +
                "id=" + id +
                ", num=" + num +
                ", date_expiration=" + date_expiration +
                ", client=" + client +
                '}';
    }
}
