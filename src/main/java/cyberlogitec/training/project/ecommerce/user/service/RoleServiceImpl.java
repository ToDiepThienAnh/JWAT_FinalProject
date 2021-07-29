package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl extends GenericService<Role, Long> implements RoleService {
    private RoleRepository repository;



    @Override
    public Role updateRole(Role role, String roleName) {
        Role roleUpdate = repository.findByName(roleName);
        roleUpdate.setName(role.getName());
        roleUpdate.setDescription(role.getDescription());

        return roleUpdate;
    }

    @Override
    public Role findByName(String roleName) {
        return repository.findByName(roleName);
    }
}
