package capas.tareafinal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import capas.tareafinal.domain.Store;
import capas.tareafinal.repositories.SucursalRepository;

@Service
public class SucursalServiceImplementation implements SucursalService{

	@Autowired
	SucursalRepository sucRepository;
	
	@Override
	public List<Store> fetchAllStores() throws DataAccessException {
		
		return sucRepository.findAll();
	}

	@Override
	public Store findOne(Integer code) throws DataAccessException {
		return sucRepository.findById(code).get();
	}

	@Override
	public void deleteStore(Integer code) throws DataAccessException {
		Store store = findOne(code);
		sucRepository.delete(store);
	}

	@Override
	public void save(Store store) throws DataAccessException {
		sucRepository.save(store);
	}
}
