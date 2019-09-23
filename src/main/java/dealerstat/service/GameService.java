package dealerstat.service;

import dealerstat.domain.entites.Game;
import dealerstat.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public String AllGames(Model model) {
        Iterable<Game> game = gameRepository.findAll();
        model.addAttribute("games", game);
        return "games";
    }

    public String AddGame(Game game) {
        gameRepository.save(game);
        return "main";
    }
}
