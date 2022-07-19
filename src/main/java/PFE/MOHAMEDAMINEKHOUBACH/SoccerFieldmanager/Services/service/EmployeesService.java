package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.service;



import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Employees;

import java.util.List;

public interface EmployeesService {
    Employees save(Employees employees);
    List<Employees> getAllEmployees();
    List<Employees> getEmployeeByCin(String cin);
    Employees getEmployeeById(long id);
    Employees  updateEmployees (Employees  employees ,long id);
    Employees  deleteById(long id);


}
