package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class PurchasedComputer {
    List<ComputerAmount> computers = new LinkedList<>();

    private BigDecimal feeShip = new BigDecimal("200000");

}
