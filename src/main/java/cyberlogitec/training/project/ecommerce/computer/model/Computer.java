package cyberlogitec.training.project.ecommerce.computer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.computer.utils.ComputerStatus;
import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_computer")
public class Computer extends AbstractEntity {
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String code;

    private String avatar;

    private String cpu;

    private String memory;

    private String screen;

    private String pin;

    private String graphicsCard;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ComputerStatus status;

    @Min(value = 5000000)
    private BigDecimal price;

    private float discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "name")
    @NotNull
    private TypeComputer type;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<Comment> comments;


    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<InvoiceDetail> computers = new HashSet<>();
}
