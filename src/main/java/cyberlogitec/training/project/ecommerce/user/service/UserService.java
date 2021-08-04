package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.user.CreateUserDto;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends IGenericService<User, Long> {
    public List<User> getUserWithRole();

    public User save(CreateUserDto user);

    public boolean isEmailTaken(String email);

    public boolean isUsernameTaken(String username);
}
