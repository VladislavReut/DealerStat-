package DealerStat.domain.repository;

import DealerStat.domain.entites.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Long> {

}
