package capas.tareafinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import capas.tareafinal.domain.Store;

@Repository
public interface SucursalRepository extends JpaRepository<Store, Integer>{
	
}
