package coderhouse.entrega03.controllers;
import coderhouse.entrega03.models.userModel;
import coderhouse.entrega03.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private userRepository repo;

    @GetMapping("users")
    public List<userModel> getUsers(){
        return repo.findAll();
    }

    @PostMapping("users")
    public String addUser(@RequestBody userModel user){
        repo.save(user);
        return "User saved";
    }

    @PutMapping("users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody userModel user)
    {
        userModel foundUser = repo.findById(id).get();
        foundUser.setName(user.getName());
        foundUser.setEmail(user.getEmail());
        repo.save(foundUser);
        return "User modified.";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        repo.deleteById(id);
        return "User deleted.";
    }
}
