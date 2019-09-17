package DealerStat.restControllers;

import DealerStat.domain.entites.GameObject;
import DealerStat.domain.entites.User;
import DealerStat.domain.repository.GameObjectRepository;
import DealerStat.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public class GameObjController {
    @Autowired
    private GameObjectRepository gameObjectRepository;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('Trader')")
    @PutMapping("object/{id}")
    public String EditObject(@PathVariable("id") Long id, GameObject gameobject) {
        gameobject =gameObjectRepository.getOne(id);
        gameObjectRepository.save(gameobject);
        return "main";

    }
    @GetMapping("/Object")
    public String ViewObjects(Model model) {
        Iterable<GameObject> gameObject = gameObjectRepository.findAll();
        model.addAttribute("objects", gameObject);
        return "/object";
    }

    @PreAuthorize("hasRole('Trader')")
    @PostMapping("/object")
    public String AddObject(GameObject gameObject, Map<String, Object> model) {
        gameObjectRepository.save(gameObject);
        return "main";
    }

    @PreAuthorize("hasRole('Trader')")
    @GetMapping("/my")
    public String TraderObjects(@AuthenticationPrincipal User user, Model model) {

        //Iterable<GameObject> gameObjects =userRepository.findAllById() ; //(Iterable) gameObjectRepository.findByAuthor_id(user.getId());
        Iterable<GameObject> allgameObjects=gameObjectRepository.findAll();
         model.addAttribute("gameObjects", allgameObjects);
        return "my";
    }

    @PreAuthorize("hasRole('Trader')")
    @DeleteMapping("object/{objectId}")
    public String DeleteObject(@PathVariable("objectId") Long objectId, @AuthenticationPrincipal User user) {
        GameObject gameObject=gameObjectRepository.getOne(objectId);
        User Trader= gameObject.getAuthor_id();
        if(Trader.getId()==user.getId()) {
            gameObjectRepository.deleteById(objectId);
        }
        return "main";
    }


}
