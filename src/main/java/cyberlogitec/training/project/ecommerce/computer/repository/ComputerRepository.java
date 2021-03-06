package cyberlogitec.training.project.ecommerce.computer.repository;

import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    public Computer findByName(String name);

    public Computer findByCode(String code);

    public void deleteByCode(String code);
}
