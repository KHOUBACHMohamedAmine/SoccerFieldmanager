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
    public Assurance getAssuranceByClient_Id(long id) {
        Assurance assurance = assuranceRepo.findByClient_Id(id);
        if (assurance!=null) return assurance;
        else throw new RuntimeException("Client non assuré ");
    }

    @Override
    public boolean verifierValabilite(Assurance assurance) {
        Date date=new Date();
        if (assurance.getDate_expiration().before(date)) return true;
        else return false;

    }
}
