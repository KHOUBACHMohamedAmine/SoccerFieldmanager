package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
}
