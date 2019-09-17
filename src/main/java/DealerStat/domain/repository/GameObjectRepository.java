package DealerStat.domain.repository;

import DealerStat.domain.entites.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameObjectRepository extends JpaRepository <GameObject, Long> {
    GameObject findByAuthor_id(Long id);
}
