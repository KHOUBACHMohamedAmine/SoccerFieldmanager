package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdministrateurController {

    private final AdminServiceImpl adminService;
    @Autowired
    public AdministrateurController(AdminServiceImpl adminService){
        this.adminService = adminService;
    }
   /* @GetMapping
    public List<Personnel> getAdmins(){
        return adminService.getAdmins();
    }*/

}
