package cyberlogitec.training.project.ecommerce.invoice.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.invoice.utils.InvoiceStatus;
import cyberlogitec.training.project.ecommerce.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_invoice")
public class Invoice extends AbstractEntity {
    @Column(unique = true)
    private String code;

    private BigDecimal price;

    private LocalDateTime purchaseDate;

    private BigDecimal feeShip;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "code")
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private Set<InvoiceDetail> invoices = new HashSet<>();
}
