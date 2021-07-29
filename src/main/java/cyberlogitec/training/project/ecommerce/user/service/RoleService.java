package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.user.model.Role;

public interface RoleService extends IGenericService<Role, Long> {
    public Role updateRole(Role role, String roleName);

    public Role findByName(String roleName);
}
