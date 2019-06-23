package capas.tareafinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capas.tareafinal.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findFirstByUsernameAndPassword(String username, String password);
		
}
