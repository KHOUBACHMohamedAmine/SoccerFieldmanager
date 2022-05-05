package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Assurance;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.AssuranceRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssuranceServiceImpl implements AssuranceService {
    private  final AssuranceRepo assuranceRepo;

    @Autowired
    public AssuranceServiceImpl(AssuranceRepo assuranceRepo) {
        this.assuranceRepo = assuranceRepo;
    }

    @Override
    public Assurance getAssuranceByClient_Cin(String cin) {
        Assurance assurance = assuranceRepo.findByClient_Cin(cin);
        if (assurance!=null) return assurance;
        else {
            throw new RuntimeException("Client non assuré");
        }

    }

    @Override
    public boolean verifierAssuranceByClient_Cin(String cin) {
        Assurance assurance = assuranceRepo.findByClient_Cin(cin);
        if (assurance!=null) return true;
        else {
            return false;
        }
    }

    @Override
    public boolean verifierValabilite(Date dateExpirationAssurance, Date dateReservation) {

        if (dateExpirationAssurance.compareTo(dateReservation)>0) {
            return true;
        }
        else {
            return false;
        }

    }
}
