package cyberlogitec.training.project.ecommerce.invoice.model;

import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.invoice.utils.InvoiceDetailId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ecommerce_invoice_computer_detail")
@Getter
@Setter
public class InvoiceDetail implements Serializable {
    @EmbeddedId
    private InvoiceDetailId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("computer_id")
    private Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("invoice_id")
    private Invoice invoice;

    private int amount;
}


