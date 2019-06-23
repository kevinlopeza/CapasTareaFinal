package capas.tareafinal.service;

import org.springframework.dao.DataAccessException;

import capas.tareafinal.domain.User;

public interface UserService {

	public User verifyCredentials(String username, String password) throws DataAccessException;
	
}
