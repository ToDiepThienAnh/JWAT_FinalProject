package cyberlogitec.training.project.ecommerce.invoice.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Max(value = 5000000)
    private BigDecimal maxPrice;

    @Min(value = 15000000)
    private BigDecimal discountPrice;

    @Min(value = 0)
    @Max(value = 50)
    private int percentageDiscount;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private Set<Invoice> invoices;
}
