package cyberlogitec.training.project.ecommerce.user.repository;

import cyberlogitec.training.project.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
