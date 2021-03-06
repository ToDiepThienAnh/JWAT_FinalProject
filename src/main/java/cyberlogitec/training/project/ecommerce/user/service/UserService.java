package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.user.CreateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.RegisterDto;
import cyberlogitec.training.project.ecommerce.dto.user.UpdateUserDto;
import cyberlogitec.training.project.ecommerce.dto.user.UserWithRoleDto;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends IGenericService<User, Long> {
    public List<UserWithRoleDto> getUserWithRole();

    public User save(CreateUserDto user);

    public User save(RegisterDto register);

    public User update(UpdateUserDto user, String username);

    public void deleteByUsername(String username);

    public boolean isEmailTaken(String email);

    public boolean isUsernameTaken(String username);
}
