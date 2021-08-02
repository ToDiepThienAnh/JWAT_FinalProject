package cyberlogitec.training.project.ecommerce.dto.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateTypeComputerDto {
    @NotBlank(message = "{computer.type.name.notblank")
    @Column(unique = true)
    private String name;

    private String description;
}
