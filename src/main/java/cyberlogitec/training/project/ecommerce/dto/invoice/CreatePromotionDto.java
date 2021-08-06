package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
public class CreatePromotionDto {
    @NotBlank(message = "promotion.name.notblank")
    private String name;

    @Max(value = 5000000, message = "{promotion.max-price.max")
    private BigDecimal maxPrice;

    @Min(value = 15000000, message = "{promotion.price-discount.min")
    private BigDecimal priceDiscount;

    @Min(value = 0, message = "{promotion.percentage-discount.min")
    @Max(value = 50, message = "{promotion.percentage-discount.max")
    private int percentageDiscount;
}
