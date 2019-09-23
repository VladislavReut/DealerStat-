package dealerstat.domain.repository;

import dealerstat.domain.entites.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Long> {

}
