package usa.ciclo4.reto1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.ciclo4.reto1.model.User;
import usa.ciclo4.reto1.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/{email}/{password}")
    public User userAutentication(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.userAutentication(email, password);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return userService.existEmail(email);
    }

}
