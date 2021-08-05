package cyberlogitec.training.project.ecommerce.invoice.repository;

import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
