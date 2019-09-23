package dealerstat.restсontrollers;

import dealerstat.domain.entites.Game;
import dealerstat.service.GameService;
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
    GameService gameService;

    @GetMapping("/games")
    public String AllGames(Model model) {
     return gameService.AllGames(model);
    }

    @PreAuthorize("hasRole('Trader')")
    @PostMapping("/games")
    public String AddGame(@RequestParam Game game) {
        return gameService.AddGame(game);
    }
}