package mykola.dev.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserDTO body){
        userService.deleteUser(body.getId());
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDTO userData) {
        userService.updateUser(userData.getId(), userData.getName(), userData.getSurname());
    }
}
