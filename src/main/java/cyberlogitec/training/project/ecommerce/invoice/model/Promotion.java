package cyberlogitec.training.project.ecommerce.invoice.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_promotion")
public class Promotion extends AbstractEntity {
    @Column(unique = true)
    private String code;

    private String name;

    private BigDecimal maxPrice;

    private BigDecimal discountPrice;

    private int percentageDiscount;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private Set<Invoice> invoices;
}
