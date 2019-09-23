package dealerstat.domain.repository;

import dealerstat.domain.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
}
