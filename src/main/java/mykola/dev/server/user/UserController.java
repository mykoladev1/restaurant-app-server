package mykola.dev.server.user;

import mykola.dev.server.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Optional<User> getUser(@RequestBody UserDTO userData) {return userService.getUser(userData.getId());}

    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/add")
    public void registerNewUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userService.deleteUser(UUID.fromString(id));
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDTO userData) {
        userService.updateUser(userData.getId(), userData.getName(), userData.getSurname());
    }
}
