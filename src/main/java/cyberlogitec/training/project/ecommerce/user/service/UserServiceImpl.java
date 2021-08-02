package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.dto.user.CreateUserDto;
import cyberlogitec.training.project.ecommerce.mybatis.mapper.IUserModuleMapper;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.RoleRepository;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl extends GenericService<User, Long> implements UserService {
    private IUserModuleMapper repository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUserWithRole() {
        return repository.getUserWithRole();
    }

    @Override
    public User save(CreateUserDto user) {
        User userAdd = new User();
        userAdd.setUsername(user.getUsername());
        userAdd.setPassword(passwordEncoder.encode("123"));
        userAdd.setUserId(user.getUserId());
        userAdd.setFullname(user.getFullname());
        userAdd.setStatus(UserStatus.ACTIVE);
        userAdd.setEmail(user.getEmail());
        Role role = roleRepository.findByName(user.getRoleName());
        userAdd.setRole(role);
        return userRepository.save(userAdd);
    }

}
