package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.RessourceNotFound;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Employees;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository.EmployeesRepo;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeesServiceImpl implements EmployeesService {
    private  final EmployeesRepo empRepo;


    @Autowired
    public EmployeesServiceImpl(EmployeesRepo empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public Employees save(Employees employees) {
        return empRepo.save(employees);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employees getClientById(long id) {
        return empRepo.findById(id).orElseThrow(()-> new RessourceNotFound("Employee","Id",id));
    }

    @Override
    public Employees updateEmployees(Employees employees, long id) {
        Employees existingEmp = empRepo.findById(id).orElseThrow(
                () -> new RessourceNotFound("Employee", "Id", id));

        existingEmp.setCin(employees.getCin());
        existingEmp.setNom(employees.getNom());
        existingEmp.setNumtel(employees.getNumtel());
        existingEmp.setPoste(employees.getPoste());
        existingEmp.setPrenom(employees.getPrenom());
        existingEmp.setSexe(employees.getSexe());

        empRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    public Employees deleteById(long id) {
        Employees employees = empRepo.findById(id).orElseThrow(() ->
                new RessourceNotFound("Employee", "Id", id));

        empRepo.deleteById(id);
        return employees;
    }

    public Employees getEmployeeById(Long id) {
       return empRepo.getById(id);
    }
}
