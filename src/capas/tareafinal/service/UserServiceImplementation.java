package capas.tareafinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capas.tareafinal.domain.User;
import capas.tareafinal.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository uRepo;

	@Override
	public User verifyCredentials(String username, String password) {
		return uRepo.findFirstByUsernameAndPassword(username, password);
	}

}
