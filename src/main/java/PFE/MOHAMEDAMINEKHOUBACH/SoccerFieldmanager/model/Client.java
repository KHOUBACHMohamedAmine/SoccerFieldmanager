package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Client implements Serializable  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private String numtel;
    private long numapogee;
    private String login;
    private String password;
    private String etablissement;


    public Client() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public long getNumapogee() {
        return numapogee;
    }

    public void setNumapogee(long numapogee) {
        this.numapogee = numapogee;
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

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    /*
    La class ne contient que les attributs les constructeurs, les getteres et les setters et la méthode toString, et equals and hashCode
     */

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", numtel='" + numtel + '\'' +
                ", numapogee=" + numapogee +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", etablissement='" + etablissement + '\'' +
                '}';
    }
 /*   public boolean verifierAssurance(){
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
    }*/
}
