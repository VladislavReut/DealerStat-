package dealerstat.service;

import dealerstat.domain.entites.GameObject;
import dealerstat.domain.entites.User;
import dealerstat.domain.repository.GameObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;
@Service
public class GameObjectService {
    @Autowired
    private GameObjectRepository gameObjectRepository;

public String EditObject(Long id, GameObject gameobject) {
    gameobject =gameObjectRepository.getOne(id);
    gameObjectRepository.save(gameobject);
    return "main";
}

    public String ViewObjects(Model model) {
        Iterable<GameObject> gameObject = gameObjectRepository.findAll();
        model.addAttribute("objects", gameObject);
        return "/object";
    }

    public String AddObject(GameObject gameObject, Map<String, Object> model) {
        gameObjectRepository.save(gameObject);
        return "main";
    }

    public String TraderObjects(User user, Model model) {
        Iterable<GameObject> allgameObjects=gameObjectRepository.findAll();
        model.addAttribute("gameObjects", allgameObjects);
        return "my";
    }

    public String DeleteObject(Long objectId, User user) {
        GameObject gameObject=gameObjectRepository.getOne(objectId);
        User Trader= gameObject.getAuthor_id();
        if(Trader.getId()==user.getId()) {
            gameObjectRepository.deleteById(objectId);
        }
        return "main";
    }
}
