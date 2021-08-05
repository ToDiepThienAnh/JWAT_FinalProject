package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.invoice.PurchasedComputer;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;

public interface InvoiceService extends IGenericService<Invoice, Long> {
    public Invoice save(PurchasedComputer computers);
}
