package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class User {
    private Repositories.User userRepository;

    @PostMapping(path = "/addUser")
    public @ResponseBody String addUser(@RequestParam String name,@RequestParam String email) {
        Models.User user = new Models.User(name, email);
        userRepository.save(user);
        return "User saved.";
    }
    @GetMapping(path = "/users")
    public Iterable<Models.User> getUsers() {
        return userRepository.findAll();
    }

}
