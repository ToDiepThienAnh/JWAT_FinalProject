package cyberlogitec.training.project.ecommerce.dto.computer;

import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.utils.ComputerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
public class ComputerDto {
    private String name;

    private String code;

    private String avatar;

    private String cpu;

    private String memory;

    private String screen;

    private String pin;

    private String graphicsCard;

    @Enumerated(EnumType.STRING)
    private ComputerStatus status;

    private BigDecimal price;

    private float discount;

    private CreateTypeComputerDto type;
}
