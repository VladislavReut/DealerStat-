package Hello;
import Hello.HelloDB.User;
import Hello.HelloDB.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    public class GreetingController {

    @Autowired
    private UserRepository programRepository;

    @GetMapping(value = "/greeting")
    public String greeting(Model model) {
        Iterable<User> all = programRepository.findAll();

        model.addAttribute("messages", all);
        return "greeting";
    }
}