package cyberlogitec.training.project.ecommerce.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import cyberlogitec.training.project.ecommerce.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserWithRoleDto {
    @JsonFormat(pattern = DateUtils.DATE_FORMAT)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = DateUtils.DATE_FORMAT)
    private LocalDateTime updatedAt;

    private int version;

    private String createdBy;

    private String lastModifiedBy;

    private String username;

    @NotBlank(message = "{user.userId.notblank")
    private String userId;

    private String fullname;

    private String avatar;

    @JsonFormat(pattern = DateUtils.DATE)
    private LocalDateTime birthday;

    @Column(unique = true)
    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private RoleDto role;
}
