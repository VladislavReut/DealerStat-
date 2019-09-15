package DealerStat.restControllers;

import DealerStat.domain.GameObject;
import DealerStat.domain.repository.GameObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class GameObjController {
    @Autowired
    private GameObjectRepository gameObjectRepository;

    @GetMapping("/Object")
    public String Object(Model model) {
        Iterable<GameObject> gameObject= gameObjectRepository.findAll();
        model.addAttribute("objects", gameObject);
        return "/object";
    }
    @PostMapping("/object")
    public String Object(@RequestParam String Text,
                         @RequestParam String Tag,
                         @RequestParam String Game,
                         Map<String,Object> model){
        //добавить  игровой объект пользователя
        return "main";
    }
}
