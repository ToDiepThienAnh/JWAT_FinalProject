package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.user.model.Role;

import java.util.List;

public interface RoleService extends IGenericService<Role, Long> {
    public Role updateRole(RoleDto role, String roleName);

    public Role save(RoleDto dto);

    public Role deleteByName(String name);

    public Role findByName(String roleName);

}
