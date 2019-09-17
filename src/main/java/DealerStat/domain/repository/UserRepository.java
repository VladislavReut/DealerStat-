package DealerStat.domain.repository;

import DealerStat.domain.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByLastnameAndFirstname(String LastName, String FirstName);
    User findByUsername(String username);
}
