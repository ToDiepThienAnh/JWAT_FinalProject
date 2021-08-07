package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.invoice.PurchasedComputer;
import cyberlogitec.training.project.ecommerce.dto.invoice.UpdateStatusInvoice;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;

public interface InvoiceService extends IGenericService<Invoice, Long> {
    public Invoice save(PurchasedComputer computers);

    public Invoice confirmSentInvoice(UpdateStatusInvoice code);

    public Invoice confrimCancelInvoice(UpdateStatusInvoice dto) throws Exception;

}
