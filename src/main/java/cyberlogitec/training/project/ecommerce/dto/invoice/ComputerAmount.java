package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ComputerAmount {
    @NotBlank(message = "computer.name.notblank")
    private String name;

    private int amount;

}
