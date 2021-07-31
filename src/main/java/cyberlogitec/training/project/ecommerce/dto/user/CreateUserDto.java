package cyberlogitec.training.project.ecommerce.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size", max = 8, min = 4)
    private String username;

    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    private String fullname;

    @NotBlank(message = "{user.userId.notblank}")
    private String userId;

    @NotBlank(message = "{user.role.name.notblank")
    private String roleName;

}
