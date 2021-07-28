package cyberlogitec.training.project.ecommerce.user.service;

import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        User userAdd = new User();
        userAdd.setUsername(user.getUsername());
        userAdd.setAddress(user.getAddress());
        userAdd.setAvatar(user.getAvatar());
        userAdd.setEmail(user.getEmail());
        userAdd.setFullname(user.getFullname());
        userAdd.setPassword(user.getPassword());
        userAdd.setStatus(user.getStatus());

        return repository.save(userAdd);
    }
}
