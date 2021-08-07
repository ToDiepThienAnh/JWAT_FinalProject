package cyberlogitec.training.project.ecommerce.dto.computer;

import cyberlogitec.training.project.ecommerce.computer.utils.ComputerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateComputerDto {
    @NotBlank(message = "{computer.name.notblank")
    private String name;

    @NotBlank(message = "{computer.code.notblank")
    private String code;

    private String avatar;

    @NotBlank(message = "{computer.cpu.notblank")
    private String cpu;

    @NotBlank(message = "{computer.memory.notblank")
    private String memory;

    @NotBlank(message = "{computer.screen.notblank")
    private String screen;

    @NotBlank(message = "{computer.pin.notblank")
    private String pin;

    @NotBlank(message = "{computer.graphics-card.notblank")
    private String graphicsCard;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ComputerStatus status;

    @Min(value = 5000000, message = "{computer.price.min}")
    @NotBlank(message = "{computer.price.notblank")
    private BigDecimal price;

    @Min(value = 0, message = "{computer.discount.min}")
    @Max(value = 50, message = "{computer.discount.max")
    @NotBlank(message = "{computer.discount.notblank")
    private int discount;

    @NotBlank(message = "{type-computer.name.notblank")
    private String typeName;
}
