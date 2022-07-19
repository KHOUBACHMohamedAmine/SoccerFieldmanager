package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Repository;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepo extends JpaRepository<Employees, Long> {
    List<Employees> findByCin(String cin);




}
