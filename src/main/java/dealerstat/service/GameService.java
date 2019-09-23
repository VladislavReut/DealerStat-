package dealerstat.service;

import dealerstat.domain.entites.Game;
import dealerstat.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
