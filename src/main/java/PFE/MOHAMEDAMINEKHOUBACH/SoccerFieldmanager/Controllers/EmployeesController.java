package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Controllers;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Employees;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.EmployeesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200"})
@RequestMapping("/api/v1/employees")
public class EmployeesController {
    private final EmployeesServiceImpl empServiceImpl;


    public EmployeesController(EmployeesServiceImpl empServiceImpl) {
        super();
        this.empServiceImpl = empServiceImpl;
    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity getClientByCin(@PathVariable("cin") String cin){

        try{
            System.out.println("triggered");
            return new ResponseEntity(empServiceImpl.getEmployeeByCin(cin),HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/")
    public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees){
        return new ResponseEntity<>(empServiceImpl.save(employees), HttpStatus.CREATED);
    }
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/")
    public List<Employees> getAllEmployees(){
        return  empServiceImpl.getAllEmployees();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employees> getEmployeesById(@PathVariable("id") long id){
        try{
            Employees employeesfounded = empServiceImpl.getEmployeeById(id);
            return new ResponseEntity(employeesfounded,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    //   @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/id/{id}")
    public ResponseEntity updateEmployees(@PathVariable("id") long id,@RequestBody Employees employees){
        try {
            Employees empfounded= empServiceImpl.updateEmployees(employees,id);
            return new ResponseEntity(empfounded,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    //   @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable("id") Long id){
        try {
            Employees employees =empServiceImpl.deleteById(id);
            return new ResponseEntity<>(employees,HttpStatus.OK);
        }catch (RessourceNotFound r){
            return new ResponseEntity(r.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}

