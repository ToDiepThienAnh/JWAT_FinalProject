package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RevenueOfMonthDto {
    private BigDecimal revenue;

    private int month;
}
