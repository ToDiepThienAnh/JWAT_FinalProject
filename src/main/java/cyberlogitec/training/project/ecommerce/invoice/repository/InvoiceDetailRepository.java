package cyberlogitec.training.project.ecommerce.invoice.repository;

import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
