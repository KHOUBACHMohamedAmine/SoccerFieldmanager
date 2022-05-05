package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Assurance;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Reservation;

import java.util.Date;
import java.util.List;

public interface AssuranceService {
    Assurance getAssuranceByClient_Cin(String cin);
    boolean verifierAssuranceByClient_Cin( String cin);
    boolean verifierValabilite(Date dateExpirationAssurance, Date dateReservation);

}
