package dealerstat.restсontrollers;

import dealerstat.domain.entites.GameObject;
import dealerstat.domain.entites.User;
import dealerstat.domain.repository.GameObjectRepository;
import dealerstat.service.GameObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public class GameObjController {
    @Autowired
    private GameObjectService gameObjectService;

    @PreAuthorize("hasRole('Trader')")
    @PutMapping("object/{id}")
    public String EditObject(@PathVariable("id") Long objectID, GameObject gameobject) {
        return gameObjectService.EditObject(objectID, gameobject);
    }

    @GetMapping("/Object")
    public String ViewObjects(Model model) {
        return gameObjectService.ViewObjects(model);
    }

    @PreAuthorize("hasRole('Trader')")
    @PostMapping("/object")
    public String AddObject(GameObject gameObject, Map<String, Object> model) {
        return gameObjectService.AddObject(gameObject, model);
    }

    @PreAuthorize("hasRole('Trader')")
    @GetMapping("/my")
    public String TraderObjects(@AuthenticationPrincipal User user, Model model) {
        return gameObjectService.TraderObjects(user, model);
    }

    @PreAuthorize("hasRole('Trader')")
    @DeleteMapping("object/{objectId}")
    public String DeleteObject(@PathVariable("objectId") Long objectID,
                               @AuthenticationPrincipal User user) {
        return gameObjectService.DeleteObject(objectID, user);
    }
}
