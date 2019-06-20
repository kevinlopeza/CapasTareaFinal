package capas.tareafinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import capas.tareafinal.domain.Employee;
import capas.tareafinal.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	EmployeeRepository eRepo;
	
	@Override
	public List<Employee> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.findAll();
	}

	@Override
	public Employee findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.findById(code).get();
	}

	@Override
	public Employee save(Employee e) throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.save(e);
	}

}
