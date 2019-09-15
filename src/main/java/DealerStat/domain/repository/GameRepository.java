package DealerStat.domain.repository;

import DealerStat.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Long> {

}
