package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Administrateur;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Personnel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {
    public List<Personnel> getAdmins(){
        return List.of(
                new Administrateur(
                        "JH66346",
                        "Mohamed",
                        "Khoubach",
                        "male",
                        "0623598522","admin","admin")
        );
    }
}
