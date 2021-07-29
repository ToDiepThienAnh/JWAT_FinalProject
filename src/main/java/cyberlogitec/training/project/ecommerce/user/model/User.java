package cyberlogitec.training.project.ecommerce.user.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ecommerce_user")
@Getter
@Setter
public class User extends AbstractEntity {
    @Column(unique = true)
    @NotBlank(message = "{user.username.notblank}")
    private String username;

    private String fullname;

    private String password;

    private String avatar;

    @Column(unique = true)
    @NotBlank(message = "{user.email.notblank}")
    private String email;

    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
