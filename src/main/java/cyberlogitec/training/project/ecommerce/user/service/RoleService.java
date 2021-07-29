package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.user.model.Role;

import java.util.List;

public interface RoleService extends IGenericService<Role, Long> {
    public Role updateRole(Role role, String roleName);

    public Role findByName(String roleName);

    public List<RoleDto> findAllRole();
}
