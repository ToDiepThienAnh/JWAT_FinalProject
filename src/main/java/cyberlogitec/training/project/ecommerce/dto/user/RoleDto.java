package cyberlogitec.training.project.ecommerce.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
public class RoleDto {
    @NotBlank(message = "{user.role.notblank}")
    private String name;
    private String description;
}
