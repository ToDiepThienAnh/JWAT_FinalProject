package cyberlogitec.training.project.ecommerce.invoice.utils;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class InvoiceDetailId implements Serializable {

    @Column(name = "invoice_id")
    private long invoiceId;

    @Column(name = "computer_id")
    private long computerId;
}
