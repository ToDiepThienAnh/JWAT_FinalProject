package cyberlogitec.training.project.ecommerce.user.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.service.RoleService;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {
    private RoleService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<Role> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@Valid @RequestBody RoleDto dto,
                                      BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Role role = service.save(dto);
        return ResponseObject.getResponse(role, HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Object> updateRole(@Valid @RequestBody RoleDto dto,
                                             @PathVariable("name") String roleName,
                                             BindingResult errors){
        if(roleName == null || roleName.equals(""))
            return ResponseObject.getResponse("roleName is invalid", HttpStatus.BAD_REQUEST);
        Role roleUpdate = service.updateRole(dto, roleName);
        if(roleUpdate == null)
            return ResponseObject.getResponse("role is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(roleUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Object> deleteByName(@PathVariable("name") String name){
        if(name == null || name.equals(""))
            return ResponseObject.getResponse("role name is invalid", HttpStatus.BAD_REQUEST);
        Role role = service.deleteByName(name);
        return ResponseObject.getResponse(role, HttpStatus.BAD_REQUEST);
    }
}
