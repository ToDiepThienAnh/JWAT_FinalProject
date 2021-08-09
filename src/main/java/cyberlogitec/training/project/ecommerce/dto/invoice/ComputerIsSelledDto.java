package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ComputerIsSelledDto {
    private String name;

    private int amount;

    private BigDecimal price;
}
