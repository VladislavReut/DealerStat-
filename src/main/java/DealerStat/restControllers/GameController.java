package DealerStat.restControllers;

import DealerStat.domain.entites.Game;
import DealerStat.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
   private GameRepository gameRepository;

    @GetMapping("/games")
    public String AllGames(Model model) {
        Iterable<Game> game = gameRepository.findAll();
        model.addAttribute("games", game);
        return "games";
    }
    @PreAuthorize("hasRole('Trader')")
    @PostMapping("/games")
    public String AddGame(@RequestParam String name, Model model) {
        Game game = new Game(name);
        gameRepository.save(game);
        return "main";
    }
}