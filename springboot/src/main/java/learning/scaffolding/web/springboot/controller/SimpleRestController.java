package learning.scaffolding.web.springboot.controller;

import learning.scaffolding.web.springboot.models.User;
import learning.scaffolding.web.springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class SimpleRestController {

    private final UserRepository userRepository;

    public SimpleRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public User getUser(@RequestParam(name = "id") int id) {
        return  userRepository.findById(id).orElse(new User());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam(name = "id") int id) {
        try {
            userRepository.deleteById(id);
        }
        catch (Exception e) {
            return "Error occurred when trying to delete the user";
        }
         return "User Deleted";
    }
}
