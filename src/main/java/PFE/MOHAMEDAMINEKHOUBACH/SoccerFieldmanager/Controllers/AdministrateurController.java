package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.AdminService;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Administrateur;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.model.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/admin")
public class AdministrateurController {

    private final AdminService  adminService;
    @Autowired
    public AdministrateurController(AdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping
    public List<Personnel> getAdmins(){
        return adminService.getAdmins();
    }

}
