package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.dto.user.CreateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.RegisterDto;
import cyberlogitec.training.project.ecommerce.dto.user.UpdateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.UserWithRoleDto;
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
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl extends GenericService<User, Long> implements UserService {
    private IUserModuleMapper repository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserWithRoleDto> getUserWithRole() {
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

    @Override
    public User save(RegisterDto register) {
        User newUser = new User();
        newUser.setEmail(register.getEmail());
        newUser.setUsername(register.getUsername());
        newUser.setPassword(passwordEncoder.encode(register.getPassword()));
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setPhone(register.getPhone());
        Role role = roleRepository.findByName("CUSTOMER");
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    @Override
    public User update(UpdateUserDto user, String username) {
        Optional<User> userUpdate = userRepository.findByUsername(username);
        if(userUpdate.isEmpty())
            return null;
        userUpdate.get().setUsername(user.getUsername());
        userUpdate.get().setPassword(passwordEncoder.encode(user.getPassword()));
        userUpdate.get().setUserId(user.getUserId());
        userUpdate.get().setFullname(user.getFullname());
        userUpdate.get().setStatus(user.getStatus());
        userUpdate.get().setPhone(user.getPhone());
        userUpdate.get().setEmail(user.getEmail());
        Role role = roleRepository.findByName(user.getRoleName());
        userUpdate.get().setRole(role);

        return userRepository.save(userUpdate.get());
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.countByEmail(email) >= 1;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.countByUsername(username) >= 1;
    }

}
