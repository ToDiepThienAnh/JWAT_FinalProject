package cyberlogitec.training.project.ecommerce.dto.user;

import cyberlogitec.training.project.ecommerce.user.annotation.CheckNumber;
import cyberlogitec.training.project.ecommerce.user.annotation.ConfirmPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ConfirmPassword(getConfirmPassword = "getConfirPassword")
public class RegisterDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    @NotBlank(message = "{user.phone.notblank}")
    @Size(message = "{user.phone.size}", min = 10, max = 11)
    @CheckNumber
    private String phone;

    @NotBlank(message = "{user.password.notblank}")
    private String password;

    @NotBlank(message = "{user.confirm-password.notblank")
    private String confirPassword;

    @Email
    @NotBlank(message = "{user.email.notblank")
    private String email;
}
