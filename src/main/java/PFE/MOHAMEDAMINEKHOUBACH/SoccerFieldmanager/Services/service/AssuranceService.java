package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Assurance;

import java.util.List;

public interface AssuranceService {
    Assurance getAssuranceByClient_Id(long id);
    boolean verifierValabilite(Assurance assurance);

}
