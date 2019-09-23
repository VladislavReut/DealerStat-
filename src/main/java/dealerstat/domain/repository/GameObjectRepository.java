package dealerstat.domain.repository;

import dealerstat.domain.entites.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameObjectRepository extends JpaRepository <GameObject, Long> {

}
