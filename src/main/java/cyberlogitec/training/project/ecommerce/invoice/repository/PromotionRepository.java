package cyberlogitec.training.project.ecommerce.invoice.repository;

import cyberlogitec.training.project.ecommerce.invoice.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    public Promotion findByCode(String code);

    public void deleteByCode(String code);
}
