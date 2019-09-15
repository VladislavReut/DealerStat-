package DealerStat.domain.repository;

import DealerStat.domain.GameObject;
import org.springframework.data.repository.CrudRepository;

public interface GameObjectRepository extends CrudRepository <GameObject, Long> {
}
