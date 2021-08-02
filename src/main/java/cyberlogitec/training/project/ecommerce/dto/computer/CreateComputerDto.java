package cyberlogitec.training.project.ecommerce.dto.computer;

import cyberlogitec.training.project.ecommerce.computer.utils.ComputerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateComputerDto {
    private String name;

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

    @NotBlank(message = "{computer.type.name.notblank")
    private String typeName;
}
