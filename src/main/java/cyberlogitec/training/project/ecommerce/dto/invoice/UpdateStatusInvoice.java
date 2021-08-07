package cyberlogitec.training.project.ecommerce.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateStatusInvoice {
    @NotBlank(message = "{invoice.code.notblank")
    private String code;
}
