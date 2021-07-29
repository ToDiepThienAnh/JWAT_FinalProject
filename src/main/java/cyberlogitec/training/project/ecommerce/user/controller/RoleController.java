package cyberlogitec.training.project.ecommerce.user.controller;

import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
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
    public List<Role> findAll(){
        List<Role> list = service.findAll();
        return list;
    }

    @GetMapping("/mybatis/test")
    public List<RoleDto> findAllRole(){
        List<RoleDto> list = service.findAllRole();
        return list;
    }

    @PostMapping("")
    public Role addRole(@Valid @RequestBody Role role){
        return service.save(role);
    }

    @PutMapping("/{name}")
    public Role updateRole(@Valid @RequestBody Role role, @PathVariable("name") String roleName, BindingResult errors){
        Role roleUpdate = service.updateRole(role, roleName);
        return roleUpdate;
    }

    @GetMapping("/{name}")
    public Role findByName(@PathVariable("name") String roleName){
        return service.findByName(roleName);
    }
}
