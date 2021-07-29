package cyberlogitec.training.project.ecommerce.user.controller;

import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("")
    public List<User> getAllUser(){
        List<User> list = service.findAll();

        return list;
    }

    @PostMapping("")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors())
            return new ResponseEntity<>(errors.getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        User newUser = service.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
