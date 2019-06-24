package capas.tareafinal.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import capas.tareafinal.domain.Store;

public interface SucursalService {

	public List<Store> fetchAllStores() throws DataAccessException;

	public Store findOne(Integer code) throws DataAccessException;

	public void deleteStore(Integer code) throws DataAccessException;

	public void save(Store store) throws DataAccessException;
}
