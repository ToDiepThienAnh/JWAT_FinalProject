package cyberlogitec.training.project.ecommerce.user.repository;

import cyberlogitec.training.project.ecommerce.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
