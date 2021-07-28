package cyberlogitec.training.project.ecommerce.user.controller;

import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("")
    public List<User> getAllUser(){
        List<User> list = service.getAllUser();

        return list;
    }

    @PostMapping("")
    public User addUser(@RequestBody User user){
        User newUser = service.save(user);
        return newUser;
    }
}
