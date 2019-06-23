package capas.tareafinal.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import capas.tareafinal.domain.Store;

public interface SucursalService {

	public List<Store> fetchAllStores() throws DataAccessException;
}
