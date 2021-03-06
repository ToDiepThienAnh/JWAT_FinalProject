package cyberlogitec.training.project.ecommerce.user.repository;

import cyberlogitec.training.project.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);

    public void deleteByUsername(String username);

    public int countByUsername(String username);

    public int countByEmail(String email);
}
