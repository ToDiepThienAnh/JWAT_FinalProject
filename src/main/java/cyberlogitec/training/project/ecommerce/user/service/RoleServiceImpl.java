package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.mybatis.mapper.IUserModuleMapper;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl extends GenericService<Role, Long> implements RoleService {
    private RoleRepository repository;

    private IUserModuleMapper userRepository;

    @Override
    public Role updateRole(RoleDto role, String roleName) {
        Role roleUpdate = repository.findByName(roleName);
        if(roleUpdate == null)
            return null;
        roleUpdate.setName(role.getName());
        roleUpdate.setDescription(role.getDescription());

        return repository.save(roleUpdate);
    }

    @Override
    public Role save(RoleDto dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        return repository.save(role);
    }

    @Override
    public Role deleteByName(String name) {
        Role role = repository.findByName(name);
        if(role == null)
            return null;
        repository.deleteByName(name);
        return role;
    }

    @Override
    public Role findByName(String roleName) {
        return repository.findByName(roleName);
    }

}
