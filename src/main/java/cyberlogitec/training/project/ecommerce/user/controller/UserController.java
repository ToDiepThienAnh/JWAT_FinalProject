package cyberlogitec.training.project.ecommerce.user.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.user.CreateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.RegisterDto;
import cyberlogitec.training.project.ecommerce.dto.user.UpdateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.UserWithRoleDto;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import cyberlogitec.training.project.ecommerce.utils.Domain;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping(Domain.DOMAIN_EMPLOYEE+"/user")
    public ResponseEntity<Object> findAll(){
        List<UserWithRoleDto> list = service.getUserWithRole();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping(Domain.DOMAIN_EMPLOYEE+"/user")
    public ResponseEntity<Object> addUser(@Valid @RequestBody CreateUserDto user, BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        User newUser = service.save(user);
        return ResponseObject.getResponse(newUser, HttpStatus.CREATED);
    }

    @PutMapping(Domain.DOMAIN_USER+"/user/{username}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UpdateUserDto user,
                                             BindingResult errors,
                                             @PathVariable("username") String username){
        if(username == null || username.equals(""))
            return ResponseObject.getResponse("username can not be blank", HttpStatus.BAD_REQUEST);
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        User userUpdate = service.update(user, username);
        return ResponseObject.getResponse(userUpdate, HttpStatus.OK);
    }

    @DeleteMapping(Domain.DOMAIN_EMPLOYEE+"/user/{username}")
    public ResponseEntity<Object> deleteByUsername(
                                             BindingResult errors,
                                             @PathVariable("username") String username){
        if(username == null || username.equals(""))
            return ResponseObject.getResponse("username can not be blank", HttpStatus.BAD_REQUEST);
        service.deleteByUsername(username);
        return ResponseObject.getResponse("delete successfully", HttpStatus.OK);
    }
}
