package cyberlogitec.training.project.ecommerce.invoice.repository;

import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public Optional<Invoice> findByCode(String code);
}
