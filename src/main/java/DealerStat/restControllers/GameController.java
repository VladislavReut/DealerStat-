package DealerStat.restControllers;

import DealerStat.domain.Game;
import DealerStat.domain.GameObject;
import DealerStat.domain.repository.GameObjectRepository;
import DealerStat.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GameController {
    @Autowired
    GameRepository gameRepository;

    @GetMapping("/Games")
    public String Games(Model model) {
        Iterable<Game> game= gameRepository.findAll();
model.addAttribute("games", game);
return "games";
    }

}