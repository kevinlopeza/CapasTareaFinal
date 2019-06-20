package capas.tareafinal.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import capas.tareafinal.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAll() throws DataAccessException;
	
	public Employee findOne(Integer code) throws DataAccessException;
	
	public Employee save(Employee e) throws DataAccessException;
}
