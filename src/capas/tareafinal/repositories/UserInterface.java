package capas.tareafinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import capas.tareafinal.domain.User;

public interface UserInterface extends JpaRepository<User, Integer>{

}
