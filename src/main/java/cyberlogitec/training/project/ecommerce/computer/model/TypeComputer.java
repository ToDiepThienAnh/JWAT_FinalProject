package cyberlogitec.training.project.ecommerce.computer.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_computer_type")
public class TypeComputer extends AbstractEntity {

    @NotBlank(message = "{computer.type.name.notblank")
    @Column(unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private Set<Computer> computers;
}
