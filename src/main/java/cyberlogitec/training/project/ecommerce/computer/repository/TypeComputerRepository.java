package cyberlogitec.training.project.ecommerce.computer.repository;

import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeComputerRepository extends JpaRepository<TypeComputer, Long> {
}
