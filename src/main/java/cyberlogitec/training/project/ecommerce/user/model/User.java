package cyberlogitec.training.project.ecommerce.user.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ecommerce_user")
@Getter
@Setter
public class User extends AbstractEntity {
    @Column(unique = true)
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    private String fullname;

    private String password;

    private String avatar;

    @Column(unique = true)
    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "name")
    private Role role;
}
