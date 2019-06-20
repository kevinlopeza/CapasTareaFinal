package capas.tareafinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import capas.tareafinal.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
