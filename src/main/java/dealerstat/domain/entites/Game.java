package dealerstat.domain.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Game {
    @Id
private Long id;
private String name;

    public Game() {
    }

    public Game(String name) {
        this.name = name;
    }
}
