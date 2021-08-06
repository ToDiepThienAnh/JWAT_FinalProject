package cyberlogitec.training.project.ecommerce.security.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.user.RegisterDto;
import cyberlogitec.training.project.ecommerce.security.dto.Jwt;
import cyberlogitec.training.project.ecommerce.security.dto.LoginDto;
import cyberlogitec.training.project.ecommerce.security.jwt.JwtHandle;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtHandle jwtHandle;
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto login,
                                        BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse("Username or password is invalid", HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtHandle.generateJwtToken(authentication);
        Jwt jwt = new Jwt();
        jwt.setJwt(jwtToken);
        return new ResponseObject().getResponse(jwt, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDto user,
                                           BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        User register = service.save(user);
        return ResponseObject.getResponse(register, HttpStatus.CREATED);
    }
}
