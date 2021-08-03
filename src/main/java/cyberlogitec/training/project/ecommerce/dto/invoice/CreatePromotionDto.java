package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
public class CreatePromotionDto {
    private String name;

    @Max(value = 5000000)
    private BigDecimal maxPrice;

    @Min(value = 15000000)
    private BigDecimal priceDiscount;

    @Min(value = 0)
    @Max(value = 50)
    private int percentageDiscount;
}
