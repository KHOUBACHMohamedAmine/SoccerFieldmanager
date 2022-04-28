package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Client  extends Personnel implements Serializable  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long numapogee;
    private String login;
    private String password;
    private String etablissement;

    @OneToOne
    private Assurance assurance;


    public Client() {}

    public Client(String cin, String nom, String prenom, String sexe, String numtel, long numapogee, String login, String password, String etablissement,Assurance assurance) {
        super(cin, nom, prenom, sexe, numtel);
        this.assurance=assurance;
        this.numapogee = numapogee;
        this.login = login;
        this.password = password;
        this.etablissement = etablissement;
    }


    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumapogee() {
        return numapogee;
    }

    public void setNumapogee(long numapogee) {
        this.numapogee = numapogee;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Client{" +
                "id=" +id +
                ", numapogee='" + numapogee + '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                ", nom='" + this.getNom() + '\'' +
                '}';
    }
    public boolean verifierAssurance(){
        Date now = new Date();
        return this.assurance.getDate_expiration().after(now);

    }
    public static Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
    public static void main(String[] args) {

        Date date;
        Assurance assurance=new Assurance(1, date = StringToDate("2022-04-28 20:03:00"));
        Client client=new Client( "JH66346", "Mohamed", "Khoubach", "male", "0623598522",1002,"admin","admin","ESTK",assurance);
        System.out.println(client.verifierAssurance());
    }
}
